package com.hl7.hospital.adthl7service.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl7.hospital.adthl7service.models.PatientHistory;
import com.hl7.hospital.adthl7service.repositories.PatientHistoryRepository;

@Service
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
	
	public PatientHistory findByMSHID(String mshID) {
		Iterable<PatientHistory> all = this.patientHistoryRepository.findAll();
		System.out.println("EL que buso es: " + mshID);
		for (PatientHistory patientHistory : all) {
			if (patientHistory.getMshID().equals(mshID)) {
				return patientHistory;
			}
		}
		return null;
	}
	
	public ArrayList<PatientHistory> findByPatientCI(int CI) {
		Iterable<PatientHistory> all = this.patientHistoryRepository.findAll();
		ArrayList<PatientHistory> found = new ArrayList<PatientHistory>();
		for (PatientHistory patientHistory : all) {
			if (patientHistory.getPatientPH().getCI() == CI) {
				found.add(patientHistory);
			}
		}
		return found;
	}

	public void delete(PatientHistory ph) {
		this.patientHistoryRepository.delete(ph);
	}
	


}
