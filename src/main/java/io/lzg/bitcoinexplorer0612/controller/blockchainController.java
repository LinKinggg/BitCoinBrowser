package io.lzg.bitcoinexplorer0612.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.lzg.bitcoinexplorer0612.dao.BlockMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionDetailMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionMapper;
import io.lzg.bitcoinexplorer0612.dto.BlockGetDTO;
import io.lzg.bitcoinexplorer0612.dto.BlockListDTO;
import io.lzg.bitcoinexplorer0612.po.Block;
import io.lzg.bitcoinexplorer0612.po.Transaction;
import io.lzg.bitcoinexplorer0612.po.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blockchain")
@CrossOrigin
public class blockchainController {

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    //获取5条区块数据
    @GetMapping("/recent")
    public List<Block> search(){
        List<Block> block = blockMapper.selectRecentBlocks();
        return  block;
    }

    //获取所有区块
    @GetMapping("/getAll")
    public PageInfo<Block> getAll(@RequestParam(required = false,defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,5);
        Page<Block> blocks = (Page<Block>) blockMapper.selectAll();
        PageInfo<Block> blockPageInfo = blocks.toPageInfo();
        return blockPageInfo;
    }

    @GetMapping("/getAllByHeight")
    public PageInfo<BlockGetDTO> getAllByHeight(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                                @RequestParam(required = false,defaultValue = "1")String height){
        PageHelper.startPage(pageNum,5);
        Page<BlockGetDTO> blocks = (Page<BlockGetDTO>) blockMapper.selectAllByHeight(height);
        PageInfo<BlockGetDTO> blockPageInfo = blocks.toPageInfo();
        return blockPageInfo;
    }

    @GetMapping("/search")
    public Object search(@RequestParam(required = false)String name) throws Throwable {
        if(name != null){
            if(name.length()<8){
                List<BlockGetDTO> hight = blockMapper.selectAllByHeight(name);
                if(hight != null){
                    return hight;
                }
                return  hight;
            }else if(name.length()>10 && name.length() < 50){
                List<TransactionDetail> address = transactionDetailMapper.getAllByAddress(name);
                return  address;
            }else if(name.length()==64){
                List<BlockGetDTO> Blockhash = blockMapper.getAllByBlockhash(name);
                if(Blockhash.size() != 0){
                    return  Blockhash;
                }
                List<Transaction> transactions = transactionMapper.getAllByTxhash(name);
                if(transactions  != null){
                    return  transactions;
                }
            }
        }
        return null;
    }
}
