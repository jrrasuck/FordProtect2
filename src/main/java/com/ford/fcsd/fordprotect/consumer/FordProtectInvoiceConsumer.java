package com.ford.fcsd.fordprotect.consumer;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.fcsd.fordprotect.dto.FP2InvoiceDTO;

@Service
public class FordProtectInvoiceConsumer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ObjectMapper mapper = new ObjectMapper();

	@RabbitListener(queues = "q.emis", concurrency = "5")
	public void listen(String message) throws JsonParseException, JsonMappingException, IOException {

		FP2InvoiceDTO invoice = mapper.readValue(message, FP2InvoiceDTO.class);
		logger.info("Consumindo Invoice {} on thread {}", invoice, Thread.currentThread().getName());

		if (invoice.getSize() <= 4l) {
			throw new IOException("Invoice inválido: " + invoice.getId() + "; size: " + invoice.getSize());
		}

		logger.info("\t\t+++++ Gravando Invoice {} no database do Emis", invoice);
	}

	@PostConstruct
	public void init() {
		logger.info("Starting FordProtectInvoiceConsumer");
	}

}
