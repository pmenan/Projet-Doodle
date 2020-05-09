package com.istic.sir.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.istic.sir.models.Participant;
import com.istic.sir.models.Sondage;
import com.istic.sir.service.ParticipantService;

@RestController
@CrossOrigin
@RequestMapping("/users/*")
public class ParticipantRest {
	
	@Autowired
	ParticipantService user_service;
	
	
	/**Action Users**/
	
	@GetMapping(value = "")
	public Participant connect(@RequestBody Participant user) {
		return user_service.login(user);
	}
	
	@PostMapping(value = "")
	public Participant createUser(@RequestBody Participant user) {
		return user_service.createUser(user);
	}
	
	@GetMapping(value = "{id_user}/sondages")
	public Collection<Sondage> getUserSondages(@PathVariable(value = "id_user" ) Long id_user){
		return user_service.getUserSondages(id_user);
	}
	
	
	//les Sondages
	
	@PostMapping(value = "{id_user}/sondages")
	public Sondage createSondage(@PathVariable(value = "id_user") Long id_user, @RequestBody Sondage sondage) {
		return user_service.createSondage(id_user, sondage);
	}
	
	@GetMapping(value = "{id_user}/sondages/{id_sondage}")
	public Sondage getAllInfoSondage(@PathVariable(value = "id_user") Long id_sondage, @RequestBody Participant user) {
		return user_service.getSondageById(id_sondage);
	}
	
	 
	 @PostMapping(value = "/{id_user}/sondages/{id_sondage/validate")
	 public Sondage validataion_sondage(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage) {
		 return user_service.valider_sondage(id_user, id_sondage);
	 }

}
