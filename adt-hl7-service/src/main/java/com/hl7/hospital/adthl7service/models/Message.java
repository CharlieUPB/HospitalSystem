package com.hl7.hospital.adthl7service.models;

public class Message {

	private String Data;
	private static final String HL7VERSION = "2.4";
	
	public Message() {
		
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}
	
}
