package io.lzg.bitcoinexplorer0612.dao;

import io.lzg.bitcoinexplorer0612.po.TransactionDetail;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);

    //
    List<TransactionDetail> selectByAddress(String address);

    List<TransactionDetail> selectAll();

    List<TransactionDetail> getAllByAddress(String name);
}