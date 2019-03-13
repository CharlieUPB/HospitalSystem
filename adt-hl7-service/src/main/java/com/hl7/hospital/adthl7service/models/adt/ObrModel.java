package com.hl7.hospital.adthl7service.models.adt;

public class ObrModel {
	private String obrID;
	private String entityIdentifier; //
	private String nameSpaceID; //Could be LAB, Farmacia
	private String diagnostic; //this is for TX used by obx
	public String getObrID() {
		return obrID;
	}
	public void setObrID(String obrID) {
		this.obrID = obrID;
	}
	public String getEntityIdentifier() {
		return entityIdentifier;
	}
	public void setEntityIdentifier(String entityIdentifier) {
		this.entityIdentifier = entityIdentifier;
	}
	public String getNameSpaceID() {
		return nameSpaceID;
	}
	public void setNameSpaceID(String nameSpaceID) {
		this.nameSpaceID = nameSpaceID;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
}
