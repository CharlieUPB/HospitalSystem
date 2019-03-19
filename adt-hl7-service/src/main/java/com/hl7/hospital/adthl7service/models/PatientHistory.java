package com.hl7.hospital.adthl7service.models;

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
	private Patient patient;
	
	private String adtCode;
	private String details;
	
	
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
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public int getCodPatientHistory() {
		return codPatientHistory;
	}
	public void setCodPatientHistory(int codPatientHistory) {
		this.codPatientHistory = codPatientHistory;
	}
	
}
