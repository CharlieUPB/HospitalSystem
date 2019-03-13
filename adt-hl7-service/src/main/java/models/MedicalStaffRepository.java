package models;


import org.springframework.data.repository.CrudRepository;
import models.MedicalStaffRepository;


public interface MedicalStaffRepository extends CrudRepository<MedicalStaff, Integer> {

}

