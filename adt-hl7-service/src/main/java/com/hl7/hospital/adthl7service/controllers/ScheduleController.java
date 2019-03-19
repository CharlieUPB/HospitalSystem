package com.hl7.hospital.adthl7service.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.models.Diagnostic;
import com.hl7.hospital.adthl7service.models.Schedule;
import com.hl7.hospital.adthl7service.services.DiagnosticService;
import com.hl7.hospital.adthl7service.services.ScheduleService;

@RestController
@RequestMapping(path = "/schedules")
public class ScheduleController {

	ScheduleService scheduleService = new ScheduleService();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<Schedule> getAllSchedules()
	{
		return scheduleService.getAllSchedules();
	}
	
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Optional<Schedule> getScheduleById(@RequestParam("id") String codSchedule)
	{
		return scheduleService.getScheduleByID(Integer.parseInt(codSchedule));
	}
}
