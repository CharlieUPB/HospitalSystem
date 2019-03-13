package models;


import org.springframework.data.repository.CrudRepository;
import models.Patient;


public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
