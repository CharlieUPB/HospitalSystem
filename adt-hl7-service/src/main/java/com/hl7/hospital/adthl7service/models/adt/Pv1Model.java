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
	@JsonProperty(value = "admitDateYear")
	private int admitDateYear; 
	@JsonProperty(value = "admitDateMonth")
	private int admitDateMonth;
	@JsonProperty(value = "admitDateDay")
	private int admitDateDay; 
	@JsonProperty(value = "admitDateHour")
	private int admitDateHour;
	@JsonProperty(value = "admitDateMin")
	private int admitDateMin;
	
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
	
	
	public int getAdmitDateMonth() {
		return admitDateMonth;
	}
	public void setAdmitDateMonth(int admitDateMonth) {
		this.admitDateMonth = admitDateMonth;
	}
	public int getAdmitDateDay() {
		return admitDateDay;
	}
	public void setAdmitDateDay(int admitDateDay) {
		this.admitDateDay = admitDateDay;
	}
	public int getAdmitDateMin() {
		return admitDateMin;
	}
	public void setAdmitDateMin(int admitDateMin) {
		this.admitDateMin = admitDateMin;
	}
	public int getAdmitDateHour() {
		return admitDateHour;
	}
	public void setAdmitDateHour(int admitDateHour) {
		this.admitDateHour = admitDateHour;
	}
	public int getAdmitDateYear() {
		return admitDateYear;
	}
	public void setAdmitDateYear(int admitDateYear) {
		this.admitDateYear = admitDateYear;
	}
}
