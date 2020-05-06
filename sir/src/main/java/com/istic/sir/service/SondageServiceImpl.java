package com.istic.sir.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istic.sir.models.Sondage;
import com.istic.sir.repository.SondageRepo;

@Service(value = "SondageService")
public class SondageServiceImpl implements SondageService {

	
	@Autowired
	SondageRepo mySondageRepo;
	
	@Override
	public Collection<Sondage> getSondage() {
		
		return mySondageRepo.findAll();
	}

}
