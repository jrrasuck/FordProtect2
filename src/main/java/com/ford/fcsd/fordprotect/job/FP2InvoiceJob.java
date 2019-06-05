package com.ford.fcsd.fordprotect.job;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ford.fcsd.fordprotect.dto.FP2InvoiceDTO;
import com.ford.fcsd.fordprotect.producer.FordProtectInvoiceProducer;

@Component
public class FP2InvoiceJob {

	@Autowired
	private FordProtectInvoiceProducer producer;
	
	@Scheduled(cron="0 * * * * *")
	public void doSelectInvoices() {
		
		for (int i = 0; i < 10; i++) {
			FP2InvoiceDTO invoice = 
					new FP2InvoiceDTO(i, "Invoice " + i, LocalDate.now());
			producer.sendMessage(invoice);
		}
		
	}
	
}