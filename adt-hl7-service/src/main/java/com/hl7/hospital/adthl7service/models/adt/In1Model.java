package com.hl7.hospital.adthl7service.models.adt;

public class In1Model {
	private String in1ID;
	private String insuranceCompanyName;
	private String insuranceExpirationDate;
	public String getIn1ID() {
		return in1ID;
	}
	public void setIn1ID(String in1id) {
		in1ID = in1id;
	}
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public String getInsuranceExpirationDate() {
		return insuranceExpirationDate;
	}
	public void setInsuranceExpirationDate(String insuranceExpirationDate) {
		this.insuranceExpirationDate = insuranceExpirationDate;
	}
}
