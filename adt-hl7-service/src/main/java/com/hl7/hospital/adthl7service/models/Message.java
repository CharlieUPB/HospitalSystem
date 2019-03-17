package com.hl7.hospital.adthl7service.models;

public class Message {

	private String Data;
	private String GUID;
	
	public Message() {
		
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String gUID) {
		GUID = gUID;
	}
	
	
}
