package com.hl7.hospital.adthl7service.models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity(name="HealthInsurance")
public class HealthInsurance {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod;
	private String nameOrganization;
	private Date vecDate;
	
	@OneToOne(mappedBy = "codSecure")
	private Patient patient;
	
	
	public HealthInsurance(int cod, String nameOrganization, Date vecDate)
	{
		this.cod = cod;
		this.nameOrganization = nameOrganization;
		this.vecDate = vecDate;
	}
	
	public HealthInsurance()
	{
		
	}
	
	
	public long getCod()
	{
		return this.cod;
	}
	public String getNameOrganization()
	{
		return this.nameOrganization;
	}
	public Date getVecDate()
	{
		return this.vecDate;
	}
	
	public void setNameOrganization(String nameOrganization)
	{
		this.nameOrganization = nameOrganization;
	}
	public void setVecDate(Date vecDate)
	{
		this.vecDate = vecDate;
	}


}
