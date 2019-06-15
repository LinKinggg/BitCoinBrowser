## 一、 获取当前最新区块

method：GET  
url: /block/getRecentBlocks

response:
```json
[
    {
        "blockhash": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "height": 580688,
        "size": 1773,
        "time": "2019-06-14T08:28:23.750+0000",
        "txsize": 1869
    },
    {
        "blockhash": "0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8",
        "height": 580689,
        "size": 1115,
        "time": "2019-06-14T08:28:23.750+0000",
        "txsize": 1818
    },
    {
        "blockhash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
        "height": 580690,
        "size": 1520,
        "time": "2019-06-14T08:28:23.750+0000",
        "txsize": 1839
    }
]
```

| ResponseField    |    Type   |   Description   | 
| :--------------: | :--------:| :-------------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    size|   Integer |  区块大小 |
|    time|   Date |  出块时间 |
|    txsize|   Short |  交易数量 |





  
## 二、 根据区块hash获取区块详情

method：GET  
url: /block/getByBlockhash?blockhash={blockhash}

response:
```json
{
    "blockhash": "0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8",
    "difficulty": 7409399249090.25,
    "fees": 8766.38,
    "height": 580689,
    "merkleRoot": "07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798",
    "prevBlcok": "00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "nextBlock": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
    "size": 1115,
    "time": 1560502355355,
    "txSize": 1818,
    "outputTotal": null
}
```

| ResponseField    |     Type  |   Description   | 
| :--------------: | :--------:| :-------------: |
|    blockhash|   String |  区块hash |
|    difficulty|   Double |  难度系数 |
|    fees|   Double |  交易费用 |
|    height|   Integer |  区块高度 |
|    merkleRoot|   String |  梅尔克树 |
|    prevBlcok|   String | 前一个区块 |
|    nextBlock|   String |  后一个区块 |
|    size|   Integer |  区块大小 |
|    time|   Long |  出块时间 |
|    txSize|   Short |  交易数量 |
|    outputTotal|   Double |  总输出 |

  
  
  

## 三、 根据区块高度获取区块详情

method：GET  
url: /block/getByHeight?height={height}

response:
```json
{
    "blockhash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
    "height": 580689,
    "prevBlcok": "00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "nextBlock": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
    "merkleRoot": "07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798",
    "time": 1560502355355,
    "txSize": 1818,
    "size": 1520,
    "fees": 8766.38,
    "difficulty": 7409399249090.25,
    "outputTotal": null
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    prevBlcok|   String | 前一个区块 |
|    nextBlock|   String |  后一个区块 |
|    merkleRoot|   String |  梅尔克树 |
|    time|   Long |  出块时间 |
|    txSize|   Short |  交易数量 |
|    size|   Integer |  区块大小 |
|    fees|   Double |  交易费用 |
|    difficulty|   Double |  难度系数 |
|    outputTotal|   Double |  总输出 |

## 四、 根据prevHash获取区块详情

method：GET  
url: /block/getByPrevBlcok?prevhash={prevhash}

response:
```json
{
    "blockhash": "0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8",
    "difficulty": 7409399249090.25,
    "fees": 1773.224,
    "height": 580688,
    "merkleRoot": "07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798",
    "prevBlcok": "0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8",
    "nextBlock": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
    "size": 1115,
    "time": 1560502355355,
    "txSize": 1818,
    "outputTotal": null
}
```

| ResponseField    |     Type  |   Description   | 
| :--------------: | :--------:| :-------------: |
|    blockhash|   String |  区块hash |
|    difficulty|   Double |  难度系数 |
|    fees|   Double |  交易费用 |
|    height|   Integer |  区块高度 |
|    merkleRoot|   String |  梅尔克树 |
|    prevBlcok|   String | 前一个区块 |
|    nextBlock|   String |  后一个区块 |
|    size|   Integer |  区块大小 |
|    time|   Long |  出块时间 |
|    txSize|   Short |  交易数量 |
|    outputTotal|   Double |  总输出 |

## 五、 根据nextHash获取区块详情

method：GET  
url: /block/getByNextBlcok?nexthash={nexthash}

response:
```json
{
    "blockhash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
    "difficulty": 7409399249090.25,
    "fees": 1225.464,
    "height": 580690,
    "merkleRoot": "07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798",
    "prevBlcok": "0000000000000000001ec53a5934fa44779d8ab375605cc80fc1f2eb96c76ce8",
    "nextBlock": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
    "size": 1250,
    "time": 1560502355355,
    "txSize": 1834,
    "outputTotal": null
}
```

| ResponseField    |     Type  |   Description   | 
| :--------------: | :--------:| :-------------: |
|    blockhash|   String |  区块hash |
|    difficulty|   Double |  难度系数 |
|    fees|   Double |  交易费用 |
|    height|   Integer |  区块高度 |
|    merkleRoot|   String |  梅尔克树 |
|    prevBlcok|   String | 前一个区块 |
|    nextBlock|   String |  后一个区块 |
|    size|   Integer |  区块大小 |
|    time|   Long |  出块时间 |
|    txSize|   Short |  交易数量 |
|    outputTotal|   Double |  总输出 |

## 六、 根据txDetailId获取地址交易详情

method：GET  
url: /block/getByAddress?txDetailId={txDetailId}

response:
```json
{
    "txDetailId": 1,
    "address": "3E7xRXhednyKBGozD5BEC5jiyvzRaPzY1L",
    "amount": 132.90157587,
    "type": 1,
    "txhash": "8858fc91e6d7d5e86b2a79909ae2da1bf1ef1a46"
}
```

| ResponseField    |     Type  |   Description   | 
| :--------------: | :--------:| :-------------: |
|    txDetailId|   Long |  地址ID |
|    address|   String |  地址号 |
|    amount|   Double |  收到的总数 |
|    type|   Byte |  类型 |
|    txhash|   String |  哈希 |
