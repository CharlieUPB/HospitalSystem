package com.hl7.hospital.adthl7service.models;

public class Message {

	private String Data;
	private String MessageControlID;
	
	public Message() {
		
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getMessageControlID() {
		return MessageControlID;
	}

	public void setMessageControlID(String gUID) {
		MessageControlID = gUID;
	}
	
	
}
