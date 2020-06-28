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
	public List<MedicalProcedure> getAllMedicalProcedures() {  
		// TODO Auto-generated method stub
		return medProRepo.findAll();
	}
	
	@Override
	public MedicalProcedure getMedicalProcedureById(Integer medProcedureId) {
		return medProRepo.findById(medProcedureId).get();
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
	
	// C R E A T E
	@Override
	public MedicalProcedure createMedicalProcedure(MedicalProcedure medProcedure) {
		// will attempt to find an id, and will auto-gen one
		// when none is found. Done by JPA Repository.
		MedicalProcedure newProcedure = medProRepo.saveAndFlush(medProcedure);
		return newProcedure;
		
	}

	@Override
	public MedicalProcedure updateMedicalProcedure(MedicalProcedure medProcedure) {
		MedicalProcedure oldProcedure = medProRepo.findById(medProcedure.getId()).get();
		
		if (medProcedure.getProcedureName() != null) {
			oldProcedure.setProcedureName(medProcedure.getProcedureName());
		}
		if (medProcedure.getDescription() != null) {
			oldProcedure.setDescription(medProcedure.getDescription());
		}
		
		if (medProcedure.getCost() != null) {
			oldProcedure.setCost(medProcedure.getCost());
		}
		
		if (medProcedure.getPost() != null) {
			oldProcedure.setPost(medProcedure.getPost());
		}
		
		// save and returns the medical procedure in the database
		medProRepo.saveAndFlush(oldProcedure);
		return oldProcedure;
	}

	@Override
	public MedicalProcedure updateMedicalProcedureById(Integer oldMedProcedureId, MedicalProcedure updatedMedProcedure) {
MedicalProcedure oldProcedure = medProRepo.findById(oldMedProcedureId).get();
		
		if (updatedMedProcedure.getProcedureName() != null) {
			oldProcedure.setProcedureName(updatedMedProcedure.getProcedureName());
		}
		if (updatedMedProcedure.getDescription() != null) {
			oldProcedure.setDescription(updatedMedProcedure.getDescription());
		}
		
		if (updatedMedProcedure.getCost() != null) {
			oldProcedure.setCost(updatedMedProcedure.getCost());
		}
		
		if (updatedMedProcedure.getPost() != null) {
			oldProcedure.setPost(updatedMedProcedure.getPost());
		}
		
		// save and returns the medical procedure in the database
		medProRepo.saveAndFlush(oldProcedure);
		return oldProcedure;
	}

	@Override
	public boolean deleteMedicalProcedureById(Integer medProcedureId) {
		MedicalProcedure medProcedure = medProRepo.findById(medProcedureId).get();
		
		try {
			medProRepo.delete(medProcedure);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	

	
}
