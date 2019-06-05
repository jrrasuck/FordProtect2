package com.ford.fcsd.fordprotect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FordProtect2Application {

	public static void main(String[] args) {
		SpringApplication.run(FordProtect2Application.class, args);
	}

}