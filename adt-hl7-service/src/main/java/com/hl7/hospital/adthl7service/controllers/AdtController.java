package com.hl7.hospital.adthl7service.controllers;

import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.events.EventProducer;
import com.hl7.hospital.adthl7service.models.Message;
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
		supportedADTSMap.put("HL7-version" , "2.4");
		supportedADTSMap.put("supported-adt", supported);
		
		return supportedADTSMap;
	}
	
	@RequestMapping(
			value = "/a01" , 
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA01Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A01")) {
			response = new Message(); 
		String data =create.CreateADT_A01(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	
	@RequestMapping(
			value = "/a02",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA02Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A02")) {
			response = new Message(); 
		String data =create.CreateADT_A02(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/a03",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA03Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null; 
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A03")) {
			response = new Message(); 
		String data =create.CreateADT_A03(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/a04", 
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA04Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A04")) {
			response = new Message();
		String data =create.CreateADT_A04(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/a05",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA05Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A05")) {
			response = new Message(); 
		String data =create.CreateADT_A05(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/a08",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA08Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A08")) {
			response = new Message(); 
		String data =create.CreateADT_A08(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	
	@RequestMapping(
			value = "/a11",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA11Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A11")) {
			response = new Message();
		String data =create.CreateADT_A11(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/a12",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA12Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A12")) {
			response = new Message(); 
		String data =create.CreateADT_A12(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/a13",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA13Controller(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ADT-A13")) {
			response = new Message();
		String data =create.CreateADT_A13(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
					genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
					genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
					genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
					genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), genericMessage.getObrModel().getDiagnostic()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/orm",
			method = RequestMethod.POST)
	public @ResponseBody Message ORMController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("ORM-O01")) {
			response = new Message();
		String data =create.CreateADT_ORM01(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
				genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
				genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), 
				genericMessage.getPidModel().getMaritalStatus(), 
				genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), 
				genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
				genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), 
				genericMessage.getObrModel().getDiagnostic(), genericMessage.getOrcModel().getOrcOrderControl(), genericMessage.getOrcModel().getPalcerGroupNumber()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/rde",
			method = RequestMethod.POST)
	public @ResponseBody Message RDEController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("RDE-011")) {
			response = new Message();
		String data =create.CreateRDE_011(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
				genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
				genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), 
				genericMessage.getPidModel().getMaritalStatus(), 
				genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), 
				genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
				genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), 
				genericMessage.getObrModel().getDiagnostic(), genericMessage.getOrcModel().getOrcOrderControl(), genericMessage.getOrcModel().getPalcerGroupNumber()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
	
	@RequestMapping(
			value = "/oml",
			method = RequestMethod.POST)
	public @ResponseBody Message OMLController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Message response = null;
		Create create = new Create();
		if (genericMessage.getEvn().equals("OML-O21")) {
			response = new Message();
		String data =create.CreateOML_O21(genericMessage.getMshModel().getSendinAplication(), genericMessage.getMshModel().getMshControlID(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
				genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
				genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), 
				genericMessage.getPidModel().getMaritalStatus(), 
				genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), 
				genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
				genericMessage.getObrModel().getObrID(), genericMessage.getObrModel().getEntityIdentifier(), genericMessage.getObrModel().getNameSpaceID(), 
				genericMessage.getObrModel().getDiagnostic(), genericMessage.getOrcModel().getOrcOrderControl(), genericMessage.getOrcModel().getPalcerGroupNumber()).toString();
		response.setData(data);
		response.setMessageControlID(genericMessage.getMshModel().getMshControlID());
		}
		return response;
	}
}
