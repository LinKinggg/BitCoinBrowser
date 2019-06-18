package io.lzg.bitcoinexplorer0612.api;

import com.alibaba.fastjson.JSONObject;

public interface BitCoinJsonRpcApi {

    JSONObject getBlockchainInfo() throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;

    JSONObject getTransactionById(String txid) throws Throwable;

    String getBlockhashByHeight(Integer height) throws Throwable;

    Double getBalance(String address) throws Throwable;

    JSONObject getRawTransaxtion(String txid) throws Throwable;

    String getBestBlockhash() throws Throwable;
}
