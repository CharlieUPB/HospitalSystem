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

@Component
public class EventConsumer implements MqttCallback {
	
	private String mqttServer = "tcp://192.168.99.100:1883";
	private int qos = 2;
	final private String clientId = "hl7Consumer";
	private MqttConnectOptions connectionOptions = null;
	private MqttClient mqttClient = null;
	private MemoryPersistence persistence = null;
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
	}

	
	private void init() {
		this.connectionOptions = new MqttConnectOptions();
		this.persistence = new MemoryPersistence();
		try {
			this.mqttClient = new MqttClient(mqttServer, clientId,persistence);
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
