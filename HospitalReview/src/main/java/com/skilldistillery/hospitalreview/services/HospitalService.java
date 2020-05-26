package com.skilldistillery.hospitalreview.services;

import java.util.List;

import com.skilldistillery.hospitalreview.entities.Hospital;

public interface HospitalService {

	public Hospital findById(Integer hospId);
	
	public Hospital findByName(String hospitalName);
	
	public Hospital createHospital(Hospital hospital);
	
	public Hospital updateHospital(Hospital updatedHospital);
	
	Hospital updateHospitalById(Hospital newHospital, int id);
	
	public Boolean deleteHospital(Integer hospitalId);
	
	public List<Hospital> getAllHospital();
	
	public List<Hospital> findByNameLike(String hospitalName);

	
	
}
