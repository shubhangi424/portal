package com.example.demo;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="U")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String first_name;
	private String last_name;
	private Timestamp created_at;
	private int country_code;
	private String mobile_number;
	private	String email;
	private String address;
	private String gender;
	private String profilepicture;
	private String providerId;
	private String providerName;
	private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public int getCountry_code() {
		return country_code;
	}
	public void setCountry_code(int country_code) {
		this.country_code = country_code;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfilepicture() {
		return profilepicture;
	}
	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", created_at="
				+ created_at + ", country_code=" + country_code + ", mobile_number=" + mobile_number + ", email="
				+ email + ", address=" + address + ", gender=" + gender + ", profilepicture=" + profilepicture
				+ ", providerId=" + providerId + ", providerName=" + providerName + ", role=" + role + "]";
	}
	
	
	
	

}
