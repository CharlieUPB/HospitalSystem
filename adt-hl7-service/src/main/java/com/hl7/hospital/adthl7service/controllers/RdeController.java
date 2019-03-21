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
@RequestMapping(path = "/rde")
public class RdeController {
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public HashMap<String, Object> info() {
		String[] supported = {"rde-o11"};
		HashMap<String,Object> supportedRDESMap = new HashMap<String, Object>();
		supportedRDESMap.put("HL7-version" , "2.4");
		supportedRDESMap.put("supported-rde", supported);
		
		return supportedRDESMap;
	}

	@RequestMapping(
			value = "/rde-o11",
			method = RequestMethod.POST)
	public @ResponseBody Message RDEController(@RequestBody GenericMessage genericMessage) throws HL7Exception, IOException {
		Create create = new Create();
		if (genericMessage.getEvn().equals("O11")) {
			Message response = new Message();
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
		return response;
		} else {
			throw new BadRequestException();
		}
		
	}
	
}
