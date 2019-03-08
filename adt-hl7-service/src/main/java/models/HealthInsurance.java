package models;

import java.sql.Date;

public class HealthInsurance {
	
	
	private int cod;
	private String nameOrganization;
	private Date vecDate;

	
	public HealthInsurance(int cod, String nameOrganization, Date vecDate)
	{
		this.cod = cod;
		this.nameOrganization = nameOrganization;
		this.vecDate = vecDate;
	}
	
	
	
	public int getCod()
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
	
	
	
	public void setCod(int cod)
	{
		this.cod = cod;
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
