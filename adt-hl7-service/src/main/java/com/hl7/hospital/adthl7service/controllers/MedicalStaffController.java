package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.errors.NotFoundException;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.models.adt.GenericMessage;
import com.hl7.hospital.adthl7service.services.MedicalStaffService;


@RestController
@RequestMapping(path = "/medicalStaff")
public class MedicalStaffController {

	@Autowired
	MedicalStaffService medicalStaffService;
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<MedicalStaff> getAllMedicalStaff()
	{
		return medicalStaffService.getAllMedicalStaff();
	}
	
	
	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET)
	public @ResponseBody MedicalStaff getMedicalStaffById(@PathVariable("id") String codMedicalStaff)
	{
		Optional<MedicalStaff> medicalStaffOptional = medicalStaffService.getMedicalStaffByID(Integer.parseInt(codMedicalStaff));
		if(medicalStaffOptional.isPresent()) {
			return medicalStaffOptional.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.POST)
	public @ResponseBody MedicalStaff addMedicalStaff(@RequestBody MedicalStaff med)
	{
		return this.medicalStaffService.addNewMedicalStaff(med);
	}
	

}
