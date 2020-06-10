package com.skilldistillery.hospitalreview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.hospitalreview.entities.MedicalProcedure;

public interface ProcedureRepository extends JpaRepository<MedicalProcedure, Integer> {

}
