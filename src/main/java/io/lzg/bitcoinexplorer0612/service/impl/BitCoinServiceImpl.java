package io.lzg.bitcoinexplorer0612.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.lzg.bitcoinexplorer0612.api.BitCoinJsonRpcApi;
import io.lzg.bitcoinexplorer0612.api.BitCoinRestApi;
import io.lzg.bitcoinexplorer0612.dao.BlockMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionDetailMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionMapper;
import io.lzg.bitcoinexplorer0612.enumutils.DetailType;
import io.lzg.bitcoinexplorer0612.po.Block;
import io.lzg.bitcoinexplorer0612.po.Transaction;
import io.lzg.bitcoinexplorer0612.po.TransactionDetail;
import io.lzg.bitcoinexplorer0612.service.BitCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BitCoinServiceImpl implements BitCoinService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitCoinRestApi bitcoinRestApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Autowired
    private BitCoinJsonRpcApi bitCoinJsonRpcApi;

    @Override
    @Transactional
    public String syncBlockData(String blockhash) throws Throwable {
        JSONObject blockJson = bitcoinRestApi.getBlock(blockhash);
        Block block = new Block();
        block.setBlockhash(blockJson.getString("hash"));
        block.setHeight(blockJson.getInteger("height"));
        Long timestamp = blockJson.getLong("time");
        Date time = new Date(timestamp * 1000);
        block.setTime(time);
        block.setSize(blockJson.getInteger("size"));
        block.setTxsize(blockJson.getShort("nTx"));
        block.setWeight(blockJson.getFloat("weight"));
        block.setPrevBlock(blockJson.getString("previousblockhash"));
        block.setNextBlock(blockJson.getString("nextblockhash"));
        Integer confirmations = blockJson.getInteger("confirmations");
        block.setDifficulty(blockJson.getDouble("difficulty"));
        blockMapper.insert(block);
        //tx数组
        JSONArray txesArray = blockJson.getJSONArray("tx");
        for (Object txObj : txesArray) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) txObj);
            syncTx(jsonObject, blockhash, time, confirmations);
        }
        return block.getNextBlock();
    }

    @Override
    @Async
    public void syncBlockChainbyHash(String blockhash) throws Throwable {
        logger.info("start to sync blockchain from {}", blockhash);
        String blockhashTemp = blockhash;
        while (blockhashTemp != null && !blockhashTemp.isEmpty()){
            String nextBlock = syncBlockData(blockhashTemp);
            blockhashTemp = nextBlock;
        }
        logger.info("end sync blockchain");
    }


    @Override
    @Transactional
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable {
        Transaction tx = new Transaction();
        String txid = txJson.getString("txid");
        tx.setTxhash(txid);
        tx.setBlockhash(blockhash);
        tx.setTime(time);
        tx.setSize(txJson.getInteger("size"));
        tx.setWeight(txJson.getFloat("weight"));
        tx.setConfirmations(confirmations);
        transactionMapper.insert(tx);

        syncDetail(txJson, txid);
    }

    @Override
    @Transactional
    public void syncDetail(JSONObject txJson, String txid) throws Throwable {

        JSONArray vouts = txJson.getJSONArray("vout");
        syncDetailVout(vouts, txid);

        JSONArray vins = txJson.getJSONArray("vin");
        syncDetailVin(vins, txid);
    }

    @Override
    @Transactional
    public void syncDetailVout(JSONArray vouts, String txid) {
        for (Object vout : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vout);
            TransactionDetail transactionDetail = new TransactionDetail();
            transactionDetail.setTxhash(txid);
            //ordinal()让列自动增长
            transactionDetail.setType((byte) DetailType.Receive.ordinal());
            transactionDetail.setAmount(jsonObject.getDouble("value"));
            JSONArray addresses = jsonObject.getJSONArray("addresses");
            if (addresses != null){
                String addressesString = addresses.getString(0);
                transactionDetail.setAddress(addressesString);
            }
            transactionDetailMapper.insert(transactionDetail);
        }
    }

    @Override
    @Transactional
    public void syncDetailVin(JSONArray vins, String txid) throws Throwable {
        for (Object vinObj : vins) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vinObj);
            String vintxid = jsonObject.getString("txid");

            Integer voutnum = jsonObject.getInteger("vout");

            if (vintxid != null){
                JSONObject vinTxJson = bitCoinJsonRpcApi.getTransactionById(vintxid);
                JSONArray vouts = vinTxJson.getJSONArray("vout");
                JSONObject utxoJson = vouts.getJSONObject(voutnum);

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setAmount(-utxoJson.getDouble("value"));
                transactionDetail.setTxhash(txid);
                transactionDetail.setType((byte) DetailType.Send.ordinal());
                JSONObject scriptPubKey = utxoJson.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if (addresses != null){
                    String address = addresses.getString(0);
                    transactionDetail.setAddress(address);
                }
                transactionDetailMapper.insert(transactionDetail);
            }

        }
    }
}
