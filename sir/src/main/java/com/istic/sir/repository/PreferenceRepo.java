package com.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istic.sir.models.Preference;

public interface PreferenceRepo extends JpaRepository <Preference, Long> {

}
