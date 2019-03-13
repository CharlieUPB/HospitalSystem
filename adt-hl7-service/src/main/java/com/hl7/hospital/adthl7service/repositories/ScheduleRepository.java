package com.hl7.hospital.adthl7service.repositories;


import org.springframework.data.repository.CrudRepository;

import com.hl7.hospital.adthl7service.models.Schedule;


public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

}