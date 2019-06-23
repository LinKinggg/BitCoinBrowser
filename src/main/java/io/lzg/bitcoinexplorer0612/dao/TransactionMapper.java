package io.lzg.bitcoinexplorer0612.dao;

import io.lzg.bitcoinexplorer0612.po.Block;
import io.lzg.bitcoinexplorer0612.po.Transaction;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    //

    List<Block> selectByBlockhash(String blockhash);

    List<Block> selectByHeight(String height);

    List<Transaction> selectAll();

    List<Transaction> selectAllByBlockhash();

    List<Transaction> getAllByTxhash(String name);
}