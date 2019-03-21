package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.errors.NotFoundException;
import com.hl7.hospital.adthl7service.models.Schedule;
import com.hl7.hospital.adthl7service.services.ScheduleService;

@RestController
@RequestMapping(path = "/schedules")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService = new ScheduleService();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<Schedule> getAllSchedules()
	{
		return scheduleService.getAllSchedules();
	}
	
	
	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET)
	public @ResponseBody Schedule getScheduleById(@PathVariable("id") String codSchedule)
	{
		Optional<Schedule> scheduleOptional = scheduleService.getScheduleByID(Integer.parseInt(codSchedule));
		if(scheduleOptional.isPresent()) {
			return scheduleOptional.get();
		} else {
			throw new NotFoundException();
		}
	}
}
