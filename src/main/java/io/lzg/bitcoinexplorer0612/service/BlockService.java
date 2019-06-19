package io.lzg.bitcoinexplorer0612.service;

import io.lzg.bitcoinexplorer0612.dto.BlockGetDTO;
import io.lzg.bitcoinexplorer0612.dto.BlockListDTO;
import io.lzg.bitcoinexplorer0612.po.Transaction;
import io.lzg.bitcoinexplorer0612.po.TransactionDetail;

import java.util.ArrayList;
import java.util.List;

public interface BlockService {

    //获取最近区块
    List<BlockListDTO> getRecentBlocks();

    List<BlockGetDTO> getByBlockhash(String blockhash);

    List<Transaction> getByHeight(String height);

    ArrayList<TransactionDetail> getByAddress(String address);
}
