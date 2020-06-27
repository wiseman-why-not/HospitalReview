package com.skilldistillery.hospitalreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		@GetMapping("procedure")
		public List<MedicalProcedure> allMedicalProcedures(){
			return medSvc.getAllMedicalProcedure();
		}
		
		@GetMapping("procedureNames")
		public List<String> allMedicalProceduresNames(){
			return medSvc.getAllMedicalProcedureNames();
		}
		
}
