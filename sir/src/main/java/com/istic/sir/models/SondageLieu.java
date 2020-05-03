package com.istic.sir.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class SondageLieu extends Sondage {
	
	private List<Lieu> listeLieu = new ArrayList<Lieu>();
	private Lieu lieuChoisi;
	
	public SondageLieu() {
		super();
	}
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	public List<Lieu> getListeLieu() {
		return listeLieu;
	}

	public void setListeLieu(List<Lieu> listeLieu) {
		this.listeLieu = listeLieu;
	}
	
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	public Lieu getLieuchoisi() {
		return lieuChoisi;
	}

	public void setLieuchoisi(Lieu lieuchoisi) {
		this.lieuChoisi = lieuchoisi;
	}
	
	
	

}
