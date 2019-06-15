package io.lzg.bitcoinexplorer0612.controller;

import io.lzg.bitcoinexplorer0612.dto.BlockGetDTO;
import io.lzg.bitcoinexplorer0612.dto.BlockListDTO;
import io.lzg.bitcoinexplorer0612.dto.TransactionAddressDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks(){
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();

        BlockListDTO blockListDTO = new BlockListDTO();
        blockListDTO.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");
        blockListDTO.setHeight(580688);
        blockListDTO.setSize(1773);
        blockListDTO.setTime(new Date());
        blockListDTO.setTxsize((short) 1869);

        BlockListDTO blockListDTO2 = new BlockListDTO();
        blockListDTO2.setBlockhash("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
        blockListDTO2.setHeight(580689);
        blockListDTO2.setSize(1115);
        blockListDTO2.setTime(new Date());
        blockListDTO2.setTxsize((short) 1818);

        BlockListDTO blockListDTO3 = new BlockListDTO();
        blockListDTO3.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockListDTO3.setHeight(580690);
        blockListDTO3.setSize(1520);
        blockListDTO3.setTime(new Date());
        blockListDTO3.setTxsize((short) 1839);



        blockListDTOS.add(blockListDTO);
        blockListDTOS.add(blockListDTO2);
        blockListDTOS.add(blockListDTO3);
        return blockListDTOS;
    }

    @GetMapping("/getByBlockhash")
    public BlockGetDTO getByBlockhash(@RequestParam String blockhash){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
        blockGetDTO.setDifficulty(7409399249090.25);
        blockGetDTO.setFees(8766.38);
        blockGetDTO.setHeight(580689);
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        blockGetDTO.setSize(1115);
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setTxSize((short) 1818);

        return blockGetDTO;
    }

    @GetMapping("/getByHeight")
    public BlockGetDTO getByHeight(@RequestParam Integer height){

        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockGetDTO.setHeight(580643);
        blockGetDTO.setPrevBlcok("00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setFees(8766.38);
        blockGetDTO.setTxSize((short) 2702);
        blockGetDTO.setSize(1115);
        blockGetDTO.setDifficulty(7409399249090.25);

        return blockGetDTO;
    }

    @GetMapping("/getByPrevBlcok")
    public BlockGetDTO getByPrevBlcok(@RequestParam String prevBlock){

        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
        blockGetDTO.setDifficulty(7409399249090.25);
        blockGetDTO.setFees(1773.224);
        blockGetDTO.setHeight(580688);
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setNextBlock("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
        blockGetDTO.setPrevBlcok("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
        blockGetDTO.setSize(1115);
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setTxSize((short) 1818);

        return blockGetDTO;
    }

    @GetMapping("/getByNextBlcok")
    public BlockGetDTO getByNextBlcok(@RequestParam String nextBlock){

        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockGetDTO.setDifficulty(7409399249090.25);
        blockGetDTO.setFees(1225.464);
        blockGetDTO.setHeight(580690);
        blockGetDTO.setMerkleRoot("07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798");
        blockGetDTO.setNextBlock("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockGetDTO.setPrevBlcok("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
        blockGetDTO.setSize(1250);
        blockGetDTO.setTime(new Date().getTime());
        blockGetDTO.setTxSize((short) 1834);

        return blockGetDTO;
    }

    @GetMapping("/getByAddress")
    public TransactionAddressDTO getByAddress(@RequestParam Long txDetailId){

        TransactionAddressDTO transactionAddressDTO = new TransactionAddressDTO();
        transactionAddressDTO.setTxDetailId((long) 1);
        transactionAddressDTO.setAddress("3E7xRXhednyKBGozD5BEC5jiyvzRaPzY1L");
        transactionAddressDTO.setAmount(132.90157587);
        transactionAddressDTO.setTxhash("8858fc91e6d7d5e86b2a79909ae2da1bf1ef1a46");
        transactionAddressDTO.setType((byte) 1);

        return transactionAddressDTO;
    }
}
