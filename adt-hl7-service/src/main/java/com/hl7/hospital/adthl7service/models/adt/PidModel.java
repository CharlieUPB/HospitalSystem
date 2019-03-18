package com.hl7.hospital.adthl7service.models.adt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PidModel {
	
	//All this attributes belongs to patient
	@JsonProperty(value = "idPID")
	private String idPID;
	@JsonProperty(value = "surName")
	private String surName; //Apellido
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "birthDate")
	private String birthDate;
	@JsonProperty(value = "gender")
	private String gender;
	@JsonProperty(value = "phoneNumber")
	private String phoneNumber;
	@JsonProperty(value = "phoneBusiness")
	private String phoneBusiness;
	@JsonProperty(value = "address")
	private String address;
	@JsonProperty(value = "deathIndicator")
	private String deathIndicator;
	@JsonProperty(value = "maritalStatus")
	private String maritalStatus;
	@JsonProperty(value = "nationality")
	private String nationality;
	@JsonProperty(value = "city")
	private String city;
	
	public String getIdPID() {
		return idPID;
	}
	public void setIdPID(String idPID) {
		this.idPID = idPID;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneBusiness() {
		return phoneBusiness;
	}
	public void setPhoneBusiness(String phoneBusiness) {
		this.phoneBusiness = phoneBusiness;
	}
	public String getDeathIndicator() {
		return deathIndicator;
	}
	public void setDeathIndicator(String deathIndicator) {
		this.deathIndicator = deathIndicator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
