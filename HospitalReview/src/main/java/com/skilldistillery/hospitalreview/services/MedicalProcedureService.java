package com.skilldistillery.hospitalreview.services;

import java.util.List;

import com.skilldistillery.hospitalreview.entities.MedicalProcedure;

public interface MedicalProcedureService {

	public List<MedicalProcedure> getAllMedicalProcedures();
	
	public List<String> getAllMedicalProcedureNames();
	
	public MedicalProcedure getMedicalProcedureById(Integer medProcedureId);

	public MedicalProcedure createMedicalProcedure(MedicalProcedure medProcedure);
	
	public MedicalProcedure updateMedicalProcedure(MedicalProcedure medProcedure);
	
	public MedicalProcedure updateMedicalProcedureById(Integer oldMedProcedureId, MedicalProcedure updatedMedProcedure);
	
	boolean deleteMedicalProcedureById(Integer medProcedureId);
}
