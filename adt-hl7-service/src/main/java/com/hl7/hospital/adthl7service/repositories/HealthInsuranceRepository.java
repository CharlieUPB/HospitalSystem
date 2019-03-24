package com.hl7.hospital.adthl7service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hl7.hospital.adthl7service.models.HealthInsurance;


@Repository
public interface HealthInsuranceRepository extends CrudRepository<HealthInsurance, Integer> {

}

