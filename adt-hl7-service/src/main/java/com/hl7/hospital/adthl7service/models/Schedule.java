package com.hl7.hospital.adthl7service.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Schedule")
public class Schedule {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod;
	
	@ManyToOne
	@JoinColumn
	private Patient codPatient;
	
	@ManyToOne
	@JoinColumn
	private MedicalStaff codDoctor;
	private Date date;
	private Time hour;

	
	public Schedule(int cod, Patient codPatient, MedicalStaff codDoctor, Date date, Time hour)
	{
		this.cod = cod;
		this.codPatient = codPatient;
		this.codDoctor = codDoctor;
		this.date = date;
		this.hour = hour;
	}
	
	public Schedule()
	{
		
	}
	
	
	public int getCod() 
	{
		return cod;
	}
	public Patient getCodPatient()
	{
		return this.codPatient;
	}
	public MedicalStaff getCodDoctor()
	{
		return this.codDoctor;
	}
	public Date getDate()
	{
		return this.date;
	}
	public Time getHour()
	{
		return this.hour;
	}
	
	
	
	public void setCod(int cod) 
	{
		this.cod = cod;
	}
	public void setCodPatient(Patient codPatient)
	{
		this.codPatient = codPatient;
	}
	public void setCodDoctor(MedicalStaff codDoctor)
	{
		this.codDoctor = codDoctor;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public void setHour(Time hour)
	{
		this.hour = hour;
	}

}
