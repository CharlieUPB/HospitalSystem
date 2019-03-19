package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.services.MedicalStaffService;


@RestController
@RequestMapping(path = "/medicalStaff")
public class MedicalStaffController {

	MedicalStaffService medicalStaffService = new MedicalStaffService();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<MedicalStaff> getAllMedicalStaff()
	{
		return medicalStaffService.getAllMedicalStaff();
	}
	
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Optional<MedicalStaff> getMedicalStaffById(@RequestParam("id") String codMedicalStaff)
	{
		return medicalStaffService.getMedicalStaffByID(Integer.parseInt(codMedicalStaff));
	}

}
