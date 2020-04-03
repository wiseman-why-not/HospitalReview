package com.skilldistillery.hospitalreview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
