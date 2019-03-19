package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.services.DiagnosticService;
import com.hl7.hospital.adthl7service.services.PatientService;

@RestController
@RequestMapping(path = "/patients")
public class PatientController {

	PatientService patientService = new PatientService();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<Patient> getAllPatients()
	{
		return patientService.getAllPatients();
	}
	
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Optional<Patient> getPatientById(@RequestParam("id") String codPatient)
	{
		return patientService.getPatientByID(Integer.parseInt(codPatient));
	}

}
