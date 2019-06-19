package io.lzg.bitcoinexplorer0612.service.impl;

import io.lzg.bitcoinexplorer0612.dao.BlockMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionDetailMapper;
import io.lzg.bitcoinexplorer0612.dao.TransactionMapper;
import io.lzg.bitcoinexplorer0612.dto.BlockGetDTO;
import io.lzg.bitcoinexplorer0612.dto.BlockListDTO;
import io.lzg.bitcoinexplorer0612.po.Block;
import io.lzg.bitcoinexplorer0612.po.TransactionDetail;
import io.lzg.bitcoinexplorer0612.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService{

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    //实现获取最近区块接口
    @Override
    public List<BlockListDTO> getRecentBlocks() {
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList();
        List<Block> blocks = blockMapper.selectRecentBlocks();
        for (Block block : blocks) {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(block.getBlockhash());
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxsize(block.getTxsize());
            blockListDTO.setSize(block.getSize());
            blockListDTOS.add(blockListDTO);
        }
        return blockListDTOS;
    }

    //实现通过hash获取交易信息接口
    @Override
    public List<BlockGetDTO> getByBlockhash(String blockhash) {
        ArrayList<BlockGetDTO> blockGetDTOS = new ArrayList<>();
        List<Block> blocks = transactionMapper.selectByBlockhash(blockhash);
        for (Block block : blocks) {
            BlockGetDTO blockGetDTO = new BlockGetDTO();
            blockGetDTO.setBlockhash(block.getBlockhash());
            blockGetDTO.setTxSize(block.getTxsize());
            blockGetDTO.setTime(block.getTime().getTime());
            blockGetDTO.setSize(block.getSize());
            blockGetDTO.setPrevBlcok(block.getPrevBlock());
            blockGetDTO.setNextBlock(block.getNextBlock());
            blockGetDTO.setHeight(block.getHeight());
            blockGetDTO.setDifficulty(block.getDifficulty());
            blockGetDTOS.add(blockGetDTO);
        }
        return blockGetDTOS;
    }

    //实现通过height获取区块接口
    @Override
    public ArrayList<BlockGetDTO> getByHeight(String height) {
        ArrayList<BlockGetDTO> blockGetDTOS = new ArrayList<>();
        List<Block> blocks = transactionMapper.selectByHeight(height);
        for (Block block : blocks) {
            BlockGetDTO blockGetDTO = new BlockGetDTO();
            blockGetDTO.setBlockhash(block.getBlockhash());
            blockGetDTO.setTxSize(block.getTxsize());
            blockGetDTO.setTime(block.getTime().getTime());
            blockGetDTO.setSize(block.getSize());
            blockGetDTO.setPrevBlcok(block.getPrevBlock());
            blockGetDTO.setNextBlock(block.getNextBlock());
            blockGetDTO.setHeight(block.getHeight());
            blockGetDTO.setDifficulty(block.getDifficulty());
            blockGetDTOS.add(blockGetDTO);
        }
        return blockGetDTOS;
    }

    //实现通过address获取交易信息接口
    @Override
    public ArrayList<TransactionDetail> getByAddress(String address) {
        ArrayList<TransactionDetail> transactionAddressDTOS = new ArrayList<>();
        List<TransactionDetail> transactionDetails = transactionDetailMapper.selectByAddress(address);
        for (TransactionDetail transactionDetail : transactionDetails) {
            TransactionDetail transactionDetail1 = new TransactionDetail();
            transactionDetail1.setTxDetailId(transactionDetail.getTxDetailId());
            transactionDetail1.setTxhash(transactionDetail.getTxhash());
            transactionDetail1.setAddress(transactionDetail.getAddress());
            transactionDetail1.setAmount(transactionDetail.getAmount());
            transactionDetail1.setType(transactionDetail.getType());
            transactionAddressDTOS.add(transactionDetail1);
        }
        return transactionAddressDTOS;
    }
}
