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
	PatientHistoryService patientHistoryService;
	
	@Autowired
	ScheduleService scheduleService;
	
	Parse parse = new Parse();
	Create create = new Create();
	
	
	// Patient Admit
	public String ADT01Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A01")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-01 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		
		if(patient == null) {
			System.out.println("No se puede admitir a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		//Registramos en la base de datos el evento.
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A01");
		ph.setDetails("A Patient ADMIT was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
		
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
		
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		//insertamos en la base de datos, los datos del paciente
	
		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);
	}
	
	
	//Patient Transfer
	public String ADT02Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A02")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-02 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		

		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		
		if(patient == null) {
			System.out.println("No se puede realiar el evento a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A02");
		ph.setDetails("A Patient TRANSFER was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
		
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
		
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		
		// insertamos en la base de datos, los datos del paciente
		
		
		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);
	}
	
	//Patient Discharge
	public String ADT03Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A03")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-03 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		
		if(patient == null) {
			System.out.println("No se puede realizar el evento a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A03");
		ph.setDetails("A Patient DISCHARGE was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
		
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
		
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		
		//insertamos en la base de datos, los datos del paciente
		
		
		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);

	}
	
	//Patient Registration
	public String ADT04Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A04")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-04 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		Patient patient = new Patient();
		HealthInsurance health = new HealthInsurance();
		
		patient.setCI((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setBirthDate((Date) parsedmessage.get("birthDate"));
		patient.setPhone((String)parsedmessage.get("phone"));
		patient.setCellPhone((String)parsedmessage.get("cellPhone"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
		health.setVecDate(parse.parseStringToDate((String)parsedmessage.get("vecDate")));
		patient.setCodSecure(health);
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A04");
		ph.setDetails("A Patient REGISTRATION was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
		
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		ph.setMshID(mshControlID);
	
		//we generate ack based on transactions and other information
				
		try {
			patientHistoryService.addPatientHistory(ph);
			//insertamos en la base de datos, los datos del paciente -- Deberia insertar health insurance tambien
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AE","HIS",sedingApp);
		}
		
		try {
			patientService.addNewPatient(patient);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AE","HIS",sedingApp);
		}

		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);
		
	}
	
	
	// Patient Pre-admission
	
	public String ADT05Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A05")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-05 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		
		if(patient == null) {
			System.out.println("No se puede realizar el evento a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		int CodDoc = (int)parsedmessage.get("codDoctor");
		MedicalStaff medical = null; 
		Optional<MedicalStaff> medicalOpt = this.medicalStaffService.getMedicalStaffByID(CodDoc);
		if(medicalOpt.isPresent()) {
			medical = medicalOpt.get();
		} else {
			medical = new MedicalStaff();
			medical.setName((String)parsedmessage.get("nameDoctor"));
			medical.setLastName((String)parsedmessage.get("lastNameDoctor"));
			medical.setSpeciality((String)parsedmessage.get("speciality"));
		}
		
		//insertamos en la base de datos el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A05");
		ph.setDetails("A Patient PRE-ADMISSION was triggered to " + patient.getName() + " patient");
		
		ph.setPatientPH(patient);
		ph.setAcked(false);
		
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
		
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		
		Schedule sh = new Schedule();
		sh.setCodDoctor(medical);
		sh.setCodPatient(patient);
		
		//This is admit date time
		int year = (int)parsedmessage.get("admitYear"); 
		int month = (int)parsedmessage.get("admitMonth");  
		int day = (int)parsedmessage.get("admitDay"); 
		int hour = (int)parsedmessage.get("admitHour"); 
		int min = (int)parsedmessage.get("admitMin"); 
		
		try {
			// should be "2010-01-31"
			Date sqlDate = java.sql.Date.valueOf(Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));
			//should be "18:05:00"
			Time sqlTime = java.sql.Time.valueOf(Integer.toString(hour) + ":" + Integer.toString(min) + ":" + "00");
			sh.setDate(sqlDate);
			sh.setHour(sqlTime);
		} catch (Exception e) {
			System.out.println("No se pudo agendar porque las fechas estan mal");
			e.printStackTrace();
		}
	
		//insertamos en la base de datos,el agendamiento
		
		try {
			scheduleService.addNewSchedule(sh);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);
	}
	
	// Update patient information
	public String ADT08Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A08")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-08 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		HealthInsurance health = new HealthInsurance();
		
		if(patient == null) {
			System.out.println("No se puede admitir a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		patient.setCI((int)parsedmessage.get("codPatient"));
		patient.setName((String)parsedmessage.get("name"));
		patient.setLastName((String)parsedmessage.get("lastName"));
		patient.setGender((int)parsedmessage.get("gender"));
		patient.setBirthDate((Date) parsedmessage.get("birthDate"));
		patient.setAddress((String)parsedmessage.get("address"));
		patient.setDeceased((boolean)parsedmessage.get("deceased"));
		patient.setMaritalStatus((String)parsedmessage.get("maritalStatus"));
		patient.setNationality((String)parsedmessage.get("nationality"));
		patient.setCity((String)parsedmessage.get("city"));
		
		health.setNameOrganization((String)parsedmessage.get("nameOrganization"));
		health.setVecDate(parse.parseStringToDate((String)parsedmessage.get("vecDate")));
		patient.setCodSecure(health);
		
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A08");
		ph.setDetails("A Patient UPDATE INFORMATION was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
				
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
		
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
			
		//hacer consulta sql para editar la informacion del paciente que tenga ese codigo
		
		try {
			patientService.addNewPatient(patient);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		
		//hacer consulta sql para editar la informacion del paciente que tenga ese codigo
	
		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);
		
	}
	
	// Cancel admit visit notification
	public String ADT11Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A11")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-11 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		
		if(patient == null) {
			System.out.println("No se puede realizar el evento a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
	
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A11");
		ph.setDetails("A Patient CANCEL ADMIT was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
		
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
		
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		
		//insertamos en la base de datos, los datos del paciente
		
		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);

	}
	
	// Cancel Transfer
	public String ADT12Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A12")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-12 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		
		if(patient == null) {
			System.out.println("No se puede realizar el evento a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
	
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A12");
		ph.setDetails("A Patient CANCEL TRANSFER was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
				
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
			
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		
		//insertamos en la base de datos, los datos del paciente
		
		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);
	}
	
	// Cancel discharge/end visit
	public String ADT13Handler (String message) throws HL7Exception, IOException {
		
		HashMap<String, Object> parsedmessage = new HashMap<>();
		parsedmessage = parse.ADT(message);
		
		String evnCode = (String) parsedmessage.get("evnCode");
		
		if( !(evnCode.equals("A13")) ) {
			System.out.println("***** ENTRASTE A UN TOPICO ADT-13 PERO EL CAMPO EVN INDICA: " + evnCode);
			return "";
		}
		
		String mshControlID = (String) parsedmessage.get("mshControlID");
		String sedingApp = (String) parsedmessage.get("mshSendingApplication");
		
		int CI = (int)parsedmessage.get("codPatient");
		Patient patient = this.patientService.getPatientByCI(CI);
		
		if(patient == null) {
			System.out.println("No se puede realizar el evento a un paciente no registrado");
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
	
		//insertamos en la base de datos, el registro del evento
		
		PatientHistory ph = new PatientHistory();
		ph.setAdtCode("ADT-A13");
		ph.setDetails("A Patient CANCEL DISCHARGE was triggered to " + patient.getName() + " patient");
		ph.setPatientPH(patient);
		ph.setAcked(false);
				
		try {
			HashMap<String, Object> mshDate = this.getMSHDateTime(parsedmessage);
			ph.setEventDate((Date) mshDate.get("sqlDate"));
			ph.setEventTime((Time) mshDate.get("sqlTime"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al obtener la fecha del MSH");
		}
		
		ph.setMshID(mshControlID);
		
		try {
			patientHistoryService.addPatientHistory(ph);
		} catch (Exception e) {
			e.printStackTrace();
			return create.CreateACK(mshControlID,"AR","HIS",sedingApp);
		}
		
		
		//insertamos en la base de datos, los datos del paciente

		return create.CreateACK(mshControlID,"AA","HIS",sedingApp);
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
	
	public String ackRcvHandler(String mshID) {
		PatientHistory pHistory = this.patientHistoryService.findByMSHID(mshID);
		if(pHistory == null) {
			System.out.println("No se pudo actualizar el evento con ese id, porque no se lo encontro");
		} else {
			pHistory.setAcked(true);;
			this.patientHistoryService.addPatientHistory(pHistory);
		}
		return "";
	}
	
	private HashMap<String, Object> getMSHDateTime(HashMap<String, Object> parsedmessage) {
		//This is admit date time
		int year = (int)parsedmessage.get("mshYear");
		int month = (int)parsedmessage.get("mshMonth");  
		int day = (int)parsedmessage.get("mshDay"); 
		int hour = (int)parsedmessage.get("mshHour"); 
		int min = (int)parsedmessage.get("mshMin"); 
			
				// should be "2010-01-31"
		Date sqlDate = java.sql.Date.valueOf(Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));
				//should be "18:05:00"
		Time sqlTime = java.sql.Time.valueOf(Integer.toString(hour) + ":" + Integer.toString(min) + ":" + "00");
		
		HashMap<String, Object> mshDate = new HashMap<String, Object>();
		
		mshDate.put("sqlDate", sqlDate);
		mshDate.put("sqlTime", sqlTime);
		
		return mshDate;
		
				
	}

}
