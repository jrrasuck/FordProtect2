package com.ford.fcsd.fordprotect.producer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.fcsd.fordprotect.dto.FP2InvoiceDTO;

@Service
public class FordProtectInvoiceProducer {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public void sendMessage(FP2InvoiceDTO invoice) {
		
		try {
			String json = mapper.writeValueAsString(invoice);
			rabbitTemplate.convertAndSend("q.fp2.hello", json);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		logger.info("Starting FordProtectInvoiceProducer");
	}
	
}
