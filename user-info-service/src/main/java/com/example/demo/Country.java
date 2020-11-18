package com.example.demo;

import javax.persistence.*;
@Entity
@Table(name="C")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Country_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry_name() {
		return Country_name;
	}
	public void setCountry_name(String country_name) {
		Country_name = country_name;
	}
	

}
