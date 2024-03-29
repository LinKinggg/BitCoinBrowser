package io.lzg.bitcoinexplorer0612.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.lzg.bitcoinexplorer0612.api.BitCoinJsonRpcApi;
import io.lzg.bitcoinexplorer0612.api.BitCoinRestApi;
import io.lzg.bitcoinexplorer0612.service.BitCoinService;
import io.lzg.bitcoinexplorer0612.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {

    @Autowired
    private BitCoinRestApi bitcoinRestApi;

    @Autowired
    private BitCoinJsonRpcApi bitCoinJsonRpcApi;

    @Autowired
    private BitCoinService bitCoinService;

    @Autowired
    private BlockService blockService;

    @GetMapping("/test")
    public String test() throws Throwable {
        //bitcoinRestApi测试接口
//        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
//        JSONObject blockNoTxDetails = bitcoinRestApi.getBlockNoTxDetails("00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
//        JSONArray blockheaders = bitcoinRestApi.getBlockheaders(5, "00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
//        JSONObject mempool = bitcoinRestApi.getMempool();
//        JSONObject mempooltransactions = bitcoinRestApi.getMempooltransactions();
//        JSONObject blockByHeight = bitcoinRestApi.getBlockByHeight("15805");
//        JSONObject blockByHash = bitcoinRestApi.getBlockByHash("00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
//        JSONObject utxo = bitcoinRestApi.getUTXO("1d7d5226bb2d39e328262e9816694458d2ae081af6e380790bdc00b968ce0daf", 0);
        //bitCoinJsonRpcApi测试接口
//        JSONObject blockchainInfo = bitCoinJsonRpcApi.getBlockchainInfo();
//        JSONObject blockByHash = bitCoinJsonRpcApi.getBlockByHash("00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
//        String blockhashByHeight = bitCoinJsonRpcApi.getBlockhashByHeight(0);
//        JSONObject transactionById = bitCoinJsonRpcApi.getTransactionById("e85e44953e1b719fd6a23f0de0c832f7679b432280ce8600102fd55b59f46e47");
//        String bestBlockhash = bitCoinJsonRpcApi.getBestBlockhash();
//        Double balance = bitCoinJsonRpcApi.getBalance("2N1dr4bUZ18U2ZxRwindBkq6HFNFfMnvMLh");
//        JSONObject rawTransaxtion = bitCoinJsonRpcApi.getRawTransaxtion("1d7d5226bb2d39e328262e9816694458d2ae081af6e380790bdc00b968ce0daf");
        //同步到数据库
//        bitCoinService.syncBlockData("000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943");
        //获取最近区块
//        blockService.getRecentBlocks();
//        bitCoinService.syncTx("","",new Date(),1);
//        bitCoinService.syncDetail("");
//        bitCoinService.syncBlockChainbyHash("0000000000007269a38df4cf2507eb886bc972e611b8130ac193b72a55ea66a7");
        return null;
    }
}
