package com.hl7.hospital.adthl7service.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.models.PatientHistory;
import com.hl7.hospital.adthl7service.repositories.DiagnosticRepository;

@Service
public class DiagnosticService {
	
	@Autowired 
	private DiagnosticRepository diagnosticRepository;

	
	public String createNewDiagnostic (Patient codPatient, MedicalStaff codDoctor, String description) 
	{
		Diagnostic diagnostic = new Diagnostic();
		
		diagnostic.setPatient(codPatient);
		diagnostic.setDoctor(codDoctor);
		diagnostic.setDescription(description);
		diagnosticRepository.save(diagnostic);
		
		return "Saved";
	}
	
	
	public String addNewDiagnostic(Diagnostic diagnosticCreated)
	{
		diagnosticRepository.save(diagnosticCreated);
		
		return "Saved";
	}
	
	
	public Iterable<Diagnostic> getAllDiagnostics()
	{
		return diagnosticRepository.findAll();
	}
	
	
	public Optional<Diagnostic> getDiagnosticByID(int codDiagnostic)
	{
		return diagnosticRepository.findById(codDiagnostic);
	}
	
	public ArrayList<Diagnostic> findByPatientCI(int CI) {
		Iterable<Diagnostic> all = this.diagnosticRepository.findAll();
		ArrayList<Diagnostic> found = new ArrayList<Diagnostic>();
		for (Diagnostic patientDiagnostic : all) {
			if (patientDiagnostic.getPatient().getCI() == CI) {
				found.add(patientDiagnostic);
			}
		}
		return found;
	}
	
	
	public void deleteDiagnostic(int codDiagnostic)
	{
		diagnosticRepository.deleteById(codDiagnostic);
	}
}
