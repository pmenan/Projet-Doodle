package com.istic.sir.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.istic.sir.models.Sondage;
import com.istic.sir.service.SondageService;

@RestController
@CrossOrigin
@RequestMapping("/sondages/*")
public class SondageRest {
	
	@Autowired
	private SondageService sondage_service;
	
	@GetMapping(value = " ")
	public Collection<Sondage> get_all_sondage(@PathVariable(value= "id_user") Long id_user){
		return sondage_service.getSondage();
	}

}







