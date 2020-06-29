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

import com.skilldistillery.hospitalreview.entities.MedicalProcedure;
import com.skilldistillery.hospitalreview.services.MedicalProcedureService;

@RestController // implies both @Controller and @ResponseBody
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class MedicalProcedureController {

	// Autowired services
	
		@Autowired
		private MedicalProcedureService medSvc;
		
		// R E A D
		
		@GetMapping("procedures")
		public List<MedicalProcedure> getAllMedicalProcedures(){
			return medSvc.getAllMedicalProcedures();
		}
		
		@GetMapping("procedureNames")
		public List<String> allMedicalProceduresNames(){
			return medSvc.getAllMedicalProcedureNames();
		}
		
		@PostMapping("procedure")
		public MedicalProcedure addMedicalProcedure(@RequestBody MedicalProcedure medicalProcedure) {
			System.out.println("----------- Someone is trying to create a procedure : " + "-------------");
			return medSvc.createMedicalProcedure(medicalProcedure);
		}
		
		@PutMapping("procedure")
		public MedicalProcedure updateMedicalProcedure(@RequestBody MedicalProcedure medicalProcedure) {
			System.out.println("----------- Someone is trying to update a procedure : " + "-------------");
			MedicalProcedure medProcedure = medSvc.updateMedicalProcedure(medicalProcedure);
			return medProcedure;
		}
		
		@PutMapping("procedure/{medicalProcedureId}")
		public MedicalProcedure updateMedicalProcedureById(@PathVariable Integer medProcedureId, MedicalProcedure medicalProcedure) {
			System.out.println("----------- Someone is trying to update a procedure by Id : " + "-------------");
			return medSvc.updateMedicalProcedureById(medProcedureId, medicalProcedure);
		}
		
		@DeleteMapping("procedure/{medProcedureId}")
		public boolean deleteProcedureById(@PathVariable Integer medProcedureId) {
			System.out.println("----------- Someone is trying to delete a procedure : " + "-------------");
			return medSvc.deleteMedicalProcedureById(medProcedureId);
		}
}
