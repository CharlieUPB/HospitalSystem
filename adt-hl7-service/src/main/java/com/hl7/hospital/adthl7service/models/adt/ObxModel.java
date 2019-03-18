package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObxModel {
	
	@JsonProperty(value = "ID")
	private String obxID;
	@JsonProperty(value = "diagnostic")
	private String diagnostic;
	
	public String getObxID() {
		return obxID;
	}
	public void setObxID(String obxID) {
		this.obxID = obxID;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
}
