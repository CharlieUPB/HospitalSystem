package com.hl7.hospital.adthl7service.models.adt;

public class OrcModel {
	private String orcID;
	private String diagnostic;
	private String orcOrderControl;
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
