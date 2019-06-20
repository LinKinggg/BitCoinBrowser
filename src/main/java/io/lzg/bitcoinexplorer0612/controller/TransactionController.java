package io.lzg.bitcoinexplorer0612.controller;

import io.lzg.bitcoinexplorer0612.dao.TransactionMapper;
import io.lzg.bitcoinexplorer0612.po.Block;
import io.lzg.bitcoinexplorer0612.po.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionMapper transactionMapper;

    //获取所有交易
    @GetMapping("/getAll")
    public List<Transaction> getAllByBlockhash(@RequestParam String blockhash){
        List<Transaction> transactions = transactionMapper.selectAllByBlockhash(blockhash);
        return  transactions;
    }
}
