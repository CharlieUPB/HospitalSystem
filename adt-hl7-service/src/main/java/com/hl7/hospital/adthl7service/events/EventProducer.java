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
public class EventProducer implements MqttCallback {
	
	private String mqttServer = "tcp://192.168.99.100:1883";
	private int qos = 2;
	private String clientId = "hl7Producer";
	private MqttClient mqttClient = null;
	private MqttConnectOptions connectionOptions = null;
	private MemoryPersistence persistence = null;
	private static final Logger logger = LoggerFactory.getLogger(EventProducer.class);
	
	private EventProducer() {
		this.init();
	}
	
	private void init() {
		this.connectionOptions = new MqttConnectOptions();
		this.persistence = new MemoryPersistence();
		try {
			this.mqttClient = new MqttClient(mqttServer,clientId,persistence);
			this.connectionOptions.setCleanSession(true);
			this.mqttClient.connect(this.connectionOptions);
			this.mqttClient.setCallback(this);
		} catch (MqttException me) {
			logger.error("ERROR", me);
		}
	}
	
	public void disconnect() {
		try {
			this.mqttClient.disconnect();
		} catch (MqttException me) {
			logger.error("ERROR", me);
		}
	}
	
	public void publishMessage(String topic, String message) {
		try {
			MqttMessage mqttmessage = new MqttMessage(message.getBytes());
			mqttmessage.setQos(this.qos);
			this.mqttClient.publish(topic, mqttmessage);
		} catch (MqttException me) {
			logger.error("ERROR", me);
		}
	}
	
	public static EventProducer getInstance() {
		return new EventProducer();
	}
	
	@Override
	public void connectionLost(Throwable cause) {
		logger.info("Connection Lost");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// Only for consumer class
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		logger.info("delivery completed");
	}
	
}
