package com.hl7.hospital.adthl7service.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Diagnostic {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codDiagnostic;
	
	@ManyToOne
	@JoinColumn
	private Patient patient;
	
	@ManyToOne
	@JoinColumn
	private MedicalStaff doctor;
	private String description;

	
	public Diagnostic(int codDiagnostic, Patient patient, MedicalStaff doctor, String description)
	{
		this.codDiagnostic =codDiagnostic;
		this.setPatient(patient);
		this.setDoctor(doctor);
		this.description = description;
	}
	
	public Diagnostic()
	{
		
	}
	
	
	public int getCodDiagnostic()
	{
		return this.codDiagnostic;
	}
	public Patient getPatient() 
	{
		return patient;
	}
	public MedicalStaff getDoctor() 
	{
		return doctor;
	}
	public String getDescription()
	{
		return this.description;
	}
	
	
	
	public void setCodDiagnostic(int codDiagnostic)
	{
		this.codDiagnostic = codDiagnostic;
	}
	public void setPatient(Patient patient) 
	{
		this.patient = patient;
	}
	public void setDoctor(MedicalStaff doctor) 
	{
		this.doctor = doctor;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}



}
