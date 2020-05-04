package com.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istic.sir.models.Dates;

public interface DatesRepo extends JpaRepository <Dates, Long> {

}
