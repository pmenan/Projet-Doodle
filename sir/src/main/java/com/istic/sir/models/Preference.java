package com.istic.sir.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Preference {
	
	private long id_preference;
	private String allergie;
	
	public Preference() {
		// TODO Auto-generated constructor stub
	}
	
	public Preference(String allergie) {
		this.allergie = allergie;
	}

	@Id
	@GeneratedValue
	public long getId_preference() {
		return id_preference;
	}

	public void setId_preference(long id_preference) {
		this.id_preference = id_preference;
	}

	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	

}
