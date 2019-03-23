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
			value = "/{id}",
			method = RequestMethod.GET)
	public @ResponseBody Patient getPatientById(@PathVariable("id") String codPatient)
	{
		Optional<Patient> patientOptional = patientService.getPatientByID(Integer.parseInt(codPatient));
		if(patientOptional.isPresent()) {
			return patientOptional.get();
		} else {
			throw new NotFoundException();
		}
	}

}
