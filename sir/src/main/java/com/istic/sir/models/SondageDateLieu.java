package com.istic.sir.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class SondageDateLieu extends Sondage {
	
	 private List<Dates> listeDate = new ArrayList<Dates>();
	 private List<Lieu> listeLieu = new ArrayList<Lieu>();
	 private Lieu lieuChoisi;
	 private Dates dateChoisie;

	 public SondageDateLieu() {
		 super();
	 }
	 
	 @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	public List<Dates> getListeDate() {
		return listeDate;
	}

	public void setListeDate(List<Dates> listeDate) {
		this.listeDate = listeDate;
	}
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	public List<Lieu> getListeLieu() {
		return listeLieu;
	}

	public void setListeLieu(List<Lieu> listeLieu) {
		this.listeLieu = listeLieu;
	}
	
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	public Lieu getLieuChoisi() {
		return lieuChoisi;
	}

	public void setLieuChoisi(Lieu lieuChoisi) {
		this.lieuChoisi = lieuChoisi;
	}
	
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	public Dates getDateChoisie() {
		return dateChoisie;
	}

	public void setDateChoisie(Dates dateChoisie) {
		this.dateChoisie = dateChoisie;
	}
	
	
	 
}
