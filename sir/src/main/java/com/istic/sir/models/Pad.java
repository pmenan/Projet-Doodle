package com.istic.sir.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pad {
	
	private long id_pad;
	private String conpte_rendu_reunion;
	
	public Pad() {
		// TODO Auto-generated constructor stub
	}
	
	public Pad(String compte_rendu) {
		this.conpte_rendu_reunion = compte_rendu;
	}

	@Id
	@GeneratedValue
	public long getId_pad() {
		return id_pad;
	}

	public void setId_pad(long id_pad) {
		this.id_pad = id_pad;
	}

	public String getConpte_rendu_reunion() {
		return conpte_rendu_reunion;
	}

	public void setConpte_rendu_reunion(String conpte_rendu_reunion) {
		this.conpte_rendu_reunion = conpte_rendu_reunion;
	}
	
	
}
