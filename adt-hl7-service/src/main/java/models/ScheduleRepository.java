package models;


import org.springframework.data.repository.CrudRepository;
import models.Schedule;


public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

}