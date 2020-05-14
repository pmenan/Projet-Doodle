package com.istic.sir.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participant {
	
	private long id_participant;
	private String nom_participant;
	private String prenom_participant;
	private String email; 
	private String password;
	
	//liste de sondages cr��e par le participant
	@JsonIgnore
	private List<Sondage> listSondageCrees = new ArrayList<Sondage>();
	
	//liste de sondages auxqueles il participe
	@JsonIgnore
	private List<Sondage> listSondageParticipe = new ArrayList<Sondage>();
	
	public Participant() {
		// TODO Auto-generated constructor stub
	}
	
	public Participant(String nom, String prenom, String email) {
		this.nom_participant = nom;
		this.prenom_participant = prenom;
		this.email = email;
	}

	@Id
	@GeneratedValue
	public long getId_participant() {
		return id_participant;
	}

	public void setId_participant(long id_participant) {
		this.id_participant = id_participant;
	}

	public String getNom_participant() {
		return nom_participant;
	}

	public void setNom_participant(String nom_participant) {
		this.nom_participant = nom_participant;
	}

	public String getPrenom_participant() {
		return prenom_participant;
	}

	public void setPrenom_participant(String prenom_participant) {
		this.prenom_participant = prenom_participant;
	}
	
	@Column(nullable = false, unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy ="createurSondage", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
	public List<Sondage> getListSondageCrees() {
		return listSondageCrees;
	}
	
	public void setListSondageCrees(List<Sondage> listSondageCrees) {
		this.listSondageCrees = listSondageCrees;
	}
	
	@ManyToMany(mappedBy = "participant")
	public List<Sondage> getListSondageParticipe() {
		return listSondageParticipe;
	}

	public void setListSondageParticipe(List<Sondage> listSondageParticipe) {
		this.listSondageParticipe = listSondageParticipe;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
