package com.hl7.hospital.adthl7service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hl7.hospital.adthl7service.models.Diagnostic;

@Repository
public interface DiagnosticRepository extends CrudRepository<Diagnostic, Integer> {

}
