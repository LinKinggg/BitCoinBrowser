package io.lzg.bitcoinexplorer0612.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.lzg.bitcoinexplorer0612.dao.TransactionMapper;
import io.lzg.bitcoinexplorer0612.po.Block;
import io.lzg.bitcoinexplorer0612.po.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionMapper transactionMapper;

    //获取所有交易
    @GetMapping("/getAll")
    public PageInfo<Transaction> getAllByBlockhash(@RequestParam(required = false,defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,5);
        Page<Transaction> transactions = (Page<Transaction>) transactionMapper.selectAllByBlockhash();
        PageInfo<Transaction> transactionPageInfo = transactions.toPageInfo();
        return  transactionPageInfo;
    }

    // 通过交易的hash来进行页面的详情查找
    @GetMapping("/transactionHash")
    public List<Transaction>  transactionHash(String txhash){
        List<Transaction>  transactionsHash = transactionMapper.getAllByTxhash(txhash);
        return transactionsHash;
    }
}
