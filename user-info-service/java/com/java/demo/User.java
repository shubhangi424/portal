package com.java.demo;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
	private String firstname;
	private String lastname;
	private String username;	
	private	String email;
	private	String password;
	private String mobileno;
	private String otp;
	private long expirytime;

	    public User() {

	    }

	    public User(String username,String firstName, String lastName, String email,String password) {
	        super();
	        this.username=username;
	        this.firstname = firstName;
	        this.lastname = lastName;
	        this.email = email;
	        this.password=password;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMobileno() {
			return mobileno;
		}

		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}

		public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		

		public long getExpirytime() {
			return expirytime;
		}

		public void setExpirytime(long expirytime) {
			this.expirytime = expirytime;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
					+ ", email=" + email + ", password=" + password + "]";
		}

	    
	   	}