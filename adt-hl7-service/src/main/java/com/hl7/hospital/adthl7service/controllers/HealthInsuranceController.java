package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.models.HealthInsurance;
import com.hl7.hospital.adthl7service.services.HealthInsuranceService;


@RestController
@RequestMapping(path = "/healthInsurances")
public class HealthInsuranceController {

	HealthInsuranceService healthInsuranceService = new HealthInsuranceService();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<HealthInsurance> getAllHealthInsurances()
	{
		return healthInsuranceService.getAllHealthInsurances();
	}
	
	
	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET)
	public @ResponseBody Optional<HealthInsurance> getHealthInsurancesById(@PathVariable("id") String codHealthInsurance)
	{
		return healthInsuranceService.getHealthInsuranceByID(Integer.parseInt(codHealthInsurance));
	}
}
