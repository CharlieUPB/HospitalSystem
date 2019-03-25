package com.hl7.hospital.adthl7service.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.errors.NotFoundException;
import com.hl7.hospital.adthl7service.models.Schedule;
import com.hl7.hospital.adthl7service.services.ScheduleService;
import com.hl7.hospital.adthl7service.utils.Parse;

@RestController
@RequestMapping(path = "/schedules")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	Parse parseUtil = new Parse();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public @ResponseBody Iterable<Schedule> getAllSchedules()
	{
		return scheduleService.getAllSchedules();
	}
	
	
	@RequestMapping(
			value = "/{date}",
			method = RequestMethod.GET)
	public @ResponseBody ArrayList<Schedule> getScheduleById(@PathVariable("date") String date)
	{
		return scheduleService.getScheduleByDate(parseUtil.parseStringToDate(date));
		
	}
}
