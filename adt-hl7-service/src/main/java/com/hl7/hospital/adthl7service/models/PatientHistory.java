package com.hl7.hospital.adthl7service.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PatientHistory {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codPatientHistory;
	
	@ManyToOne
	@JoinColumn
	private Patient patientPH;
	
	private String adtCode;
	private String mshID;
	private String details;
	
	private Date eventDate;
	private Time eventTime;
	
	
	public String getAdtCode() {
		return adtCode;
	}
	public void setAdtCode(String adtCode) {
		this.adtCode = adtCode;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Patient getPatientPH() {
		return patientPH;
	}
	public void setPatientPH(Patient patient) {
		this.patientPH = patient;
	}
	public int getCodPatientHistory() {
		return codPatientHistory;
	}
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Time getEventTime() {
		return eventTime;
	}
	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}
	public String getMshID() {
		return mshID;
	}
	public void setMshID(String mshID) {
		this.mshID = mshID;
	}
	
}
