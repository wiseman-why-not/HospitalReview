package com.skilldistillery.hospitalreview.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.hospitalreview.entities.MedicalProcedure;
import com.skilldistillery.hospitalreview.repositories.MedicalProcedureRepository;

@Service
public class MedicalProcedureServiceImpl implements MedicalProcedureService {

	// Autowire the Jpa Repository
	@Autowired
	private MedicalProcedureRepository medProRepo;
	
	@Override
	public List<MedicalProcedure> getAllMedicalProcedure() {  
		// TODO Auto-generated method stub
		return medProRepo.findAll();
	}

	@Override
	public List<String> getAllMedicalProcedureNames() {
		List<MedicalProcedure> allMedProcedures = medProRepo.findAll();
		List<String> allMedProcedureNames = new ArrayList<String>();
		for (MedicalProcedure procedureName : allMedProcedures) {
			allMedProcedureNames.add(procedureName.getProcedureName());
		}
		return allMedProcedureNames;
	}

	
}
