package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.services.DiagnosticService;

@RestController
@RequestMapping(path = "/diagnostics")
public class DiagnosticController {

	DiagnosticService diagServ = new DiagnosticService();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<Diagnostic> getAllDiagnostics()
	{
		return diagServ.getAllDiagnostics();
	}
	
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Optional<Diagnostic> getDiagnosticById(@RequestParam("id") String codDiagnostic)
	{
		return diagServ.getDiagnosticByID(Integer.parseInt(codDiagnostic));
	}

}
