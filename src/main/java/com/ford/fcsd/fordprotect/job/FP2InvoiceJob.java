package com.ford.fcsd.fordprotect.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ford.fcsd.fordprotect.service.EmisService;

@Component
public class FP2InvoiceJob {

	@Autowired
	private EmisService emisService;

//	@Scheduled(cron = "0 * * * * *")
	public void doEmisJob() {
		emisService.doSearchInvoices();
	}

}