package com.hl7.hospital.adthl7service.controllers;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.models.Message;
import com.hl7.hospital.adthl7service.models.adt.GenericMessage;
import com.hl7.hospital.adthl7service.utils.Create;

import ca.uhn.hl7v2.HL7Exception;

@RestController
@RequestMapping(path = "/oml")
public class OmlController {
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public HashMap<String, Object> info() {
		String[] supported = {"oml-o21"};
		HashMap<String,Object> supportedOMLSMap = new HashMap<String, Object>();
		supportedOMLSMap.put("HL7-version" , "2.4");
		supportedOMLSMap.put("supported-oml", supported);
		
		return supportedOMLSMap;
	}
	
	@RequestMapping(
			value = "/oml-o21",
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
