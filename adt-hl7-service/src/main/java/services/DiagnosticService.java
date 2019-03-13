package services;

import org.springframework.beans.factory.annotation.Autowired;

import models.Diagnostic;
import models.DiagnosticRepository;
import models.MedicalStaff;
import models.Patient;

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
