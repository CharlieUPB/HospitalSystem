package com.hl7.hospital.adthl7service.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hl7.hospital.adthl7service.models.HealthInsurance;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.repositories.PatientRepository;

public class PatientService {
	
	@Autowired 
	
	private PatientRepository patientRepository;

	
	public String addNewPatient (String name, String lastName, int gender, Date birthDate, int phone, int cellPhone, String address, boolean deceased, String maritalStatus, String nationality, String city, HealthInsurance codSecure) 
	{
		Patient patient = new Patient();
		
		patient.setName(name);
		patient.setLastName(lastName);
		patient.setGender(gender);
		patient.setBirthDate(birthDate);
		patient.setPhone(phone);
		patient.setCellPhone(cellPhone);
		patient.setAddress(address);
		patient.setDeceased(deceased);
		patient.setMaritalStatus(maritalStatus);
		patient.setNationality(nationality);
		patient.setCity(city);
		patient.setCodSecure(codSecure);
		patientRepository.save(patient);
		
		return "Saved";
	}
	
	public String addNewPatient(Patient patient) {
		patientRepository.save(patient);
		return "saved";
	}
	
	
	public Iterable<Patient> getAllPatients()
	{
		return patientRepository.findAll();
	}
	
	
	public Optional<Patient> getPatientByID(int codPatient)
	{
		return patientRepository.findById(codPatient);
	}
	
	
	public ArrayList<Patient> getPatientsByName(String name)
	{
		ArrayList<Patient> patientsByName = new ArrayList<Patient>();
		Iterable<Patient> patients = patientRepository.findAll();
		
		for (Patient p : patients) 
		{
			if (p.getName() == name)
			{
				patientsByName.add(p);
			}	
		}
		
		return patientsByName;
	}
	
	
	public void deletePatient(int codPatient)
	{
		patientRepository.deleteById(codPatient);
	}

}
