package com.ford.fcsd.fordprotect;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ford.fcsd.fordprotect.dto.FP2InvoiceDTO;
import com.ford.fcsd.fordprotect.producer.FordProtectInvoiceProducer;

@SpringBootApplication
public class FordProtect2Application implements CommandLineRunner {

	@Autowired
	private FordProtectInvoiceProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(FordProtect2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i < 5; i++) {

			FP2InvoiceDTO invoice = new FP2InvoiceDTO(
					i, "Invoice " + i, LocalDate.now());
			producer.sendMessage(invoice);
		}

	}

}
