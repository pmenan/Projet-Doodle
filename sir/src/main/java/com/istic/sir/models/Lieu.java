package com.istic.sir.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Lieu {
	
	private Long id_lieu;
	private String lieu;
    private Collection<Participant> participant = new ArrayList<>();
	
	public Lieu() {
		// TODO Auto-generated constructor stub
	}
	
	public Lieu(String lieu) {
		this.lieu = lieu;
	}

	@Id
	@GeneratedValue
	public Long getId_lieu() {
		return id_lieu;
	}

	public void setId_lieu(Long id_lieu) {
		this.id_lieu = id_lieu;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	@ManyToMany
    @JoinTable(name = "Lieu_Choisis")
	public Collection<Participant> getParticipant() {
		return participant;
	}

	public void setParticipant(Collection<Participant> participant) {
		this.participant = participant;
	}
	
	

	
}
