package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pv1Model {
	
	@JsonProperty(value = "ID")
	private String pv1ID;
	@JsonProperty(value = "attendingDoctorName")
	private String attendingDoctorName;
	@JsonProperty(value = "attendingDoctorLastName")
	private String attendingDoctorLastName;
	
	public String getPv1ID() {
		return pv1ID;
	}
	public void setPv1ID(String pv1id) {
		pv1ID = pv1id;
	}
	public String getAttendingDoctorName() {
		return attendingDoctorName;
	}
	public void setAttendingDoctorName(String attendingDoctorName) {
		this.attendingDoctorName = attendingDoctorName;
	}
	public String getAttendingDoctorLastName() {
		return attendingDoctorLastName;
	}
	public void setAttendingDoctorLastName(String attendingDoctorLastName) {
		this.attendingDoctorLastName = attendingDoctorLastName;
	}
}
