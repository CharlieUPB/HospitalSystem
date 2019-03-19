package com.hl7.hospital.adthl7service.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import ca.uhn.hl7v2.HL7Exception;

import com.hl7.hospital.adthl7service.models.HealthInsurance;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.models.Schedule;
import com.hl7.hospital.adthl7service.utils.*;
import com.hl7.hospital.adthl7service.services.*;
public class ADTServices {
	
	Parse parse = new Parse();
	Create create = new Create();
	PatientService pService = new PatientService();
	HealthInsuranceService hService = new HealthInsuranceService();
	ScheduleService scheduleService = new ScheduleService();
	
	public void ADT01Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();

		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		health.setCod((int)parsedmessage.get("codSecure"));
		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
		
		medical.setCod((int)parsedmessage.get("codDoctor"));
		medical.setName((String)parsedmessage.get("nameDoctor"));
		medical.setSpeciality((String)parsedmessage.get("speciality"));
		
		//insertamos en la base de datos, los datos del paciente
		
	}
	
	public void ADT02Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();

		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		//insertamos en la base de datos, los datos del paciente
	}
	
	public void ADT03Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		
		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		//insertamos en la base de datos, los datos del paciente
	}
	
	public void ADT04Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		
		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		
		health.setCod((int)parsedmessage.get("codSecure"));
		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
		
		patient.setCodSecure(health);
		
		medical.setCod((int)parsedmessage.get("codDoctor"));
		medical.setName((String)parsedmessage.get("nameDoctor"));
		medical.setSpeciality((String)parsedmessage.get("speciality"));
	
		pService.addNewPatient(patient);
		
		//insertamos en la base de datos, los datos del paciente, del seguro y del medico
	}
	
	public void ADT05Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		
		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		health.setCod((int)parsedmessage.get("codSecure"));
		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
		
		medical.setCod((int)parsedmessage.get("codDoctor"));
		medical.setName((String)parsedmessage.get("nameDoctor"));
		medical.setSpeciality((String)parsedmessage.get("speciality"));
		
		//insertamos en la base de datos, los datos y generamos un agendamiento		
		
//		scheduleService.addNewDiagnostic(patient, medical, date, hour)
	}
	
	public void ADT08Handler (String message) throws HL7Exception, IOException {
		
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		health.setCod((int)parsedmessage.get("codSecure"));
		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
		
		medical.setCod((int)parsedmessage.get("codDoctor"));
		medical.setName((String)parsedmessage.get("nameDoctor"));
		medical.setSpeciality((String)parsedmessage.get("speciality"));
		
		//hacer consulta sql para editar la informacion del paciente que tenga ese codigo
	}
	
	public void ADT11Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		
		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		health.setCod((int)parsedmessage.get("codSecure"));
		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
		
		medical.setCod((int)parsedmessage.get("codDoctor"));
		medical.setName((String)parsedmessage.get("nameDoctor"));
		medical.setSpeciality((String)parsedmessage.get("speciality"));
		
		//insertamos en la base de datos, los datos del paciente
	}
	
	public void ADT12Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		
		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		//insertamos en la base de datos, los datos del paciente
	}
	
	public void ADT13Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		
		parsedmessage = parse.ADT(message);
		patient.setCod((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		//insertamos en la base de datos, los datos del paciente
	}
	public void RDEHandler (String message) throws HL7Exception, IOException {
		String ack = create.CreateACK("","");
	}
	
	public void ORMHandler (String message) throws HL7Exception, IOException {
		String ack = create.CreateACK("","");
	}
	
	public void OMLHandler (String message) throws HL7Exception, IOException {
		String ack = create.CreateACK("","");
	}

}
