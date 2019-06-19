package io.lzg.bitcoinexplorer0612;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("io.lzg.bitcoinexplorer0612.dao")
@EnableFeignClients
//定时任务
@EnableScheduling
//异步调用，开启多线程
@EnableAsync
public class Bitcoinexplorer0612Application {

	public static void main(String[] args) {
		SpringApplication.run(Bitcoinexplorer0612Application.class, args);
	}

}
