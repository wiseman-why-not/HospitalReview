package com.skilldistillery.hospitalreview.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.hospitalreview.entities.Hospital;
import com.skilldistillery.hospitalreview.repositories.HospitalRepository;

/* ***************************************************************
 * Services are classes that hold business logic 
 * that can be utilized throughout your application. 
 * The implementation inside of a service is unimportant 
 * to the member calling upon its methods.
 * 
 * ***************************************************************
 */

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository hRepo;

	@Override
	public Hospital findById(Integer hospId) {
		return hRepo.findById(hospId).get();
		
	}

	@Override
	public Hospital findByName(String hospitalName) {
		Hospital hospital = hRepo.findByName(hospitalName);
		return hospital;
	}
	
	@Override
	public List<Hospital> getAllHospital() {
		return hRepo.findAll();
	}

	@Override
	public List<Hospital> findByNameLike(String hospitalName) {
		// TODO Auto-generated method stub
		return hRepo.findByNameContaining(hospitalName);
	}
	

	@Override
	public Hospital createHospital(Hospital hospital) {
		Hospital newHospital = hRepo.saveAndFlush(hospital);
		return newHospital;
	}
	
	@Override
	public Hospital updateHospitalById(Hospital newHospital, int id) {
		Optional<Hospital> managedHospital = hRepo.findById(id);
		if (managedHospital.isPresent() ) {
			Hospital oldHospital = managedHospital.get();
			
			if (newHospital.getName() != null) {
				oldHospital.setName(newHospital.getName());
			}
			if (newHospital.getStreet() != null) {
				oldHospital.setStreet(newHospital.getStreet());
			}
			if (newHospital.getCity() != null) {
				oldHospital.setCity(newHospital.getCity());
			}
			if (newHospital.getState() != null) {
				oldHospital.setState(newHospital.getState());
			}
			if (newHospital.getName() != null) {
				oldHospital.setName(newHospital.getName());
			}
			if (newHospital.getZipCode() != null) {
				oldHospital.setZipCode(newHospital.getZipCode());
			}
			newHospital = hRepo.saveAndFlush(oldHospital);
			return newHospital;
		} else {
			throw new RuntimeException("Hospital Not Found");
		}
	}

	@Override
	public Hospital updateHospital(Hospital updatedHospital) {
		
		Hospital oldHospital = hRepo.findById(updatedHospital.getId()).get();
		

		if (updatedHospital.getName() != null) {
			oldHospital.setName(updatedHospital.getName());
		}
		if (updatedHospital.getStreet() != null) {
			oldHospital.setStreet(updatedHospital.getStreet());
		}
		if (updatedHospital.getCity() != null) {
			oldHospital.setCity(updatedHospital.getCity());
		}
		if (updatedHospital.getState() != null) {
			oldHospital.setState(updatedHospital.getState());
		}
		if (updatedHospital.getZipCode() != null) {
			oldHospital.setZipCode(updatedHospital.getZipCode());
		}
		
		hRepo.saveAndFlush(oldHospital);
		return oldHospital;
	}

	@Override
	public Boolean deleteHospital(Integer hospitalId) {
		Hospital deletedHospital = hRepo.findById(hospitalId).get();
		try {
			hRepo.delete(deletedHospital);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	

	

}
