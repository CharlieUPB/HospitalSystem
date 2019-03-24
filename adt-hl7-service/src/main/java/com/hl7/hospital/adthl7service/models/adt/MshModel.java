package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MshModel {
	@JsonProperty(value = "sendingApplication")
	private String sendingApplication;
	@JsonProperty(value = "receivingApplication")
	private String receivingApplication;
	
	
	public String getSendingApplication() {
		return sendingApplication;
	}
	public void setSendingApplication(String sendinAplication) {
		this.sendingApplication = sendinAplication;
	}
	public String getReceivingApplication() {
		return receivingApplication;
	}
	public void setReceivingApplication(String receivingApplication) {
		this.receivingApplication = receivingApplication;
	}
}
