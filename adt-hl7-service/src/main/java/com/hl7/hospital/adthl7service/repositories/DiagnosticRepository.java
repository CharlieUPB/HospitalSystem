package com.hl7.hospital.adthl7service.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hl7.hospital.adthl7service.models.Diagnostic;


public interface DiagnosticRepository extends CrudRepository<Diagnostic, Integer> {

}
