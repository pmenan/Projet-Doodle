package com.istic.sir.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Dates{
	
	private long id_date;
	
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
	public long getId_date() {
		return id_date;
	}

	public void setId_date(long id_date) {
		this.id_date = id_date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

		
	
}
