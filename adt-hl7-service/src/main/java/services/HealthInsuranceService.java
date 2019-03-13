package services;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import models.HealthInsurance;
import models.HealthInsuranceRepository;

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
