package com.hl7.hospital.adthl7service.services;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Optional;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ca.uhn.hl7v2.HL7Exception;

import com.hl7.hospital.adthl7service.models.HealthInsurance;
import com.hl7.hospital.adthl7service.models.MedicalStaff;
import com.hl7.hospital.adthl7service.models.Patient;
import com.hl7.hospital.adthl7service.models.PatientHistory;
import com.hl7.hospital.adthl7service.models.Schedule;
import com.hl7.hospital.adthl7service.repositories.PatientRepository;
import com.hl7.hospital.adthl7service.utils.*;
import com.hl7.hospital.adthl7service.services.*;

@Service
public class ADTServices {
	@Autowired
	DiagnosticService diagnosticService;
	
	@Autowired
	HealthInsuranceService healthInsuranceService;
	
	@Autowired
	MedicalStaffService medicalStaffService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	PatientRepository patientDAO;
	
	@Autowired
	PatientHistoryService patientHistoryService;
	
	@Autowired
	ScheduleService scheduleService;
	
	Parse parse = new Parse();
	Create create = new Create();
	
	
	// Patient Admit
	public String ADT01Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		if((String) parsedmessage.get("evnCode") != "A01") {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-01 PERO EL MENSAJE NO ERA ADT-01");
			return "";
		}
		
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
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
		
		
		
		//Registramos en la base de datos el evento.
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A01");
		ph.setDetails("A Patient ADMIT was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
		patientHistoryService.addPatientHistory(ph);
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
				
		return ack;
	}
	
	
	//Patient Transfer
	public String ADT02Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		if((String) parsedmessage.get("evnCode") != "A02") {
			return "";
		}
		
		Patient patient = new Patient();
		
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
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A02");
		ph.setDetails("A Patient TRANSFER was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
		
		patientHistoryService.addPatientHistory(ph);
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
					
		return ack;
		
	}
	
	//Patient Discharge
	public String ADT03Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		if((String) parsedmessage.get("evnCode") != "A03") {
			return "";
		}
		
		Patient patient = new Patient();
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
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A03");
		ph.setDetails("A Patient DISCHARGE was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
		
		patientHistoryService.addPatientHistory(ph);
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
					
		return ack;
	}
	
	//Patient Registration
	public String ADT04Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode"); 
		
		System.out.println(evnCode);
		
		Patient patient = new Patient();
		patientDAO.save(patient);
		//patientService.addNewPatient(patient);
		
//		HealthInsurance health = new HealthInsurance();
//		MedicalStaff medical = new MedicalStaff();
//		
//		//String birthDay = (String)parsedmessage.get("birthDate");
//		//System.out.println("BIRTH ES: " + birthDay);
//		patient.setName((String)parsedmessage.get("name"));
//		patient.setLastName((String)parsedmessage.get("lastName"));
//		patient.setGender((int)parsedmessage.get("gender"));
//		//patient.setBirthDate(parse.parseStringToDate(birthDay));
//		patient.setPhone((String)parsedmessage.get("phone"));
//		patient.setCellPhone((String)parsedmessage.get("cellPhone"));
//		patient.setAddress((String)parsedmessage.get("address"));
//		patient.setDeceased((boolean)parsedmessage.get("deceased"));
//		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
//		patient.setNationality((String)parsedmessage.get("nationality"));
//		patient.setCity((String)parsedmessage.get("city"));
//		
//		System.out.println("YA POPULE PATIENT");
//		
//		//String vecDate = (String)parsedmessage.get("vecDate");
//		
//		health.setCod((int)parsedmessage.get("codSecure"));
//		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
//		
//		//healthInsuranceService.addNewHealthInsurance(health);
//		
//		//health.setVecDate(parse.parseStringToDate(vecDate));
//	
//		System.out.println("YA POPULE HEALTH INSURANCE");
//		
//
//		//insertamos en la base de datos, los datos del paciente -- Deberia insertar health insurance tambien
//		
//		
//		if(patientService == null) {
//			System.out.println("EL SERVICIO patientService ES NULL");
//		} else {
//			System.out.println("EL SERVICIO patientService no ES NULL");
//			System.out.println(patient.toString());
//			patientService.addNewPatient(patient);
//			System.out.println("YA AGRUEGUE A LA BD DE PATIENT");
//		}
//	
//		
//		patient.setCodSecure(health);
//		
//		medical.setCod((int)parsedmessage.get("codDoctor"));
//		medical.setName((String)parsedmessage.get("nameDoctor"));
//		medical.setSpeciality((String)parsedmessage.get("speciality"));
//		
//		System.out.println("YA POPULE MEDICAL");
//		
//		//medicalStaffService.addNewMedicalStaff(medical);
//		
//		//insertamos en la base de datos, el registro del evento
//		
//		PatientHistory ph = new PatientHistory();
//		ph.setAdtCode("ADT-A04");
//		ph.setDetails("A Patient REGISTRATION was triggered to " + patient.getName() + " patient");
//		ph.setPatientPH(patient);
//		
//		System.out.println("YA POPULE PATIENT HISTORY");
//		
//		//HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
//		//ph.setEventDate((Date) mshDate.get("sqlDate"));
//		//ph.setEventTime((Time) mshDate.get("sqlTime"));
//		
//		if(patientHistoryService == null) {
//			System.out.println("EL SERVICIO patientHistoryService ES NULL");
//		} else {
//			System.out.println("EL SERVICIO patientHistoryService no ES NULL");
//			patientHistoryService.addPatientHistory(ph);
//			System.out.println("YA AGRUEGUE A LA BD DE PH");
//		}
//		
//		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
		
