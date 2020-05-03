package com.istic.sir.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lieu {
	
	private long id_lieu;
	private String lieu;
	
	public Lieu() {
		// TODO Auto-generated constructor stub
	}
	
	public Lieu(String lieu) {
		this.lieu = lieu;
	}

	@Id
	@GeneratedValue
	public long getId_lieu() {
		return id_lieu;
	}

	public void setId_lieu(long id_lieu) {
		this.id_lieu = id_lieu;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	
}
