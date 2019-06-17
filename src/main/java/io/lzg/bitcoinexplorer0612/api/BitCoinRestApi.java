package io.lzg.bitcoinexplorer0612.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BitCoinRestApi", url = "http://localhost:18332")
public interface BitCoinRestApi {

    @GetMapping("/rest/chaininfo.json")
    JSONObject getBlockChainInfo();

    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getBlockNoTxDetails(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/tx/{txhash}.json")
    JSONObject getBlockByHash(@PathVariable(value = "txhash") String txhash);

    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    JSONObject getBlockheaders(@PathVariable(value = "count")Integer count, @PathVariable(value = "blockhash")String blockhash);

    @GetMapping("/rest/blockhashbyheight/{height}.json")
    JSONObject getBlockByHeight(@PathVariable(value = "height") String height);

    @GetMapping("/rest/getutxos/checkmempool/{blockhash}.json 2>/dev/null | json_pp")
    JSONObject getUTXO(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getMempool();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getMempooltransactions();
}
