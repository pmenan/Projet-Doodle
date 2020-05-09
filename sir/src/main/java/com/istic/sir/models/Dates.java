package com.istic.sir.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Dates{
	
	private Long id_date;
    Collection<Participant> participant = new ArrayList<>();
	
	@Temporal(TemporalType.DATE)
	private Date date;

	public Dates() {
		// TODO Auto-generated constructor stub
	}
	
	public Dates(Date date) {
		this.date = date;
	}

	@Id
	@GeneratedValue
	public Long getId_date() {
		return id_date;
	}

	public void setId_date(Long id_date) {
		this.id_date = id_date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToMany
    @JoinTable(name = "date_Choisies")
	public Collection<Participant> getParticipant() {
		return participant;
	}

	public void setParticipant(Collection<Participant> participant) {
		this.participant = participant;
	}
	
	

		
	
}
