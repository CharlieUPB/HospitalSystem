package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MshModel {
	@JsonProperty(value = "sendingApplication")
	private String sendinAplication;
	@JsonProperty(value = "mshControlGUID")
	private String mshControlID;
	
	
	public String getSendinAplication() {
		return sendinAplication;
	}
	public void setSendinAplication(String sendinAplication) {
		this.sendinAplication = sendinAplication;
	}
	public String getMshControlID() {
		return mshControlID;
	}
	public void setMshControlID(String sequenceNumber) {
		this.mshControlID = sequenceNumber;
	}
}
