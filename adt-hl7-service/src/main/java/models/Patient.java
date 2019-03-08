package models;

import java.sql.Date;

public class Patient {

	private int cod;
	private String name;
	private String lastName;
	private int gender;
	private Date birthDate;
	private int phone;
	private int cellPhone;
	private String address;
	private boolean deceased;
	private String maritalStatus;
	private String nationality;
	private String city;
	private int codSecure;
	
	
	public Patient(int cod, String name, String lastName, int gender, Date birthDate, int phone, int cellPhone, String address, boolean deceased, String maritalStatus, String nationality, String city, int codSecure)
	{
		this.cod = cod;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phone = phone;
		this.cellPhone = cellPhone;
		this.address = address;
		this.deceased = deceased;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
		this.city = city;
		this.codSecure = codSecure;
	}
	
	
	
	public int getCod()
	{
		return this.cod;
	}
	public String getName()
	{
		return this.name;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public int getGender()
	{
		return this.gender;
	}
	public Date getBirthDate()
	{
		return this.birthDate;
	}
	public int getPhone()
	{
		return this.phone;
	}
	public int getCellPhone()
	{
		return this.cellPhone;
	}
	public String getAddress()
	{
		return this.address;
	}
	public boolean getDeceased()
	{
		return this.deceased;
	}
	public String getMaritalStatus()
	{
		return this.maritalStatus;
	}
	public String getNationality()
	{
		return this.nationality;
	}
	public String getCity()
	{
		return this.city;
	}
	public int getCodSecure()
	{
		return this.codSecure;
	}
	
	
	public void setCod(int cod)
	{
		this.cod = cod;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setGender(int gender)
	{
		this.gender = gender;
	}
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}
	public void setPhone(int phone)
	{
		this.phone = phone;
	}
	public void setCellPhone(int cellPhone)
	{
		this.cellPhone = cellPhone;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public void setDeceased(boolean deceased)
	{
		this.deceased = deceased;
	}
	public void setMaritalStatus(String maritalStatus)
	{
		this.maritalStatus = maritalStatus;
	}
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setCOdSecure(int codSecure)
	{
		this.codSecure = codSecure;
	}
}
