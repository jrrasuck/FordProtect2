package com.ford.fcsd.fordprotect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ford.fcsd.fordprotect.service.EmisService;

@EnableScheduling
@SpringBootApplication
public class FordProtect2Application implements CommandLineRunner {

	@Autowired
	private EmisService emisService;
	
	public static void main(String[] args) {
		SpringApplication.run(FordProtect2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//emisService.doSearchInvoices();
	}

}