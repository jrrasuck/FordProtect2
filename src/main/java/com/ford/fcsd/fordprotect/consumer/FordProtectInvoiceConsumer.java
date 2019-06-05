package com.ford.fcsd.fordprotect.consumer;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.fcsd.fordprotect.dto.FP2InvoiceDTO;

@Service
public class FordProtectInvoiceConsumer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ObjectMapper mapper = new ObjectMapper();

	@RabbitListener(queues = "q.fp2.hello")
	public void listen(String message) {
		
		FP2InvoiceDTO invoice;
		try {
			invoice = mapper.readValue(message, FP2InvoiceDTO.class);
			logger.info("FP2InvoiceDTO is {}", invoice);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@PostConstruct
	public void init() {
		logger.info("Starting FordProtectInvoiceConsumer");
	}

}
