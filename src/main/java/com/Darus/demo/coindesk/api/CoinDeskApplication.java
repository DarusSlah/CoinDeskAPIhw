package com.Darus.demo.coindesk.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class CoinDeskApplication {

	private static final Logger log = LoggerFactory.getLogger(CoinDeskApplication.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 3000)
	public void reportCurrentTime() {
		log.info(dateFormat.format(new Date()));
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			Coin coin = restTemplate.getForObject(
					"https://api.coindesk.com/v1/bpi/currentprice.json", Coin.class);
			log.info(coin.toString());
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(CoinDeskApplication.class, args);

	}
}