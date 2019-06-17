package io.lzg.bitcoinexplorer0612.controller;

import com.alibaba.fastjson.JSONObject;
import io.lzg.bitcoinexplorer0612.api.BitCoinRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempController {

    @Autowired
    private BitCoinRestApi bitcoinRestApi;

    @GetMapping("/test")
    public String test(){
//        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
//        JSONObject blockNoTxDetails = bitcoinRestApi.getBlockNoTxDetails("00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
//        JSONObject blockheaders = bitcoinRestApi.getBlockheaders("00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
//        JSONObject mempool = bitcoinRestApi.getMempool();
        JSONObject mempooltransactions = bitcoinRestApi.getMempooltransactions();
//        JSONObject blockByHeight = bitcoinRestApi.getBlockByHeight("15805");
//        JSONObject blockByHash = bitcoinRestApi.getBlockByHash("00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
//        JSONObject utxo = bitcoinRestApi.getUTXO("00000000000003e333bb47e37002a1ee53f24f1f2613dbb57e848d128413ceb4");
        return mempooltransactions.toJSONString();
    }
}
