package io.lzg.bitcoinexplorer0612.dao;

import com.github.pagehelper.Page;
import io.lzg.bitcoinexplorer0612.dto.BlockGetDTO;
import io.lzg.bitcoinexplorer0612.po.Block;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    //最近区块
    Page<Block> selectRecentBlocks();

    //获取所有
    List<Block> selectAll();

    List<BlockGetDTO> selectAllByHeight(String height);

    List<BlockGetDTO> getAllByBlockhash(String name);
}