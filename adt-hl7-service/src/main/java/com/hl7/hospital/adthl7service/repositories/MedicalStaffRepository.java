package com.hl7.hospital.adthl7service.repositories;


import org.springframework.data.repository.CrudRepository;

import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.repositories.MedicalStaffRepository;


public interface MedicalStaffRepository extends CrudRepository<MedicalStaff, Integer> {

}

