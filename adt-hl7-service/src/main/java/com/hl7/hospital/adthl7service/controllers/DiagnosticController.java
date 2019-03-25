package com.hl7.hospital.adthl7service.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.errors.NotFoundException;
import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.services.DiagnosticService;

@RestController
@RequestMapping(path = "/diagnostics")
public class DiagnosticController {

	@Autowired
	DiagnosticService diagServ;
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<Diagnostic> getAllDiagnostics()
	{
		return diagServ.getAllDiagnostics();
	}
	
	@RequestMapping(
			value = "/patient/{ci}",
			method = RequestMethod.GET)
	public @ResponseBody ArrayList<Diagnostic> getDiagnosticbyPatientCI(@PathVariable("ci") int ciPatient)
	{
		return this.diagServ.findByPatientCI(ciPatient);
	}
	
	
	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET)
	public @ResponseBody Diagnostic getDiagnosticById(@PathVariable("id") String codDiagnostic)
	{
		Optional<Diagnostic> diagnosticOptional = diagServ.getDiagnosticByID(Integer.parseInt(codDiagnostic));
		if(diagnosticOptional.isPresent()) {
			return diagnosticOptional.get();
		} else {
			throw new NotFoundException();
		}
	}

}
