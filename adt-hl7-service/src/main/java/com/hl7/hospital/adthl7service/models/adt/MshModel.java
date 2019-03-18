package com.hl7.hospital.adthl7service.models.adt;

public class MshModel {
	private String sendinAplication;
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
