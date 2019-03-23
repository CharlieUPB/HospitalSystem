package com.hl7.hospital.adthl7service.events;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
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
	
	private String mqttServer = "tcp://192.168.99.100:1883";
	private int qos = 2;
	
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
	public void messageArrived(String topic, MqttMessage message) {
		System.out.println();
		System.out.println("***********************************************************************");
		System.out.println("Message Arrived Topic: " + topic + "  Message: " + new String(message.getPayload()));
		System.out.println("***********************************************************************");
		System.out.println();
		this.processMessage(topic, message);
	}
	
	private void processMessage(String topic, MqttMessage message)  {
		System.out.println("Empezare a procesar el mensaje");
		String hl7Message = new String(message.getPayload());
		try {
			System.out.println("Hare un handler del mensaje");
			String acknowledgment = this.handleMessage(topic, hl7Message);
			System.out.println("SI pude hacer un handler del mensaje");
			if(acknowledgment != "") {
				System.out.println("El publicar es el problema?");
				EventProducer.getInstance().publishMessage("ACK", acknowledgment);
				System.out.println("nooooooo");
			}
		} catch ( HL7Exception | IOException e) {
			System.out.println("ERROR WHILE HANDLINDG ADT EVENT: " + e);
		}
	}
	
	private String handleMessage(String topic, String message) throws HL7Exception, IOException {
		String acknowledgment = "";
		System.out.println("LLEGUE AL handler del mensaje");
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
			System.out.println("handleare un adt a04");
			acknowledgment = this.adtServices.ADT04Handler(message);
			System.out.println("SI PUDE handleare un adt a04");
			break;
		case "ADT-A05":
			System.out.println("handleare un adt a05");
			acknowledgment = this.adtServices.ADT05Handler(message);
			System.out.println("SI PUDE handleare un adt a05");
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
		System.out.println("El ack es:::   asodsaodaskdsak: ::  :" + acknowledgment);
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
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// Only for producer class	
	}


}
