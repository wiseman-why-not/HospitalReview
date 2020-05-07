package com.skilldistillery.hospitalreview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.hospitalreview.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	
	Hospital findByName(String hospitalName);
}
