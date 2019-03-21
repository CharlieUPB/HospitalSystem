package com.hl7.hospital.adthl7service.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl7.hospital.adthl7service.models.HealthInsurance;
import com.hl7.hospital.adthl7service.repositories.HealthInsuranceRepository;

@Service
public class HealthInsuranceService {
	

	@Autowired 
	
	private HealthInsuranceRepository healthInsuranceRepository;

	
	public String createNewHealthInsurance (String nameOrganization, Date vecDate) 
	{
		HealthInsurance healthInsurance = new HealthInsurance();
		
		healthInsurance.setNameOrganization(nameOrganization);
		healthInsurance.setVecDate(vecDate);
		healthInsuranceRepository.save(healthInsurance);
		
		return "Saved";
	}
	
	
	public String addNewHealthInsurance(HealthInsurance healthInsuranceCreated)
	{
		healthInsuranceRepository.save(healthInsuranceCreated);
		
		return "Saved";
	}
	
	
	public Iterable<HealthInsurance> getAllHealthInsurances()
	{
		return healthInsuranceRepository.findAll();
	}
	
	
	public Optional<HealthInsurance> getHealthInsuranceByID(int codHealthInsurance)
	{
		return healthInsuranceRepository.findById(codHealthInsurance);
	}
	
	
	public ArrayList<HealthInsurance> getHealthInsuranceByNameOrg(String nameOrganization)
	{
		ArrayList<HealthInsurance> healthInsurancesOrg = new ArrayList<HealthInsurance>();
		Iterable<HealthInsurance> healthInsurances = healthInsuranceRepository.findAll();
		
		for (HealthInsurance hI : healthInsurances) 
		{
			if (hI.getNameOrganization() == nameOrganization)
			{
				healthInsurancesOrg.add(hI);
			}	
		}
		
		return healthInsurancesOrg;
	}
	
	
	public void deleteHealthInsurance(int codHealthInsurance)
	{
		healthInsuranceRepository.deleteById(codHealthInsurance);
	}
}
