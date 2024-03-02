package com.timirov.bankingtransactionsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BankingTransactionsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingTransactionsApiApplication.class, args);
	}

}
