package com.istic.sir.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.istic.sir.models.Dates;
import com.istic.sir.models.Lieu;
import com.istic.sir.models.Participant;
import com.istic.sir.models.Preference;
import com.istic.sir.models.Sondage;
import com.istic.sir.models.SondageDate;
import com.istic.sir.models.SondageLieu;
import com.istic.sir.repository.DatesRepo;
import com.istic.sir.repository.LieuRepo;
import com.istic.sir.repository.ParticipantRepo;
import com.istic.sir.repository.PreferenceRepo;
import com.istic.sir.repository.SondageRepo;

@Service(value = "ParticipantService")
@Transactional(readOnly = true)
@CrossOrigin
public class ParticipantServiceImpl implements ParticipantService {

	
	
	@Autowired
	SondageRepo sondageRepo;
	
	@Autowired
	JavaMailSender javaMailSender;
	
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
		
		return participantRepo.findByEmailAndPassword(participant.getEmail(), participant.getPassword());
	}

	@Override
	@Transactional
	public Sondage createSondage(Long id_user, Sondage sondage) {
		
		Participant user = participantRepo.findById(id_user).get();
		sondage.setCreateurSondage(user);
		sondage.getParticipant().add(user);
		String code = String.valueOf(ThreadLocalRandom.current().nextInt());
		sondage.setCode(code);
		participantRepo.save(user);
		
		return sondageRepo.save(sondage); 
	}

	@Override
	@Transactional
	public Participant createUser(Participant user) {
		
		return participantRepo.save(user);
	}

	@Override
	@Transactional
	public Lieu createLieu(Lieu lieu) {
		
		return lieuRepo.save(lieu);
	}
	
	@Override
	@Transactional
	public Dates createDate(Dates date) {
		
		return datesRepo.save(date);
	}
	
	
	@Override
	@Transactional
	public Preference createPreference(Preference preference) {
		
		return preferenceRepo.save(preference);
	}
	
	
	@Override
	public Collection<Sondage> getUserSondages(Long id_user) {
		
		Participant user =  participantRepo.findById(id_user).get();
		Collection<Sondage> sondage = new ArrayList<>();
		sondage.addAll(user.getListSondageParticipe());
		sondage.addAll(user.getListSondageCrees());
		
		return sondage;
	}

	@Override
	public Sondage getSondageById(Long id_sondage) {
		
		return sondageRepo.findById(id_sondage).get();
	}

	@Transactional
	@Override
	public Lieu addLieuSondage(Long id_user, Long id_sondage, Long id_lieu) {
		Lieu lieu = new Lieu();
		SondageLieu sondage = (SondageLieu) getSondageById(id_sondage);
		lieu = lieuRepo.getOne(id_lieu);
		sondage.getListeLieu().add(lieu);
		
		return lieu;
	}
	
	@Transactional
	@Override
	public Dates addDateSondage(Long id_user, Long id_sondage, Long id_date) {
		Dates date = new Dates();
		SondageDate sondage = (SondageDate) getSondageById(id_sondage);
		date = datesRepo.getOne(id_date);
		sondage.getListeDate().add(date);
		
		return date;
	}
	
	@Transactional
	@Override
	public Dates choseDateSodage(Long id_user, Long id_sondage, Long id_date, boolean chose) {
		Dates date_sondage = new Dates();
		SondageDate sondage = (SondageDate) sondageRepo.findById(id_sondage).get();
		Participant user = participantRepo.findById(id_user).get();
		Collection<Dates> list_dates = sondage.getListeDate();
		
		for(Dates date : list_dates ) {
			if(date.getId_date().equals(id_date)) {
				date_sondage = date;
				if(chose)
					date.getParticipant().add(user);
				else
					date.getParticipant().remove(user);
				
			}
		}
		
		return date_sondage;
	}
	
	
	@Transactional
	@Override
	public Lieu choseLieuSondage(Long id_user, Long id_sondage, Long id_lieu, boolean chose) {
		
		Lieu lieu_sondage = new Lieu();
		SondageLieu sondage = (SondageLieu) sondageRepo.findById(id_sondage).get();
		Participant user = participantRepo.findById(id_user).get();
		Collection<Lieu> list_lieu = sondage.getListeLieu();
		
		for(Lieu lieu : list_lieu ) {
			if(lieu.getId_lieu().equals(id_lieu)) {
				lieu_sondage = lieu;
				if(chose)
					lieu.getParticipant().add(user);
				else
					lieu.getParticipant().remove(user);
				
			}
		}
		
		return lieu_sondage;
	}

	@Transactional
	@Override
	public void deleteSondage(Long id_user, Long id_sondage) {
		
		sondageRepo.deleteById(id_sondage);
		
	}
	
	@Transactional
	@Override
	public void deleteDate(Long id_user, Long id_sondage, Long id_date) {
		
		datesRepo.deleteById(id_date);
		
	}
	
	@Transactional
	@Override
	public void deleteLieu(Long id_user, Long id_sondage, Long id_lieu) {
		
		lieuRepo.deleteById(id_lieu);
		
	}
	
	@Transactional
	@Override
	public Preference addPreSondage(Long id_user, Long id_sondage, Long id_preference) {
		Preference preference = new Preference();
		Sondage sondage = getSondageById(id_sondage);
		preference = preferenceRepo.getOne(id_preference);
		sondage.getPreferences().add(preference);
		return preference;	
	}

	@Transactional
	@Override
	public Sondage valider_sondage(Long id_user, Long id_sondage) {
		Sondage sondage = getSondageById(id_sondage);
		sondage.setValide(true);
		
		SimpleMailMessage msg = new SimpleMailMessage();
		for(Participant user : sondage.getParticipant()) {
			
			msg.setTo(user.getEmail());
			msg.setSubject(sondage.getLibelle_sondage());
			msg.setText("votre code d'accès à la reunion : " +sondage.getCode());
		}
		
		return sondage;
		
		}
		
	}



