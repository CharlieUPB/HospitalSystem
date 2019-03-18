package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObrModel {
	@JsonProperty(value = "ID")
	private String obrID;
	@JsonProperty(value = "entityIdentifier")
	private String entityIdentifier; //
	@JsonProperty(value = "nameSpaceID")
	private String nameSpaceID; //Could be LAB, Farmacia
	@JsonProperty(value = "diagnostic")
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
