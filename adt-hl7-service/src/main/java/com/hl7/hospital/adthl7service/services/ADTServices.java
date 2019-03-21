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
	
	public String ADT01Handler (String message) throws HL7Exception, IOException {
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
		
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
				
		return ack;
	}
	
	public String ADT02Handler (String message) throws HL7Exception, IOException {
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
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
					
		return ack;
		
	}
	
	public String ADT03Handler (String message) throws HL7Exception, IOException {
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
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
					
		return ack;
	}
	
	public String ADT04Handler (String message) throws HL7Exception, IOException {
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
		
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
					
		return ack;
		
	}
	
	public String ADT05Handler (String message) throws HL7Exception, IOException {
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
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
					
		return ack;
		
	}
	
	public String ADT08Handler (String message) throws HL7Exception, IOException {
		
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
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
			
		return ack;
		
	}
	
	public String ADT11Handler (String message) throws HL7Exception, IOException {
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
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
			
		return ack;
		
		
	}
	
	public String ADT12Handler (String message) throws HL7Exception, IOException {
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
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
		
		return ack;
		
	}
	
	public String ADT13Handler (String message) throws HL7Exception, IOException {
		Patient patient = new Patient();
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		
		// we get the data from the hl7 message;
		
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
		
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
		
		return ack;
		
	}
	public String RDEHandler (String message) throws HL7Exception, IOException {
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.getMSH(message);
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","PHARMACY",sedingApp);
		return ack;
	}
	
	public String ORMHandler (String message) throws HL7Exception, IOException {
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.getMSH(message);
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","ORDER",sedingApp);
		return ack;
	}
	
	public String OMLHandler (String message) throws HL7Exception, IOException {
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.getMSH(message);
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","LABORATORY",sedingApp);
		return ack;
	}

}
