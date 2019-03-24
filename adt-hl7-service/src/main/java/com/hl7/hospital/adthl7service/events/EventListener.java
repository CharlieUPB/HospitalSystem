package com.hl7.hospital.adthl7service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements Runnable{

	@Autowired
	EventConsumer consumer;
	
	@Override
	public void run() {
		while(true) {
			consumer.subscribeMessage("ADT-A01");
			consumer.subscribeMessage("ADT-A02");
			consumer.subscribeMessage("ADT-A03");
			consumer.subscribeMessage("ADT-A04");
			consumer.subscribeMessage("ADT-A05");
			consumer.subscribeMessage("ADT-A08");
			consumer.subscribeMessage("ADT-A11");
			consumer.subscribeMessage("ADT-A12");
			consumer.subscribeMessage("ADT-A13");
			consumer.subscribeMessage("OML-O21");
			consumer.subscribeMessage("ORM-O01");
			consumer.subscribeMessage("RDE-O11");
			consumer.subscribeMessage("ACK_RCV");
		}
		
	}

}
