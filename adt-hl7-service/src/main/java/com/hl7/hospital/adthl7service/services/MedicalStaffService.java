package com.hl7.hospital.adthl7service.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.repositories.MedicalStaffRepository;

@Service
public class MedicalStaffService {
	
	@Autowired 
	
	private MedicalStaffRepository medicalStaffRepository;

	
	public String createNewMedicalStaff (String name, String lastName, int gender, String speciality) 
	{
		MedicalStaff medicalStaff = new MedicalStaff();
		
		medicalStaff.setName(name);
		medicalStaff.setLastName(lastName);
		medicalStaff.setGender(gender);
		medicalStaff.setSpeciality(speciality);
		medicalStaffRepository.save(medicalStaff);
		
		return "Saved";
	}
	
	
	public String addNewMedicalStaff(MedicalStaff medicalStaffCreatedCreated)
	{
		medicalStaffRepository.save(medicalStaffCreatedCreated);
		
		return "Saved";
	}
	
	
	public Iterable<MedicalStaff> getAllMedicalStaff()
	{
		return medicalStaffRepository.findAll();
	}
	
	
	public Optional<MedicalStaff> getMedicalStaffByID(int codMedStaff)
	{
		return medicalStaffRepository.findById(codMedStaff);
	}
	
	
	public ArrayList<MedicalStaff> getMedicalStaffByName(String name)
	{
		ArrayList<MedicalStaff> medsName = new ArrayList<MedicalStaff>();
		Iterable<MedicalStaff> med = medicalStaffRepository.findAll();
		
		for (MedicalStaff m : med) 
		{
			if (m.getName() == name)
			{
				medsName.add(m);
			}	
		}
		
		return medsName;
	}
	
	
	public ArrayList<MedicalStaff> getMedicalStaffBySpeciality(String speciality)
	{
		ArrayList<MedicalStaff> medsSpeciality = new ArrayList<MedicalStaff>();
		Iterable<MedicalStaff> med = medicalStaffRepository.findAll();
		
		for (MedicalStaff m : med) 
		{
			if (m.getSpeciality() == speciality)
			{
				medsSpeciality.add(m);
			}	
		}
		
		return medsSpeciality;
	}
	
	
	public void deleteMedicalStaff(int codMedicalStaff)
	{
		medicalStaffRepository.deleteById(codMedicalStaff);
	}

}
