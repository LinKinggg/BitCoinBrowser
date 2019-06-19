package io.lzg.bitcoinexplorer0612.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.lzg.bitcoinexplorer0612.api.BitCoinRestApi;
import io.lzg.bitcoinexplorer0612.dao.BlockMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionDetailMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionMapper;
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

    @Override
    @Async
    @Transactional
    public void syncBlockData(String blockhash) {
        logger.info("start to sync block from {}", blockhash);
        String Blockhashtemp = blockhash;
        while (Blockhashtemp != null && !Blockhashtemp.isEmpty()){
            JSONObject blockJson = bitcoinRestApi.getBlock(Blockhashtemp);
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
                syncTx(jsonObject, Blockhashtemp, time, confirmations);
            }
            Blockhashtemp = block.getNextBlock();
        }
        logger.info("end sync block");
    }

    @Override
    @Async
    @Transactional
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) {
        logger.info("start to sync Tx from {}", blockhash);
        Transaction tx = new Transaction();
        tx.setTxhash(txJson.getString("txid"));
        tx.setBlockhash(blockhash);
        tx.setTime(time);
        tx.setSize(txJson.getInteger("size"));
        tx.setWeight(txJson.getFloat("weight"));
        tx.setConfirmations(confirmations);
        transactionMapper.insert(tx);

        syncDetail(txJson);

        logger.info("end sync Tx");
    }

    @Override
    @Async
    @Transactional
    public void syncDetail(JSONObject txJson) {
        logger.info("start to sync Detail from {}", txJson);
        TransactionDetail txd = new TransactionDetail();
        txd.setTxDetailId(txJson.getLong("txDetailId"));
        txd.setTxhash(txJson.getString("txhash"));
        txd.setAddress(txJson.getString("address"));
        txd.setAmount(txJson.getDouble("amount"));
        txd.setType(txJson.getByte("type"));
        transactionDetailMapper.insert(txd);
        logger.info("end sync Detail");
    }

    @Override
    @Async
    @Transactional
    public void syncDetailVout(JSONArray vouts) {
        logger.info("start to sync DetailVout from {}", vouts);
        logger.info("end sync DetailVout");
    }

    @Override
    @Async
    @Transactional
    public void syncDetailVin(JSONArray vins) {
        logger.info("start to sync DetailVin from {}", vins);
        logger.info("end sync DetailVin");
    }
}
