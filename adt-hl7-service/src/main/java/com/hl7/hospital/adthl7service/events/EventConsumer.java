package com.hl7.hospital.adthl7service.events;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.hibernate.hql.spi.id.IdTableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hl7.hospital.adthl7service.utils.Parse;

import ca.uhn.hl7v2.HL7Exception;

import com.hl7.hospital.adthl7service.services.ADTServices;

import com.hl7.hospital.adthl7service.events.EventProducer;

@Component
public class EventConsumer implements MqttCallback {
	
	@Autowired
	Runnable MessageListener;
	
	private String mqttServer = "ws://localhost:3000"; // using web sockets over mqtt instead of tcp sockets
	private int qos = 0;
	
	private MqttConnectOptions connectionOptions = null;
	private MqttClient mqttClient = null;
	private MemoryPersistence persistence = null;
	
	private Parse parseUtil = null;
	
	@Autowired
	private ADTServices adtServices;
	
	private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);
	
	
	public EventConsumer() {
		this.init();
	}
	
	
	public void subscribeMessage(String topic) {
		try {
			this.mqttClient.subscribe(topic, this.qos);
		} catch (MqttException me) {
			me.printStackTrace();
		}
	}
	
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println();
		System.out.println("***********************************************************************");
		System.out.println("Message Arrived Topic: " + topic + "  Message: " + new String(message.getPayload()));
		System.out.println("***********************************************************************");
		System.out.println();
		try {
			this.processMessage(topic, message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al procesar el mensaje");
		}
	}
	
	private void processMessage(String topic, MqttMessage message)  {
		String hl7Message = new String(message.getPayload());
		try {
			String acknowledgment = this.handleMessage(topic, hl7Message);
			if(acknowledgment != "") {
				EventProducer.getInstance().publishMessage("ACK", acknowledgment);
				System.out.println("I published the ack!" + acknowledgment);
			}
		} catch ( HL7Exception | IOException e) {
			System.out.println("ERROR WHILE HANDLINDG ADT EVENT: ");
			e.printStackTrace();
		}
	}
	
	private String handleMessage(String topic, String message) throws HL7Exception, IOException {
		String acknowledgment = "";
		switch (topic) {
		case "ADT-A01":
			acknowledgment = this.adtServices.ADT01Handler(message);
			break;
		case "ADT-A02":
			acknowledgment = this.adtServices.ADT02Handler(message);
			break;
		case "ADT-A03":
			acknowledgment = this.adtServices.ADT03Handler(message);
			break;
		case "ADT-A04":
			acknowledgment = this.adtServices.ADT04Handler(message);
			break;
		case "ADT-A05":
			acknowledgment = this.adtServices.ADT05Handler(message);
			break;
		case "ADT-A08":
			acknowledgment =  this.adtServices.ADT08Handler(message);
			break;
		case "ADT-A11":
			acknowledgment = this.adtServices.ADT11Handler(message);
			break;
		case "ADT-A12":
			acknowledgment = this.adtServices.ADT12Handler(message);
			break;
		case "ADT-A13":
			acknowledgment = this.adtServices.ADT13Handler(message);
			break;
		case "ORM-O01":
			acknowledgment = this.adtServices.ORMHandler(message);
			break;	
		case "OML-O21":
			acknowledgment = this.adtServices.OMLHandler(message);
			break;	
		case "RDE-O11":
			acknowledgment = this.adtServices.RDEHandler(message);
			break;
		case "ACK_RCV":
			acknowledgment = this.adtServices.ackRcvHandler(message);
			break;	
		default:
			break;
		}
		return acknowledgment;
	}

	
	private void init() {
		
		this.parseUtil = new Parse();
		this.connectionOptions = new MqttConnectOptions();
		this.persistence = new MemoryPersistence();
		try {
			this.mqttClient = new MqttClient(mqttServer, MqttClient.generateClientId(), persistence);
			this.connectionOptions.setCleanSession(true);
			this.mqttClient.connect(this.connectionOptions);
			this.mqttClient.setCallback(this);
		} catch (MqttException me) {
			me.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			this.mqttClient.disconnect();
		} catch (MqttException me) {
			logger.error("MQTT DISCONECCT ERROR", me);
		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		Exception ex = new Exception(cause);
		ex.printStackTrace();
		try {
			MessageListener.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// Only for producer class	
	}


}
