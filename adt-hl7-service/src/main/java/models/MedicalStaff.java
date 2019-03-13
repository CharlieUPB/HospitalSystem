package models;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="MedicalStaff")
public class MedicalStaff {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod;
	private String name;
	private String lastName;
	private int gender;
	private String speciality;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Diagnostic> diagnostics;
	
	@OneToMany(mappedBy = "codDoctor", cascade = CascadeType.ALL)
    private Set<Schedule> schedule;
	
	
	public MedicalStaff(int cod, String name, String lastName, int gender, String speciality)
	{
		this.cod = cod;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.speciality = speciality;
	}
	
	public MedicalStaff()
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
	public String getSpeciality()
	{
		return this.speciality;
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
	public void setSpeciality(String speciality)
	{
		this.speciality = speciality;
	}

}
