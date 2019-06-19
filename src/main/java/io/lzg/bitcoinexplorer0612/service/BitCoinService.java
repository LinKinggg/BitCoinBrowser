package io.lzg.bitcoinexplorer0612.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitCoinService {

    void syncBlockData(String blockhash);

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations);

    void syncDetail(JSONObject txJson);

    void syncDetailVout(JSONArray vouts);

    void syncDetailVin(JSONArray vins);
}
