package com.hl7.hospital.adthl7service.services;
import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.models.Patient;
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
	
	
	public ArrayList<Diagnostic> getDiagnosticsForPatientID(int codPatient)
	{
		ArrayList<Diagnostic> patientDiagnostics = new ArrayList<Diagnostic>();
		Iterable<Diagnostic> diagnostics = diagnosticRepository.findAll();
		
		for (Diagnostic d : diagnostics) 
		{
			if (d.getPatient().getCod() == codPatient)
			{
				patientDiagnostics.add(d);
			}	
		}
		
		return patientDiagnostics;
	}
	
	
	public void deleteDiagnostic(int codDiagnostic)
	{
		diagnosticRepository.deleteById(codDiagnostic);
	}
}
