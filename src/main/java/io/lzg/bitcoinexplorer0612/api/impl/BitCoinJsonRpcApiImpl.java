package io.lzg.bitcoinexplorer0612.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import io.lzg.bitcoinexplorer0612.api.BitCoinJsonRpcApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Component
public class BitCoinJsonRpcApiImpl implements BitCoinJsonRpcApi{

    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitCoinJsonRpcApiImpl(@Value("${bitcoin.jsonrpc.username}") String username,
                                 @Value("${bitcoin.jsonrpc.password}") String password,
                                 @Value("${bitcoin.jsonrpc.url}") String url) throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s",username,password);
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url),headers);
    }

    @Override
    public JSONObject getBlockchainInfo() throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getBlockByHash(String blockhash) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblock", new Object[]{blockhash}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getTransactionById(String txid) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public String getBlockhashByHeight(Integer height) throws Throwable {
        String result = jsonRpcHttpClient.invoke("getblockhash", new Object[]{height}, String.class);
        return result;
    }

    @Override
    public Double getBalance(String address) throws Throwable {
        JSONArray balances = jsonRpcHttpClient.invoke("listunspent", new Object[]{6, 9999999, new String[]{address}}, JSONArray.class);
        JSONObject balance = balances.getJSONObject(0);
        Double amount = balance.getDouble("amount");
        return amount;
    }

    @Override
    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        JSONObject rawTransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return rawTransaction;
    }

    @Override
    public String getBestBlockhash() throws Throwable {
        String bestblockhash = jsonRpcHttpClient.invoke("getbestblockhash", new Object[]{}, String.class);
        return bestblockhash;
    }
}
