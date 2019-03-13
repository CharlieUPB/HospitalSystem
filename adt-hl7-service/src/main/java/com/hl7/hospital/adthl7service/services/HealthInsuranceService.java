package com.hl7.hospital.adthl7service.services;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.hl7.hospital.adthl7service.models.HealthInsurance;
import com.hl7.hospital.adthl7service.repositories.HealthInsuranceRepository;

public class HealthInsuranceService {

	@Autowired
	private HealthInsuranceRepository healthInsuranceRepository;
	
	public void createInsurance() {
		HealthInsurance h = new HealthInsurance();
		h.setNameOrganization("Cordes");
		h.setVecDate(Date.valueOf("2010-01-21"));
		healthInsuranceRepository.save(h);
	}
	
}
