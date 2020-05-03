package com.istic.sir.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SondageDate extends Sondage {
	
	private List<Dates> listeDate = new ArrayList<Dates>();
	private Dates dateChoisie;
	
	public SondageDate() {
		super();
	}

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	public List<Dates> getListeDate() {
		return listeDate;
	}

	public void setListeDate(List<Dates> listeDate) {
		this.listeDate = listeDate;
	}

	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	public Dates getDatechoisie() {
		return dateChoisie;
	}

	public void setDatechoisie(Dates datechoisie) {
		this.dateChoisie = datechoisie;
	}
	
	
	
	
}
