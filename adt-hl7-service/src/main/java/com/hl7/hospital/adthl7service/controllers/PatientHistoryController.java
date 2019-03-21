package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.models.PatientHistory;
import com.hl7.hospital.adthl7service.services.PatientHistoryService;;

@RestController
@RequestMapping(path = "/patientHistories")
public class PatientHistoryController {

	PatientHistoryService patientHistoryService = new PatientHistoryService();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<PatientHistory> getAllPatients()
	{
		return patientHistoryService.findAll();
	}
	
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET,
			params = "id"
			)
	public @ResponseBody Optional<PatientHistory> getPatientById(@RequestParam("id") String codPatient)
	{
		return patientHistoryService.findOne(Integer.parseInt(codPatient));
	}
	
	
}
