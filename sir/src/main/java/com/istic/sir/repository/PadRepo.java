package com.istic.sir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istic.sir.models.Pad;

public interface PadRepo extends JpaRepository<Pad, Long> {

}
