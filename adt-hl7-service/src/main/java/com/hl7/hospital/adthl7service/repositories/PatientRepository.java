package com.hl7.hospital.adthl7service.repositories;


import org.springframework.data.repository.CrudRepository;

import com.hl7.hospital.adthl7service.models.Patient;


public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
