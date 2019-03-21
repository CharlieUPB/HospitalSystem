package com.hl7.hospital.adthl7service.events;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.hl7.hospital.adthl7service.utils.Parse;
import com.hl7.hospital.adthl7service.services.ADTServices;

import com.hl7.hospital.adthl7service.events.EventProducer;

@Component
public class EventConsumer implements MqttCallback {
	
	private String mqttServer = "tcp://192.168.99.100:1883";
	private int qos = 2;
	
	private MqttConnectOptions connectionOptions = null;
	private MqttClient mqttClient = null;
	private MemoryPersistence persistence = null;
	
	private Parse parseUtil = null;
	private ADTServices adtServices = null;
	
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
		this.processMessage(topic, message);
	}
	
	private void processMessage(String topic, MqttMessage message) throws Exception  {
		String hl7Message = new String(message.getPayload());
		
		if(this.parseUtil.isHL7SyntaxValid(hl7Message)) {
			String acknowledgment = this.handleMessage(topic, hl7Message);
			if(acknowledgment != "") {
				EventProducer.getInstance().publishMessage("ACK", acknowledgment);
			}
		}
	}
	
	private String handleMessage(String topic, String message) throws Exception {
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
		default:
			break;
		}
		return acknowledgment;
	}

	
	private void init() {
		
		this.parseUtil = new Parse();
		this.adtServices = new ADTServices();
		
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
			logger.error("ERROR", me);
		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		logger.info("Connection Lost");
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// Only for producer class	
	}


}
