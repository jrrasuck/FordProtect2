package com.ford.fcsd.fordprotect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FordProtect2Application implements CommandLineRunner {

	@Autowired
	private FordProtectRabbitProducer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(FordProtect2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendHello("Ford Protect 2");
	}

}
