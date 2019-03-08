package models;

import java.sql.Date;

public class Schedule {

	
	private int codPatient;
	private int codDoctor;
	private Date date;
	private Date hour;

	
	public Schedule(int codPatient, int codDoctor, Date date, Date hour)
	{
		this.codPatient = codPatient;
		this.codDoctor = codDoctor;
		this.date = date;
		this.hour = hour;
	}
	
	
	
	public int getCodPatient()
	{
		return this.codPatient;
	}
	public int getCodDoctor()
	{
		return this.codDoctor;
	}
	public Date getDate()
	{
		return this.date;
	}
	public Date getHour()
	{
		return this.hour;
	}
	
	
	
	public void setCodPatient(int codPatient)
	{
		this.codPatient = codPatient;
	}
	public void setCodDoctor(int codDoctor)
	{
		this.codDoctor = codDoctor;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public void setHour(Date hour)
	{
		this.hour = hour;
	}
}
