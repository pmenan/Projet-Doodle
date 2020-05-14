package com.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istic.sir.models.Participant;

public interface ParticipantRepo extends JpaRepository <Participant, Long>{
	
	Participant findByEmailAndPassword(String email, String password);

}



