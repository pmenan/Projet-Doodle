package com.istic.sir.service;

import java.util.Collection;

import com.istic.sir.models.Dates;
import com.istic.sir.models.Lieu;
import com.istic.sir.models.Participant;
import com.istic.sir.models.Preference;
import com.istic.sir.models.Sondage;

public interface ParticipantService {

	Participant login(Participant participant);
	
	Sondage createSondage(Long id_user, Sondage sondage);
	
	Participant createUser(Participant user);
	
	Collection<Sondage> getUserSondages(Long id_user);
	
	Sondage getSondageById(Long id_sondage);
	
	Lieu addLieuSondage(Long id_user, Long id_sondage, Lieu lieu);
	
	Dates addDateSondage(Long id_user, Long id_sondage, Dates date);
	
	Sondage valider_sondage(Long id_user, Long id_sondage);
	
	Dates choseDateSodage(Long id_user, Long id_sondage, Long id_date, boolean chose);
	
	Lieu choseLieuSondage(Long id_user, Long id_sondage, Long id_lieu, boolean chose);
	
	void deleteSondage(Long id_user, Long id_sondage);
	
	void deleteDate(Long id_user, Long id_sondage, Long id_date);
	
	void deleteLieu(Long id_user, Long id_sondage, Long id_lieu);
	
	Preference addPreSondage(Long id_user, Long id_sondage, Preference preference);
	
	
	
}
