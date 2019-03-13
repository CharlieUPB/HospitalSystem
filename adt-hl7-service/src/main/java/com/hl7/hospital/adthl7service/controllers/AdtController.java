package com.hl7.hospital.adthl7service.controllers;

import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hl7.hospital.adthl7service.events.EventProducer;

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
}
