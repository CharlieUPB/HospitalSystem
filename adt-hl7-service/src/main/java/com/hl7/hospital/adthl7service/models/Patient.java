package com.hl7.hospital.adthl7service.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name="Patient")
public class Patient {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod;
	private String name;
	private String lastName;
	private int gender;
	private Date birthDate;
	private String phone;
	private String cellPhone;
	private String address;
	private boolean deceased;
	private String maritalStatus;
	private String nationality;
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
	private HealthInsurance codSecure;
	
	@OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL)
	private Set<PatientHistory> patientHistorys;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Diagnostic> diagnostics;
	
	@OneToMany(mappedBy = "codPatient", cascade = CascadeType.ALL)
    private Set<Schedule> schedule;
	
	
	public Patient(int cod, String name, String lastName, int gender, Date birthDate, String phone, String cellPhone, String address, boolean deceased, String maritalStatus, String nationality, String city, HealthInsurance codSecure)
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
	
	public Patient()
	{
		
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
	public String getPhone()
	{
		return this.phone;
	}
	public String getCellPhone()
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
	public HealthInsurance getCodSecure()
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
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public void setCellPhone(String cellPhone)
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
	public void setCodSecure(HealthInsurance codSecure)
	{
		this.codSecure = codSecure;
	}
}
