package io.lzg.bitcoinexplorer0612.controller;

import io.lzg.bitcoinexplorer0612.dao.TransactionDetailMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionMapper;
import io.lzg.bitcoinexplorer0612.po.Transaction;
import io.lzg.bitcoinexplorer0612.po.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactionDetail")
public class TransactionDetailController {

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    //获取所有交易详情
    @GetMapping("/getAll")
    public List<TransactionDetail> getAll(){
        List<TransactionDetail> transactionDetails = transactionDetailMapper.selectAll();
        return  transactionDetails;
    }

    // 通过Address查询交易详情表的所有数据
    @GetMapping("/getAllByAddress")
    public List<TransactionDetail> getAllByAddress(String address){
        List<TransactionDetail> addresses = transactionDetailMapper.getAllByAddress(address);
        return addresses;
    }
}
