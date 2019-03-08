package models;

public class MedicalStaff {
	
	
	private int cod;
	private String name;
	private String lastName;
	private int gender;
	private String speciality;

	
	public MedicalStaff(int cod, String name, String lastName, int gender, String speciality)
	{
		this.cod = cod;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.speciality = speciality;
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
