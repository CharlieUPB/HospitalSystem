package com.hl7.hospital.adthl7service.services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.models.Schedule;
import com.hl7.hospital.adthl7service.repositories.ScheduleRepository;


@Service
public class ScheduleService {
	
	@Autowired 
	
	private ScheduleRepository scheduleRepository;

	
	public String createNewSchedule (Patient codPatient, MedicalStaff codDoctor, Date date, Time hour) 
	{
		Schedule schedule = new Schedule();
		
		schedule.setCodPatient(codPatient);
		schedule.setCodDoctor(codDoctor);
		schedule.setDate(date);
		schedule.setHour(hour);
		scheduleRepository.save(schedule);
		
		return "Saved";
	}
	
	
	public String addNewSchedule(Schedule scheduleCreated)
	{
		scheduleRepository.save(scheduleCreated);
		
		return "Saved";
	}
	
	
	public Iterable<Schedule> getAllSchedules()
	{
		return scheduleRepository.findAll();
	}
	
	
	public Optional<Schedule> getScheduleByID(int codSchedule)
	{
		return scheduleRepository.findById(codSchedule);
	}
	
	
	public ArrayList<Schedule> getScheduleByDate(Date date)
	{
		ArrayList<Schedule> schedulesByDate = new ArrayList<Schedule>();
		Iterable<Schedule> schedules = scheduleRepository.findAll();
		
		for (Schedule s : schedules) 
		{
			if (s.getDate() == date)
			{
				schedulesByDate.add(s);
			}	
		}
		
		return schedulesByDate;
	}
	
	
	public void deleteSchedule(int codSchedule)
	{
		scheduleRepository.deleteById(codSchedule);
	}

}
