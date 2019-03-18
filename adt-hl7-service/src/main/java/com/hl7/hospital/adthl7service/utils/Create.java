package com.hl7.hospital.adthl7service.utils;

import java.io.IOException;

import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;

import ca.uhn.hl7v2.DefaultHapiContext;
 import ca.uhn.hl7v2.HL7Exception;
 import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.v24.datatype.TX;
import ca.uhn.hl7v2.model.v24.group.ADT_A01_INSURANCE;
import ca.uhn.hl7v2.model.v24.group.ADT_A05_INSURANCE;
import ca.uhn.hl7v2.model.v24.group.ORM_O01_INSURANCE;
import ca.uhn.hl7v2.model.v24.group.ORM_O01_OBSERVATION;
import ca.uhn.hl7v2.model.v24.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v24.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v24.group.RDE_O11_INSURANCE;
import ca.uhn.hl7v2.model.v24.message.ACK;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.message.ADT_A02;
import ca.uhn.hl7v2.model.v24.message.ADT_A03;
import ca.uhn.hl7v2.model.v24.message.ADT_A05;
import ca.uhn.hl7v2.model.v24.message.ORM_O01;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.message.RDE_O11;
import ca.uhn.hl7v2.model.v24.segment.MSA;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.OBR;
import ca.uhn.hl7v2.model.v24.segment.OBX;
import ca.uhn.hl7v2.model.v24.segment.ORC;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v24.segment.PV1;
import ca.uhn.hl7v2.parser.Parser;

