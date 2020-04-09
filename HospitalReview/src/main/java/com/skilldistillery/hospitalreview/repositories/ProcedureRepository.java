package com.skilldistillery.hospitalreview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.hospitalreview.entities.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {

}
