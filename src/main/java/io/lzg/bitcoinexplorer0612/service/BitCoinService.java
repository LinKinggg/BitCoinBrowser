package io.lzg.bitcoinexplorer0612.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitCoinService {

    String syncBlockData(String blockhash) throws Throwable;

    void syncBlockChainbyHash(String blockhash) throws Throwable;

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable;

    void syncDetail(JSONObject txJson, String txid) throws Throwable;

    void syncDetailVout(JSONArray vouts, String txid);

    void syncDetailVin(JSONArray vins, String txid) throws Throwable;
}