		System.out.println("YA GENERE EL ACK");
		
		return ack;
		
	}
	
	
	// Patient Pre-admission
	
	public String ADT05Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		System.out.println("PARSEARE UN un adt a05");
		parsedmessage = parse.ADT(message);
		System.out.println("SI PUDE PARSEAR");
		
		if((String) parsedmessage.get("evnCode") != "ADTA05") {
			return "";
		}
		
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
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
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A04");
		ph.setDetails("A Patient PRE-ADMISSION was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
		
		patientHistoryService.addPatientHistory(ph);
		
		Schedule sh = new Schedule();
		sh.setCodDoctor(medical);
		sh.setCodPatient(patient);
		
		//This is admit date time
		int year = (int)parsedmessage.get("admitYear"); 
		int month = (int)parsedmessage.get("admitMonth");  
		int day = (int)parsedmessage.get("admitDay"); 
		int hour = (int)parsedmessage.get("admitHour"); 
		int min = (int)parsedmessage.get("admitMin"); 
		
		// should be "2010-01-31"
		Date sqlDate = java.sql.Date.valueOf(Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));
		//should be "18:05:00"
		Time sqlTime = java.sql.Time.valueOf(Integer.toString(hour) + ":" + Integer.toString(min) + ":" + ":00");
		
		sh.setDate(sqlDate);
		sh.setHour(sqlTime);
		
		//insertamos en la base de datos,el agendamiento
		
		scheduleService.addNewSchedule(sh);
	
		
//		scheduleService.addNewDiagnostic(patient, medical, date, hour)
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
					
		return ack;
		
	}
	
	public String ADT08Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		if((String) parsedmessage.get("evnCode") != "A08") {
			return "";
		}
		
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
		
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
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A04");
		ph.setDetails("A Patient REGISTRATION was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
				
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
				
		patientHistoryService.addPatientHistory(ph);
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
			
		return ack;
		
	}
	
	public String ADT11Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		if((String) parsedmessage.get("evnCode") != "A11") {
			return "";
		}
		
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		MedicalStaff medical = new MedicalStaff();
		
		
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
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A04");
		ph.setDetails("A Patient REGISTRATION was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
				
		patientHistoryService.addPatientHistory(ph);
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
			
		return ack;
		
		
	}
	
	public String ADT12Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		if((String) parsedmessage.get("evnCode") != "A12") {
			return "";
		}
		
		Patient patient = new Patient();
		
		
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
		
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A04");
		ph.setDetails("A Patient REGISTRATION was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
				
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
			
		patientHistoryService.addPatientHistory(ph);
		
		//we generate ack based on transactions and other information
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		String ack = create.CreateACK(mshControlID,"AA","HIS",sedingApp);
		
		return ack;
		
	}
	
	public String ADT13Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		if((String) parsedmessage.get("evnCode") != "A13") {
			return "";
		}
		
		Patient patient = new Patient();
		
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
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A04");
		ph.setDetails("A Patient REGISTRATION was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
				
		HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
		ph.setEventDate((Date) mshDate.get("sqlDate"));
		ph.setEventTime((Time) mshDate.get("sqlTime"));
				
		patientHistoryService.addPatientHistory(ph);
		
		
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
	
	private HashMap<String, Object> getMSHDateTime(HashMap<String, Object> parsedmessage) {
		//This is admit date time
		int year = (int)parsedmessage.get("yearMSH");
		int month = (int)parsedmessage.get("monthMSH");  
		int day = (int)parsedmessage.get("dayMSH"); 
		int hour = (int)parsedmessage.get("hourMSH"); 
		int min = (int)parsedmessage.get("minMSH"); 
			
				// should be "2010-01-31"
		Date sqlDate = java.sql.Date.valueOf(Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));
				//should be "18:05:00"
		Time sqlTime = java.sql.Time.valueOf(Integer.toString(hour) + ":" + Integer.toString(min) + ":" + ":00");
		
		HashMap<String, Object> mshDate = new HashMap<String, Object>();
		
		mshDate.put("sqlDate", sqlDate);
		mshDate.put("sqlTime", sqlTime);
		
		return mshDate;
		
				
	}

}
