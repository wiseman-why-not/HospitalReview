package com.skilldistillery.hospitalreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.hospitalreview.entities.Hospital;
import com.skilldistillery.hospitalreview.services.HospitalService;

@RequestMapping("api")
@RestController
@CrossOrigin({"*", "http://localhost:4200"})
public class HospitalController {
	
	// Autowired services
	
	@Autowired
	private HospitalService hospSvc;

	@GetMapping("hospitals")
	public List<Hospital> allHospitals(){
		System.out.println("----------- Someone is trying to get a list of all hospitals");
		return hospSvc.getAllHospital();
	}
	
	@GetMapping("hospital/{hospitalId}")
	public Hospital getHospitalById(@PathVariable Integer hospitalId) {
		return hospSvc.findById(hospitalId);
	}
	
	@GetMapping("hospital/search/{keyword}")
	public List<Hospital> getHospitalByKeyword(@PathVariable String keyword){
		System.out.println("----------- Someone is trying to get a list of hospitals that have : " + keyword + "-------------");
		return hospSvc.findByNameLike(keyword);
	}
	
	@PostMapping("hospital")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		System.out.println("----------- Someone is trying to create hospital : " + "-------------");
		return hospSvc.createHospital(hospital);
	}
	
	@PutMapping("hospital")
	public Hospital updateHospital(@RequestBody Hospital hospital) {
		Hospital hosp = hospSvc.updateHospital(hospital);
		return hosp;
	}
	
	@DeleteMapping("hospital/{hospitalId}")
	public Boolean deleteHospital(@PathVariable Integer hospitalId) {
		return hospSvc.deleteHospital(hospitalId);
	}
}
