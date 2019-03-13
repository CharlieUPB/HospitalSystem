package com.hl7.hospital.adthl7service.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.repositories.DiagnosticRepository;

public class DiagnosticService {
	
	@Autowired 
	
	private DiagnosticRepository diagnosticRepository;

	public String addNewDiagnostic (Patient codPatient, MedicalStaff codDoctor, String description) 
	{
		Diagnostic diagnostic = new Diagnostic();
		
		diagnostic.setPatient(codPatient);
		diagnostic.setDoctor(codDoctor);
		diagnostic.setDescription(description);
		diagnosticRepository.save(diagnostic);
		
		return "Saved";
	}
//
//	@GetMapping(path="/all")
//	public @ResponseBody Iterable<User> getAllUsers() {
//	// This returns a JSON or XML with the users
//	return userRepository.findAll();
//	}

}
