package com.hl7.hospital.adthl7service.controllers;

import java.io.IOException;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.events.EventProducer;
import com.hl7.hospital.adthl7service.models.adt.GenericMessage;
import com.hl7.hospital.adthl7service.utils.Create;

import ca.uhn.hl7v2.HL7Exception;

@RestController
@RequestMapping(path = "/adt")
public class AdtController {

	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public HashMap<String, Object> info() {
		String[] supported = {"adt-01", "adt-02" , "adt-03" , "adt-04" , "adt-05" , "adt-08", "adt-11", "adt-12", "adt-13"};
		HashMap<String,Object> supportedADTSMap = new HashMap<String, Object>();
		supportedADTSMap.put("HL7-version" , "2.3");
		supportedADTSMap.put("supported-adt", supported);
		
		EventProducer.getInstance().publishMessage("ADT-01", "Desde java te mando un mensaje");
		
		return supportedADTSMap;
	}
	
	@RequestMapping(
			value = "/a01" , 
			method = RequestMethod.POST)
	public String createA01(@RequestBody String payload) {
		return "Preparing to parse a01" + payload;
	}
	
	@RequestMapping(
			value = "/a02",
			method = RequestMethod.POST)
	public String createA02() {
		return "Preparing to parse a02";
	}
	
	@RequestMapping(
			value = "/a03",
			method = RequestMethod.POST)
	public String createA03() {
		return "Preparing to parse a03";
	}
	
	@RequestMapping(
			value = "/a04", 
			method = RequestMethod.POST)
	public String createA04() {
		return "Preparing to parse a04";
	}
	
	@RequestMapping(
			value = "/a05",
			method = RequestMethod.POST)
	public String createA05() {
		return "Preparing to parse a05";
	}
	
	
	@RequestMapping(
			value = "/a08",
			method = RequestMethod.POST)
	public String createA08() {
		return "Preparing to parse a08";
	}
	
	@RequestMapping(
			value = "/a11",
			method = RequestMethod.POST)
	public String createA11() {
		return "Preparing to parse a11";
	}
	
	
	@RequestMapping(
			value = "/a12",
			method = RequestMethod.POST)
	public String createA12() {
		return "Preparing to parse a12";
	}
	
	
	@RequestMapping(
			value = "/a13",
			method = RequestMethod.POST)
	public String createA13() {
		return "Preparing to parse a13";
	}
	
	public String ADTA01Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A01")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A01(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA02Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A02")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A02(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA03Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A03")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A03(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA04Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A04")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A04(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA05Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A05")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A05(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA08Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A08")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A08(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA11Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A11")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A11(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA12Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A12")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A12(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ADTA13Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A13")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_A13(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String ORMController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ORM-O01")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateADT_ORM01(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
				genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
				genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), 
				genericMessage.getPidModel().getMaritalStatus(), 
				genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), 
				genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
				genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), 
				genericMessage.getObrModel().getDiagnostic(), genericMessage.getOrcModel().getOrcOrderControl(), genericMessage.getOrcModel().getPalcerGroupNumber()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String RDEController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("RDE-011")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateRDE_011(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
				genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
				genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), 
				genericMessage.getPidModel().getMaritalStatus(), 
				genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), 
				genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
				genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), 
				genericMessage.getObrModel().getDiagnostic(), genericMessage.getOrcModel().getOrcOrderControl(), genericMessage.getOrcModel().getPalcerGroupNumber()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
	
	public String OMLController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		String adtmsg = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("OML-O21")) {
			HashMap<String, String> msg = new HashMap<>(); 
		String data =create.CreateOML_O21(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getSequenceNumber(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
				genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
				genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), 
				genericMessage.getPidModel().getMaritalStatus(), 
				genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), 
				genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
				genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), 
				genericMessage.getObrModel().getDiagnostic(), genericMessage.getOrcModel().getOrcOrderControl(), genericMessage.getOrcModel().getPalcerGroupNumber()).toString();
		msg.put("data", data);
		msg.put("version", "2.4");
		adtmsg = msg.toString();
		}
		return adtmsg;
	}
}
