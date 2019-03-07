package com.hl7.hospital.adthl7service.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/adt")
public class AdtController {

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String info() {
		return "The messages we supasdasasport are:";
	}
	
	@RequestMapping(
			value = "/a01" , 
			method = RequestMethod.POST)
	public String ao1(@RequestBody String payload) {
		return "Preparing to parse a01" + payload;
	}
	@RequestMapping(value = "/a02" , method = RequestMethod.POST)
	public String ao2() {
		return "Preparing to parse a02";
	}
	@RequestMapping(value = "/a03" , method = RequestMethod.POST)
	public String ao3() {
		return "Preparing to parse a03";
	}
	@RequestMapping(value = "/a04" , method = RequestMethod.POST)
	public String ao4() {
		return "Preparing to parse a04";
	}
	@RequestMapping(value = "/a05" , method = RequestMethod.POST)
	public String ao5() {
		return "Preparing to parse a05";
	}
	@RequestMapping(value = "/a06" , method = RequestMethod.POST)
	public String ao6() {
		return "Preparing to parse a06";
	}
	@RequestMapping(value = "/a07" , method = RequestMethod.POST)
	public String ao7() {
		return "Preparing to parse a07";
	}
	@RequestMapping(value = "/a08" , method = RequestMethod.POST)
	public String ao8() {
		return "Preparing to parse a08";
	}
	@RequestMapping(value = "/a10" , method = RequestMethod.POST)
	public String a10() {
		return "Preparing to parse a10";
	}
	@RequestMapping(value = "/a11" , method = RequestMethod.POST)
	public String a11() {
		return "Preparing to parse a11";
	}
	@RequestMapping(value = "/a12" , method = RequestMethod.POST)
	public String a12() {
		return "Preparing to parse a12";
	}
}
