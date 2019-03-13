package com.hl7.hospital.adthl7service.models.adt;

public class PidModel {
	
	//All this attributes belongs to patient
	
	private String idPID;
	private String surName; //Apellido
	private String name;
	private String birthDate;
	private String gender;
	private String phoneNumber;
	private String phoneBusiness;
	private String address;
	private String deathIndicator;
	private String maritalStatus;
	private String nationality;
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
