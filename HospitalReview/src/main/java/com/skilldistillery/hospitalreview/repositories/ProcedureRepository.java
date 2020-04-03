package com.skilldistillery.hospitalreview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {

}
