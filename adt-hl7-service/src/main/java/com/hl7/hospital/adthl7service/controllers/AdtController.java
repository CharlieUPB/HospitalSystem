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
import com.hl7.hospital.adthl7service.errors.*;

import ca.uhn.hl7v2.HL7Exception;

@RestController
@RequestMapping(path = "/adt")
public class AdtController {

	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public HashMap<String, Object> info() {
		String[] supported = {"adt-a01", "adt-a02" , "adt-a03" , "adt-a04" , "adt-a05" , "adt-a08", "adt-a11", "adt-a12", "adt-a13"};
		HashMap<String,Object> supportedADTSMap = new HashMap<String, Object>();
		supportedADTSMap.put("HL7-version" , "2.4");
		supportedADTSMap.put("supported-adt", supported);
		
		return supportedADTSMap;
	}
	
	@RequestMapping(
			value = "/a01" ,
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA01Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A01")) {
			Message response = new Message(); 
			String data;
			try {
				data = create.CreateADT_A01(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(),
							genericMessage.getPidModel().getCity(),
							genericMessage.getIn1Model().getIn1ID(),
							genericMessage.getIn1Model().getInsuranceCompanyName(),
							genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
	
	@RequestMapping(
			value = "/a02",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA02Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A02")) {
			Message response = new Message(); 
			String data;
			try {
				data = create.CreateADT_A02(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				//por que OBR???? y no PV1
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
	@RequestMapping(
			value = "/a03",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA03Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A03")) {
			Message response = new Message(); 
			String data;
			try {
				data = create.CreateADT_A03(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
	@RequestMapping(
			value = "/a04", 
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA04Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A04")) {
			Message response = new Message();
			String data;
			try {
				data = create.CreateADT_A04(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
	@RequestMapping(
			value = "/a05",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA05Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A05")) {
			Message response = new Message(); 
			String data;
			try {
				data = create.CreateADT_A05(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic(),
							genericMessage.getPv1Model().getAdmitDateYear(),
							genericMessage.getPv1Model().getAdmitDateMonth(),
							genericMessage.getPv1Model().getAdmitDateDay(),
							genericMessage.getPv1Model().getAdmitDateHour(),
							genericMessage.getPv1Model().getAdmitDateMin()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
	@RequestMapping(
			value = "/a08",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA08Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A08")) {
			Message response = new Message(); 
			String data;
			try {
				data = create.CreateADT_A08(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
	
	@RequestMapping(
			value = "/a11",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA11Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A11")) {
			Message response = new Message();
			String data;
			try {
				data = create.CreateADT_A11(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
	@RequestMapping(
			value = "/a12",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA12Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A12")) {
			Message response = new Message(); 
			String data;
			try {
				data = create.CreateADT_A12(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
	}
	
	@RequestMapping(
			value = "/a13",
			method = RequestMethod.POST)
	public @ResponseBody Message ADTA13Controller(@RequestBody GenericMessage genericMessage) {
		Create create = new Create();
		if (genericMessage.getEvn().equals("A13")) {
			Message response = new Message();
			String data;
			try {
				data = create.CreateADT_A13(genericMessage.getMshModel().getSendingApplication(), genericMessage.getPidModel().getSurName(), genericMessage.getPidModel().getName(), 
							genericMessage.getPidModel().getIdPID(), genericMessage.getPidModel().getGender(), genericMessage.getPidModel().getBirthDate(), genericMessage.getPidModel().getPhoneNumber(), 
							genericMessage.getPidModel().getPhoneBusiness(), genericMessage.getPidModel().getAddress(), genericMessage.getPidModel().getDeathIndicator(), genericMessage.getPidModel().getMaritalStatus(), 
							genericMessage.getPidModel().getNationality(), genericMessage.getPidModel().getCity(), genericMessage.getIn1Model().getIn1ID(), genericMessage.getIn1Model().getInsuranceCompanyName(), genericMessage.getIn1Model().getInsuranceExpirationDate(), 
							genericMessage.getPv1Model().getPv1ID(),
							genericMessage.getPv1Model().getAttendingDoctorName(),
							genericMessage.getPv1Model().getAttendingDoctorLastName(),
							genericMessage.getPv1Model().getPatientClass(),
							genericMessage.getObxModel().getDiagnostic()).toString();
				response.setData(data);
				return response;
			} catch (HL7Exception | IOException e) {
				throw new ParsingException();
			}
		} else {
			throw new BadRequestException();
		}
		
	}
	
}
