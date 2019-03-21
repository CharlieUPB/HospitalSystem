package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pv1Model {
	
	@JsonProperty(value = "ID")
	private String pv1ID;
	@JsonProperty(value = "attendingDoctorName")
	private String attendingDoctorName;
	@JsonProperty(value = "attendingDoctorLastName")
	private String attendingDoctorLastName;
	@JsonProperty(value = "patientClass")
	private String patientClass;  // EMERGENCY (E) || INPATIENT (I) || OUTPATIENT (O) || PREADMIT (P)
	@JsonProperty(value = "admitDate")
	private String admitDateTime; // Should be passed like "2010-01-31"
	@JsonProperty(value = "admitDateHour")
	private String admitDateHour; // should be passes like "18:15:00"
	
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
	public String getPatientClass() {
		return patientClass;
	}
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}
	
	public String getAdmitDateTime() {
		return admitDateTime;
	}
	public void setAdmitDateTime(String admitDateTime) {
		this.admitDateTime = admitDateTime;
	}
	public String getAdmitDateHour() {
		return admitDateHour;
	}
	public void setAdmitDateHour(String admitDateHour) {
		this.admitDateHour = admitDateHour;
	}
}
