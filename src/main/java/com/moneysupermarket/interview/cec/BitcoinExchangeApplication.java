package com.moneysupermarket.interview.cec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.Map;

@SpringBootApplication
@Import(BitcoinExchangeWebClientBuilder.class)
public class BitcoinExchangeApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(BitcoinExchangeApplication.class.getName());

	@Autowired
	BitcoinExchangeService bitcoinExchangeService;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Bitcoin Exchange Application is running.");

			Map<String, Map> blockchainResponse = bitcoinExchangeService.getRatesFromURL("https://blockchain.info/ticker");
			Double blockchainValue = (Double) blockchainResponse.get("USD").get("sell");

			Map<String, Map> exmoResponse = bitcoinExchangeService.getRatesFromURL("https://api.exmo.com/v1/ticker");
			Double exmoValue = Double.valueOf((String)exmoResponse.get("BTC_USD").get("sell_price"));

			LOGGER.info("USD Sell prices... blockchain.info: {}, exmo.com: {}", blockchainValue, exmoValue);
			if (blockchainValue > exmoValue) {
				LOGGER.info("Highest selling price for USD is from blockchain.info as: {}", blockchainValue);
			}
			else {
				LOGGER.info("Highest selling price for USD is from exmo.com as: {}", exmoValue);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BitcoinExchangeApplication.class, args);
	}

}
