package com.hl7.hospital.adthl7service.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.errors.NotFoundException;
import com.hl7.hospital.adthl7service.models.Message;
import com.hl7.hospital.adthl7service.models.adt.GenericMessage;
import com.hl7.hospital.adthl7service.utils.Parse;

import ca.uhn.hl7v2.HL7Exception;

@RestController
@RequestMapping(path = "/ack")
public class AckController {
	
	Parse parseUtil = new Parse();
	
	@RequestMapping(
			value = "/",
			method = RequestMethod.POST)
	public HashMap<String, Object> getACKID(@RequestBody Message mshhl7)
	{
		try {
			HashMap<String, Object> msh = this.parseUtil.getMSH(mshhl7.getData());
			String ackType = this.parseUtil.getAckType(mshhl7.getData());
			HashMap<String, Object> response = new HashMap<String, Object>();
			response.put("mshControlID", msh.get("mshControlID"));
			response.put("ackType", ackType);
			return response;
		} catch (HL7Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener el msh segment del ack");
			throw new NotFoundException();
		}
	}

}
