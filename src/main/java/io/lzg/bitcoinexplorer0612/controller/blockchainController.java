package io.lzg.bitcoinexplorer0612.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.lzg.bitcoinexplorer0612.dao.BlockMapper;
import io.lzg.bitcoinexplorer0612.dto.BlockListDTO;
import io.lzg.bitcoinexplorer0612.po.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blockchain")
@CrossOrigin
public class blockchainController {

    @Autowired
    private BlockMapper blockMapper;

    //获取5条区块数据
    @GetMapping("/recent")
    public List<Block> search(){
        List<Block> block = blockMapper.selectRecentBlocks();
        return  block;
    }
//    @GetMapping("/recent")
//    public PageInfo search(@RequestParam(required = false,defaultValue = "1") Integer pageNum){
//        PageHelper.startPage(pageNum,5);
//        Page<Block> block = blockMapper.selectRecentBlocks();
//        PageInfo<Block> blockPageInfo = block.toPageInfo();
//        return  blockPageInfo;
//    }

    //获取所有区块
    @GetMapping("/getAll")
    public PageInfo<Block> getAll(@RequestParam(required = false,defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,5);
        Page<Block> blocks = (Page<Block>) blockMapper.selectAll();
        PageInfo<Block> blockPageInfo = blocks.toPageInfo();
        return blockPageInfo;
    }
}
