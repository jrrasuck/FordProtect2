package com.ford.fcsd.fordprotect;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FordProtectRabbitProducer {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendHello(String name) {
		logger.info("Enviando mensagem...");
		rabbitTemplate.convertAndSend("q.fp2.hello", "Hello " + name);
	}

	@PostConstruct
	public void init() {
		logger.info(">>>>> Iniciando HelloRabbitProducer...");
	}
	
}
