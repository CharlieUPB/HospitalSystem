package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrcModel {
	
	@JsonProperty(value = "ID")
	private String orcID;
	@JsonProperty(value = "diagnostic")
	private String diagnostic;
	@JsonProperty(value = "orcOrderControl")
	private String orcOrderControl;
	@JsonProperty(value = "placerGroupNumber")
	private String palcerGroupNumber;
	
	public String getOrcID() {
		return orcID;
	}
	public void setOrcID(String orcID) {
		this.orcID = orcID;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public String getOrcOrderControl() {
		return orcOrderControl;
	}
	public void setOrcOrderControl(String orcOrderControl) {
		this.orcOrderControl = orcOrderControl;
	}
	public String getPalcerGroupNumber() {
		return palcerGroupNumber;
	}
	public void setPalcerGroupNumber(String palcerGroupNumber) {
		this.palcerGroupNumber = palcerGroupNumber;
	}
}
