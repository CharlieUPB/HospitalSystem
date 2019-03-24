package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hl7.hospital.adthl7service.errors.NotFoundException;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.services.PatientService;

@RestController
@RequestMapping(path = "/patients")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<Patient> getAllPatients()
	{
		return patientService.getAllPatients();
	}
	
	@RequestMapping(
			value = "/{CI}",
			method = RequestMethod.GET)
	public @ResponseBody Patient getPatientById(@PathVariable("CI") int patientCI)
	{
		Patient patient = this.patientService.getPatientByCI(patientCI);
		if(patient == null) {
			throw new NotFoundException();
		} else {
			return patient;
		}
	}

}
