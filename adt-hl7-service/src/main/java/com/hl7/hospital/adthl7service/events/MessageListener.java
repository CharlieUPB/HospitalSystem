package com.hl7.hospital.adthl7service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener implements Runnable{

	@Autowired
	EventConsumer consumer;
	
	@Override
	public void run() {
		while(true) {
			consumer.subscribeMessage("ADT-01");
			consumer.subscribeMessage("ADT-02");
			consumer.subscribeMessage("ADT-03");
			consumer.subscribeMessage("ADT-04");
			consumer.subscribeMessage("ADT-05");
			consumer.subscribeMessage("ADT-08");
			consumer.subscribeMessage("ADT-11");
			consumer.subscribeMessage("ADT-12");
			consumer.subscribeMessage("ADT-13");
		}
		
	}

}
