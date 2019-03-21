package com.hl7.hospital.adthl7service.controllers;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.errors.BadRequestException;
import com.hl7.hospital.adthl7service.models.Message;
import com.hl7.hospital.adthl7service.models.adt.GenericMessage;
import com.hl7.hospital.adthl7service.utils.Create;

import ca.uhn.hl7v2.HL7Exception;

@RestController
@RequestMapping(path = "/orm")
public class OrmController {
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public HashMap<String, Object> info() {
		String[] supported = {"orm-o01"};
		HashMap<String,Object> supportedORMSMap = new HashMap<String, Object>();
		supportedORMSMap.put("HL7-version" , "2.4");
		supportedORMSMap.put("supported-orm", supported);
		
		return supportedORMSMap;
	}

	@RequestMapping(
			value = "/orm-o01",
			method = RequestMethod.POST)
	public @ResponseBody Message ORMController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Create create = new Create();
		if (genericMessage.getEvn().equals("O01")) {
			Message response = new Message();
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
		return response;
		} else {
			throw new BadRequestException();
		}
		
	}
	
}
