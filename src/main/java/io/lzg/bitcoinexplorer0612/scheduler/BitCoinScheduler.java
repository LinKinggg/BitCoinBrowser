package io.lzg.bitcoinexplorer0612.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BitCoinScheduler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedRate = 3000)
    public void syncData(){
        logger.info("start to sync data");
    }
}
