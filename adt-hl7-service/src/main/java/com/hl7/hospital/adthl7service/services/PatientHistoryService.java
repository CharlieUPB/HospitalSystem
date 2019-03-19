package com.hl7.hospital.adthl7service.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hl7.hospital.adthl7service.models.PatientHistory;
import com.hl7.hospital.adthl7service.repositories.PatientHistoryRepository;

public class PatientHistoryService {

	@Autowired 
	private PatientHistoryRepository patientHistoryRepository;
	
	public PatientHistory addPatientHistory(PatientHistory ph) {
		return this.patientHistoryRepository.save(ph);
	}
	
	public Iterable<PatientHistory> findAll() {
		return this.patientHistoryRepository.findAll();
	}
	
	public Optional<PatientHistory> findOne(int id) {
		return this.patientHistoryRepository.findById(id);
	}
	
	public ArrayList<PatientHistory> findByPatient(int id) {
		ArrayList<PatientHistory> found = new ArrayList<PatientHistory>();
		Iterable<PatientHistory> all = this.patientHistoryRepository.findAll();
		for (PatientHistory patientHistory : all) {
			if (patientHistory.getPatient().getCod() == id) {
				found.add(patientHistory);
			}
		}
		return found;
	}

	public void delete(PatientHistory ph) {
		this.patientHistoryRepository.delete(ph);
	}
	


}
