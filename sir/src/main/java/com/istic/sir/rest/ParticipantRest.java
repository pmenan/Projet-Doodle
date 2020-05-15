package com.istic.sir.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.istic.sir.models.Dates;
import com.istic.sir.models.Lieu;
import com.istic.sir.models.Participant;
import com.istic.sir.models.Preference;
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
	public Participant Connect(@RequestBody Participant user) {
		return user_service.login(user);
	}
	
	@PostMapping(value = "/")
	public Participant createUser(@RequestBody Participant user) {
		return user_service.createUser(user);
	}
	
	@GetMapping(value = "{id_user}/sondages")
	public Collection<Sondage> getUserSondages(@PathVariable(value = "id_user" ) Long id_user){
		return user_service.getUserSondages(id_user);
	}
	
	
	//Sondages
	
	@PostMapping(value = "{id_user}/sondages")
	public Sondage createSondage(@PathVariable(value = "id_user") Long id_user, @RequestBody Sondage sondage) {
		return user_service.createSondage(id_user, sondage);
	}
	
	@GetMapping(value = "sondages/{id_sondage}")
	public Sondage getAllInfoSondage(@PathVariable(value = "id_sondage") Long id_sondage) {
		return user_service.getSondageById(id_sondage);
	}
	
	 //urls
	
	@PostMapping(value = "/{id_user}/sondages/{id_sondage}/validate")
	 public Sondage valider_sondage(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage) {
		 return user_service.valider_sondage(id_user, id_sondage);
	 }
	 
	@PostMapping(value = "/{id_user}/sondages/{id_sondage}/dates/{id_date}")
	    public Dates addDateSondage(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage,  @PathVariable(value = "id_date") Long id_date) {
	        return user_service.addDateSondage(id_user, id_sondage, id_date);
	    }

	@PutMapping(value = "/{id_user}/sondages/{id_sondage}/dates/{id_date}")
	    public Dates selectOrDeselectDateSondage(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage, @PathVariable(value = "id_date") Long id_date, @RequestParam("chose") boolean chose) {
	        return user_service.choseDateSodage(id_user, id_sondage, id_date, chose);
	    }

	@DeleteMapping(value = "/{id_user}/sondages/{id_sondage}/dates/{id_date}")
	    public void deleteDateSondage(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage, @PathVariable(value = "id_date") Long id_date) {
	         user_service.deleteDate(id_user, id_sondage, id_date);
	    }
	
	@PostMapping(value = "/{id_user}/sondages/{id_sondage}/lieux/{id_lieu}")
    public Lieu addLieuSondages(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage, @PathVariable(value = "id_lieu") Long id_lieu) {
        return user_service.addLieuSondage(id_user, id_sondage, id_lieu);
    }


    @PutMapping(value = "/{id_user}/sondages/{id_sondage}/lieux/{id_lieu}")
    public Lieu selectOrdelesectLieuSondage(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage, @PathVariable(value = "id_lieu") Long id_lieu, @RequestParam("chose") boolean chose ) {
        return user_service.choseLieuSondage(id_user, id_sondage, id_lieu, chose);
    }

    @DeleteMapping(value = "/{id_user}/sondages/{id_sondage}/lieux/{id_lieu}")
    public void deleteLieu(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage, @PathVariable(value = "id_lieu") Long id_lieu){
        user_service.deleteLieu(id_user, id_sondage, id_lieu);
    }
    
    
    @PostMapping(value = "/{id_user}/sondages/{id_sondage}/preferences/{id_preference}")
    public Preference addPreferenceSondage(@PathVariable(value = "id_user") Long id_user, @PathVariable(value = "id_sondage") Long id_sondage, @PathVariable(value = "id_preference") Long id_preference) {
        return user_service.addPreSondage(id_user, id_sondage, id_preference);
    }
	 

    @PostMapping(value = "/createLieu")
	public Lieu createLieu(@RequestBody Lieu lieu) {
		return user_service.createLieu(lieu);
	}
    
    @PostMapping(value = "/createDate")
	public Dates createDate(@RequestBody Dates date) {
		return user_service.createDate(date);
	}
    
    @PostMapping(value = "/createPreference")
	public Preference createPreference(@RequestBody Preference preference) {
		return user_service.createPreference(preference);
	}
}