public class Create {
	

public String CreateADT_A01(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A01 adt = new ADT_A01();
	          adt.initQuickstart("ADT", "A01", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ADT_A01_INSURANCE in = adt.getINSURANCE();
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);
	          
	          
	          /*
	           * In a real situation, of course, many more segments and fields would be populated
	           */
	          
	          // Now, let's encode the message and look at the output
	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_A02(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A02 adt = new ADT_A02();
	          adt.initQuickstart("ADT", "A02", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);
	          
	          
	          /*
	           * In a real situation, of course, many more segments and fields would be populated
	           */
	          
	          // Now, let's encode the message and look at the output
	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_A03(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
			  ADT_A03 adt = new ADT_A03();
	          adt.initQuickstart("ADT", "A03", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);
	          
	          
	          /*
	           * In a real situation, of course, many more segments and fields would be populated
	           */
	          
	          // Now, let's encode the message and look at the output
	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}


public String CreateADT_A04(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A01 adt = new ADT_A01();
	          adt.initQuickstart("ADT", "A01", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ADT_A01_INSURANCE in = adt.getINSURANCE();
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);
	          
	          
	          /*
	           * In a real situation, of course, many more segments and fields would be populated
	           */
	          
	          // Now, let's encode the message and look at the output
	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_A05(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A05 adt = new ADT_A05();
	          adt.initQuickstart("ADT", "A05", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ADT_A05_INSURANCE in = adt.getINSURANCE();
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_A08(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A05 adt = new ADT_A05();
	          adt.initQuickstart("ADT", "A05", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ADT_A05_INSURANCE in = adt.getINSURANCE();
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_A11(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A05 adt = new ADT_A05();
	          adt.initQuickstart("ADT", "A05", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ADT_A05_INSURANCE in = adt.getINSURANCE();
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_A12(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A05 adt = new ADT_A05();
	          adt.initQuickstart("ADT", "A05", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ADT_A05_INSURANCE in = adt.getINSURANCE();
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_A13(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic) throws HL7Exception, IOException {
	ADT_A05 adt = new ADT_A05();
	          adt.initQuickstart("ADT", "A05", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPID(); 
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ADT_A05_INSURANCE in = adt.getINSURANCE();
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          PV1 pv1 = adt.getPV1();
	          pv1.getSetIDPV1().setValue(codDoctor);
	          pv1.getAttendingDoctor(0).getGivenName().setValue(nameDoctor);
	          pv1.getAttendingDoctor(0).getFamilyName().getFn1_Surname().setValue(lastNameDoctor);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = adt.getOBX();
	          obx.getObservationValue(0).setData(tx);

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateORU(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic,
		String ORCOrderControl, String ORCPlacerGroup) throws HL7Exception, IOException {
	ORU_R01 adt = new ORU_R01();
	          adt.initQuickstart("ORU", "R01", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPATIENT_RESULT(0).getPATIENT().getPID();
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ORU_R01_ORDER_OBSERVATION orderObservation = adt.getPATIENT_RESULT().getORDER_OBSERVATION();
	          OBR obr = orderObservation.getOBR();
	          obr.getSetIDOBR().setValue("1");
	          obr.getFillerOrderNumber().getEntityIdentifier().setValue("1234");
	          obr.getFillerOrderNumber().getNamespaceID().setValue("LAB");
	          ORU_R01_OBSERVATION observation = orderObservation.getOBSERVATION(0);
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          OBX obx = observation.getOBX();
	          obx.getObservationValue(0).setData(tx);

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateADT_ORM01(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic,
		String ORCOrderControl, String ORCPlacerGroup) throws HL7Exception, IOException {
	ORM_O01 adt = new ORM_O01();
	          adt.initQuickstart("ORM", "O01", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPATIENT().getPID();
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          ORM_O01_INSURANCE  in = adt.getPATIENT().getINSURANCE(0);
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          ORC orc = adt.getORDER(0).getORC();
	          orc.getOrderControl().setValue(ORCOrderControl);
	          orc.getPlacerGroupNumber().getEi1_EntityIdentifier().setValue(ORCPlacerGroup);
	          

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

public String CreateRDE_011(String MSHmessageName, String MSHControlID, String PIDname, String PIDlastName, String PIDcodPatient, String PIDGender, String birthDate, String phone, String cellPhone, String address, String deceased, String maritalStatus, String nationality, String city,
		String codSecure, String nameOrganization, String vecDate, String codDoctor, String nameDoctor, String lastNameDoctor, String diagnostic,
		String ORCOrderControl, String ORCPlacerGroup) throws HL7Exception, IOException {
	RDE_O11 adt = new RDE_O11();
	          adt.initQuickstart("RDE", "011", "P");
	          
	          // Populate the MSH Segment
	          MSH mshSegment = adt.getMSH();
	          mshSegment.getSendingApplication().getNamespaceID().setValue(MSHmessageName);
	          mshSegment.getMessageControlID().setValue(MSHControlID);
	          
	          // Populate the PID Segment
	          PID pid = adt.getPATIENT().getPID();
	          pid.getSetIDPID().setValue(PIDcodPatient);
	          pid.getPatientName(0).getFamilyName().getSurname().setValue(PIDname);
	          pid.getPatientName(0).getGivenName().setValue(PIDlastName);
	          pid.getBirthOrder().setValue(birthDate);
	          pid.getAdministrativeSex().setValue(PIDGender);
	          pid.getPhoneNumberHome()[0].getPhoneNumber().setValue(phone);
	          pid.getPhoneNumberBusiness()[0].getPhoneNumber().setValue(cellPhone);
	          pid.getPatientAddress()[0].getStreetAddress().getStreetName().setValue(address);
	          pid.getPatientDeathIndicator().setValue(deceased);
	          pid.getMaritalStatus().getText().setValue(maritalStatus);
	          pid.getNationality().getText().setValue(nationality);
	          pid.getCitizenship(0).getText().setValue(city);
	          
	          
	          RDE_O11_INSURANCE  in = adt.getPATIENT().getINSURANCE(0);
	          in.getIN1().getSetIDIN1().setValue(codSecure);
	          in.getIN1().getInsuranceCompanyName(0).getOrganizationName().setValue(nameOrganization);
	          in.getIN1().getPlanExpirationDate().setValue(vecDate);
	          
	          TX tx = new TX(adt);
	                  tx.setValue(diagnostic);
	          ORC orc = adt.getORDER(0).getORC();
	          orc.getOrderControl().setValue(ORCOrderControl);
	          orc.getPlacerGroupNumber().getEi1_EntityIdentifier().setValue(ORCPlacerGroup);
	          

	          HapiContext context = new DefaultHapiContext();
	          Parser parser = context.getPipeParser();
	          String encodedMessage = parser.encode(adt);
	          System.out.println("Printing ER7 Encoded Message:");
	          System.out.println(encodedMessage);
	
	return encodedMessage;
	
	}

	//acknowledgeCode should be
	// AA Application Accept
	// AE Application Error
	// AR Appilcation Reject

	public String CreateACK (String MSHControlID, String acknowledgeCode) throws HL7Exception, IOException {
		ACK ack = new ACK();
		ack.initQuickstart("ACK", "ACK", "P");
		MSH mshSegment = ack.getMSH();
		mshSegment.getSecurity().setValue("ACK");
		mshSegment.getMessageControlID().setValue(MSHControlID);
		
		MSA msaSegmentMsa = ack.getMSA();
		msaSegmentMsa.getAcknowledgementCode().setValue(acknowledgeCode);
		
		HapiContext context = new DefaultHapiContext();
        Parser parser = context.getPipeParser();
        String encodedMessage = parser.encode(ack);
		return encodedMessage;
	}
}


