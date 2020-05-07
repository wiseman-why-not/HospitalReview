package com.skilldistillery.hospitalreview.services;

import java.util.List;

import com.skilldistillery.hospitalreview.entities.Hospital;

public interface HospitalService {

	public Hospital findById(Integer hospId);
	
	public Hospital findByUsername(String hospitalName);
	
	public Hospital createHospital(Hospital hospital);
	
	public Hospital updateHospital(Hospital updatedHospital);
	
	public Boolean deleteHospital(String hospitalName);
	
	public List<Hospital> getAllHospital();
	
}
