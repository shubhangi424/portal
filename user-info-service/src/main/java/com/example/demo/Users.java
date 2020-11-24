package com.example.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="U")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String first_name;
	private String last_name;
	
	//@Temporal(TemporalType.DATE)

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at")
	private Date create_at;
	
	private int country_code;
	private String mobile_number;
	private	String email;
	private String password;
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
	
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	
	
//	public void setPasswordChangeTime1(Date passwordChangeTime) {
//		this.passwordChangeTime = passwordChangeTime;
//	}
//	
//	public boolean isPasswordExpired() {
//		if(this.passwordChangeTime==null) return false;
//		long currentTime = System.currentTimeMillis();
//		//long lastPasswordChangeTime = this.passwordChangeTime.getTime();
//		return currentTime > currentTime + PASSWORD_EXPIRATION_TIME;
//		
//	}
//	private static final long PASSWORD_EXPIRATION_TIME =30L * 24L * 60L * 60L * 1000L;

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
//	public int getRole() {
//		return role;
//	}
//	public void setRole(int role) {
//		this.role = role;
//	}
//	@ManyToMany
//	@JoinTable(name = "U_R", 
//	joinColumns=@JoinColumn(name="Role"),
//	inverseJoinColumns = @JoinColumn(name = "id"))
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
	    this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", create_at="
				+ create_at + ", country_code=" + country_code + ", mobile_number=" + mobile_number + ", email="
				+ email + ", password=" + password + ", address=" + address + ", gender=" + gender + ", profilepicture="
				+ profilepicture + ", providerId=" + providerId + ", providerName=" + providerName + ", role=" + role
				+ "]";
	}
	
}
