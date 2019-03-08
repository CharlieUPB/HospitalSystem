package models;

public class Diagnostic {
	
	
	private int codPatient;
	private int codDoctor;
	private String description;

	
	public Diagnostic(int codPatient, int codDoctor, String description)
	{
		this.codPatient = codPatient;
		this.codDoctor = codDoctor;
		this.description = description;
	}
	
	
	
	public int getCodPatient()
	{
		return this.codPatient;
	}
	public int getCodDoctor()
	{
		return this.codDoctor;
	}
	public String getDescription()
	{
		return this.description;
	}
	
	
	
	public void setCodPatient(int codPatient)
	{
		this.codPatient = codPatient;
	}
	public void setCodDoctor(int codDoctor)
	{
		this.codDoctor = codDoctor;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

}
