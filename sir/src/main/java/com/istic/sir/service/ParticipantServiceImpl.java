package com.istic.sir.service;

import java.nio.charset.Charset;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.istic.sir.models.Dates;
import com.istic.sir.models.Lieu;
import com.istic.sir.models.Participant;
import com.istic.sir.models.Preference;
import com.istic.sir.models.Sondage;
import com.istic.sir.repository.DatesRepo;
import com.istic.sir.repository.LieuRepo;
import com.istic.sir.repository.ParticipantRepo;
import com.istic.sir.repository.PreferenceRepo;
import com.istic.sir.repository.SondageRepo;

public class ParticipantServiceImpl implements ParticipantService {

	/*@Autowired
	JavaMailSender javaMailSender;*/
	
	@Autowired
	SondageRepo sondageRepo;
	
	@Autowired
	DatesRepo datesRepo;
	
	@Autowired
	LieuRepo lieuRepo;
	
	@Autowired
	PreferenceRepo preferenceRepo;
	
	@Autowired
	ParticipantRepo participantRepo;
	
	
	@Override
	public Participant login(Participant participant) {
		
		return participantRepo.findByEmail(participant.getEmail_participant());
	}

	@Override
	@Transactional
	public Sondage createSondage(Long id_user, Sondage sondage) {
		Participant user = participantRepo.findById(id_user).get();
		sondage.setCreateurSondage(user);
		sondage.getParticipant().add(user);
		
		participantRepo.save(user);
		
		return sondageRepo.save(sondage); 
	}

	@Override
	public Participant createUser(Participant user) {
		
		return participantRepo.save(user);
	}

	@Override
	public Collection<Sondage> getUserSondages(Long id_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sondage getSondageById(Long id_sondage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lieu addLieuSondage(Long id_user, Long idSondage, Lieu lieu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dates addDateSondage(Long id_user, Long idSondage, Dates date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dates choseDateSodage(Long id_user, Long id_sondage, Long id_date, boolean chose) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lieu choseLieuSondage(Long id_user, Long id_sondage, Long id_lieu, boolean chose) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSondage(Long id_user, Long id_sondage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDate(Long id_user, Long id_sondage, Dates id_date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLieu(Long id_user, Long id_sondage, Lieu id_lieu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Preference addPreSondage(Long id_user, Long id_sondage, Preference preference) {
		// TODO Auto-generated method stub
		return null;
	}

}
