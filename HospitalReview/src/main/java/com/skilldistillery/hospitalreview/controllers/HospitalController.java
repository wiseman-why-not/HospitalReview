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
import com.skilldistillery.hospitalreview.entities.Post;
import com.skilldistillery.hospitalreview.services.HospitalService;
import com.skilldistillery.hospitalreview.services.PostService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class HospitalController {
	
	// Autowired services
	
	@Autowired
	private HospitalService hospSvc;
	
	private PostService postSvc;

	@GetMapping("hospitals")
	public List<Hospital> allHospitals(){
		System.out.println("----------- Someone is trying to get a list of all hospitals");
		return hospSvc.getAllHospital();
	}
	
	@GetMapping("hospital/{hospitalId}")
	public Hospital getHospitalById(@PathVariable Integer hospitalId) {
		return hospSvc.findById(hospitalId);
	}
	
	@GetMapping("hospital/{hospitalId}/posts")
	public List<Post> getHospitalPosts(@PathVariable Integer hospitalId){
		return postSvc.getAllPostByHospitalId(hospitalId);
	}
	
	@GetMapping("hospital/{hospitalId}/{procedureId}")
	public List<Post> getHospitalPostsByProcedureId(@PathVariable Integer hospitalId, @PathVariable Integer procedureId){
		return postSvc.getAllPostByHospitalIdAndMedicalProcedureId(hospitalId, procedureId);
	}
	
	@GetMapping("hospital/{hospitalId}/{procedureName}")
	public List<Post> getHospitalPostsByProcedureName(@PathVariable Integer hospitalId, @PathVariable String procedureName){
		return postSvc.getAllPostByHospitalIdAndMedicalProcedureName(hospitalId, procedureName);
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
		System.out.println("----------- Someone is trying to update a hospital : " + " -------------");
		Hospital hosp = hospSvc.updateHospital(hospital);
		return hosp;
	}
	
	@PutMapping("hospital/{hospitalId}")
	public Hospital updateHospitalById(@PathVariable Integer hospitalId, @RequestBody Hospital hospital) {
		Hospital oldHospital = hospSvc.findById(hospitalId);
		System.out.println("----------- Someone is trying to update a hospital by Id : " + hospital.getName() + " -------------");
		Hospital hosp = hospSvc.updateHospitalById(hospital, oldHospital.getId());
		return hosp;
	}
	
	@DeleteMapping("hospital/{hospitalId}")
	public Boolean deleteHospital(@PathVariable Integer hospitalId) {
		System.out.println("----------- Someone is trying to delete a hospital : "+ hospitalId  + " -------------");
		return hospSvc.deleteHospital(hospitalId);
	}
}
