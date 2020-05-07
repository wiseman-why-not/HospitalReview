package com.skilldistillery.hospitalreview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.hospitalreview.services.HospitalService;

@RequestMapping("api")
@RestController
public class HospitalController {
	
	// Autowired services
	
	@Autowired
	private HospitalService hospSvc;

}
