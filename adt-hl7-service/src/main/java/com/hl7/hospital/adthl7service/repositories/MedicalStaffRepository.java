package com.hl7.hospital.adthl7service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.repositories.MedicalStaffRepository;

@Repository
public interface MedicalStaffRepository extends CrudRepository<MedicalStaff, Integer> {

}

