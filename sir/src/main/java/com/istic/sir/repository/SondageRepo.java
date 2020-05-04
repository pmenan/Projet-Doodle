package com.istic.sir.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istic.sir.models.Sondage;

public interface SondageRepo extends JpaRepository <Sondage, Long> {
	
	Collection<Sondage> findByCreateurSondage(Long createurSondage);
}
