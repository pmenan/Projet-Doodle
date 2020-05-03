package com.istic.sir.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Sondage {
	
	private long id_sondage;
	private String libelle_sondage;
	private String description_sondage;
	private boolean pause;
	private boolean valide;
	private Pad pad;
	private List<Participant> participant = new ArrayList<Participant>();
	private Participant createurSondage;
	
	
	public Sondage() {
		// TODO Auto-generated constructor stub
	}
	
	public Sondage(String libelle, String description) {
		this.libelle_sondage = libelle;
		this.description_sondage = description;
		this.pause = false;
	}

	@Id
	@GeneratedValue
	public long getId_sondage() {
		return id_sondage;
	}

	public void setId_sondage(long id_sondage) {
		this.id_sondage = id_sondage;
	}

	public String getLibelle_sondage() {
		return libelle_sondage;
	}

	public void setLibelle_sondage(String libelle_sondage) {
		this.libelle_sondage = libelle_sondage;
	}

	public String getDescription_sondage() {
		return description_sondage;
	}

	public void setDescription_sondage(String description_sondage) {
		this.description_sondage = description_sondage;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	@OneToOne
	public Pad getPad() {
		return pad;
	}

	public void setPad(Pad pad) {
		this.pad = pad;
	}
	

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}
	
	@ManyToMany
	@JoinTable(name = "participationSondage", 
	joinColumns = @JoinColumn(name =" id_sondage"), 
	inverseJoinColumns = @JoinColumn(name = "email")
	)
	public List<Participant> getParticipant() {
		return participant;
	}

	public void setParticipant(List<Participant> participant) {
		this.participant = participant;
	}
	
	@ManyToOne
	public Participant getCreateurSondage() {
		return createurSondage;
	}

	public void setCreateurSondage(Participant createurSondage) {
		this.createurSondage = createurSondage;
	}
	
	
		

}
