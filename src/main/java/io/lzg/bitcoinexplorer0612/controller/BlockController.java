package io.lzg.bitcoinexplorer0612.controller;

import io.lzg.bitcoinexplorer0612.dto.BlockGetDTO;
import io.lzg.bitcoinexplorer0612.dto.BlockListDTO;
import io.lzg.bitcoinexplorer0612.po.Transaction;
import io.lzg.bitcoinexplorer0612.po.TransactionDetail;
import io.lzg.bitcoinexplorer0612.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks(){
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();
        List<BlockListDTO> recentBlocks = blockService.getRecentBlocks();
        return blockListDTOS;
    }

    @GetMapping("/getByBlockhash")
    public ArrayList<BlockGetDTO> getByBlockhash(@RequestParam String blockhash){
        ArrayList<BlockGetDTO> blockGetDTO = new ArrayList<>();
        List<BlockGetDTO> byBlockhash = blockService.getByBlockhash("");
        return blockGetDTO;
    }

    @GetMapping("/getByHeight")
    public ArrayList<Transaction> getByHeight(@RequestParam String height){
        ArrayList<Transaction> transactions = new ArrayList<>();
        List<Transaction> byHeight = blockService.getByHeight("");
        return transactions;
    }

    @GetMapping("/getByPrevBlcok")
    public BlockGetDTO getByPrevBlcok(@RequestParam String prevBlock){
//
        BlockGetDTO blockGetDTO = new BlockGetDTO();
//        blockGetDTO.setBlockhash("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
//        blockGetDTO.setDifficulty(7409399249090.25);
//        blockGetDTO.setFees(1773.224);
//        blockGetDTO.setHeight(580688);
//        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
//        blockGetDTO.setNextBlock("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
//        blockGetDTO.setPrevBlcok("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
//        blockGetDTO.setSize(1115);
//        blockGetDTO.setTime(new Date().getTime());
//        blockGetDTO.setTxSize((short) 1818);

        return blockGetDTO;
    }

    @GetMapping("/getByNextBlcok")
    public BlockGetDTO getByNextBlcok(@RequestParam String nextBlock){
//
        BlockGetDTO blockGetDTO = new BlockGetDTO();
//        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
//        blockGetDTO.setDifficulty(7409399249090.25);
//        blockGetDTO.setFees(1225.464);
//        blockGetDTO.setHeight(580690);
//        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
//        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
//        blockGetDTO.setPrevBlcok("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
//        blockGetDTO.setSize(1250);
//        blockGetDTO.setTime(new Date().getTime());
//        blockGetDTO.setTxSize((short) 1834);

        return blockGetDTO;
    }

    @GetMapping("/getByAddress")
    public ArrayList<TransactionDetail> getByAddress(@RequestParam String address){
        ArrayList<TransactionDetail> blockListDTOS = new ArrayList<>();
        ArrayList<TransactionDetail> byAddress = blockService.getByAddress("");
        return blockListDTOS;
    }
}
