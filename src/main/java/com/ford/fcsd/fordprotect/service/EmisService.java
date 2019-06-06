package com.ford.fcsd.fordprotect.service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ford.fcsd.fordprotect.dto.FP2InvoiceDTO;
import com.ford.fcsd.fordprotect.producer.FordProtectInvoiceProducer;

@Component
public class EmisService {
	
	//Injeta Repository para buscar as NFs do lado do FP2
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FordProtectInvoiceProducer producer;
	
	public void doSearchInvoices() {
		
		logger.info("Sending Invoices to Emis queue");
		
		for (int i = 0; i < 10; i++) {
//			FP2InvoiceDTO invoice = 
//					new FP2InvoiceDTO(i, "Invoice " + i, LocalDate.now()
//							, ThreadLocalRandom.current().nextLong(1001, 1005));
			FP2InvoiceDTO invoice = 
					new FP2InvoiceDTO(i, "Invoice " + i, LocalDate.now()
							, Long.valueOf(i));
			producer.sendMessage(invoice);
		}
	}
	
}
