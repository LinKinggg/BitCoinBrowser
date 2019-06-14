package io.lzg.bitcoinexplorer0612.controller;

import io.lzg.bitcoinexplorer0612.dto.BlockGetDTO;
import io.lzg.bitcoinexplorer0612.dto.BlockListDTO;
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
        blockListDTO.setBlockhash("0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8");
        blockListDTO.setHeight(580689);
        blockListDTO.setSize(1115);
        blockListDTO.setTime(new Date());
        blockListDTO.setTxsize((short) 1818);

        BlockListDTO blockListDTO2 = new BlockListDTO();
        blockListDTO.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockListDTO.setHeight(580690);
        blockListDTO.setSize(1520);
        blockListDTO.setTime(new Date());
        blockListDTO.setTxsize((short) 1839);

        blockListDTOS.add(blockListDTO);
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
}
