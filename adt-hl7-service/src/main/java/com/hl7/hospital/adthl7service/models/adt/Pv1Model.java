package com.hl7.hospital.adthl7service.models.adt;

public class Pv1Model {
	private String pv1ID;
	private String attendingDoctorName;
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
