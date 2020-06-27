package com.skilldistillery.hospitalreview.services;

import java.util.List;

import com.skilldistillery.hospitalreview.entities.MedicalProcedure;

public interface MedicalProcedureService {

	public List<MedicalProcedure> getAllMedicalProcedure();
	
	public List<String> getAllMedicalProcedureNames();
}
