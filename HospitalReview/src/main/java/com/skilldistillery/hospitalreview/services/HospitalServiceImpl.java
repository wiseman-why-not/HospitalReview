package com.skilldistillery.hospitalreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.hospitalreview.entities.Hospital;
import com.skilldistillery.hospitalreview.repositories.HospitalRepository;

public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository hRepo;

	@Override
	public Hospital findById(Integer hospId) {
		return hRepo.findById(hospId).get();
		
	}

	@Override
	public Hospital findByUsername(String hospitalName) {
		Hospital hospital = hRepo.findByName(hospitalName);
		return hospital;
	}

	@Override
	public Hospital createHospital(Hospital hospital) {
		Hospital newHospital = hRepo.saveAndFlush(hospital);
		return newHospital;
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
		
		return null;
	}

	@Override
	public Boolean deleteHospital(String hospitalName) {
		Hospital deletedHospital = hRepo.findByName(hospitalName);
		try {
			hRepo.delete(deletedHospital);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Hospital> getAllHospital() {
		return hRepo.findAll();
	}

}
