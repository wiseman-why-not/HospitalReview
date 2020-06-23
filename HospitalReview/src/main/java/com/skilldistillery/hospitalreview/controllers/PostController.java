package com.skilldistillery.hospitalreview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.hospitalreview.services.PostService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class PostController {
	
	// post controller created but not needed for current iteration of application.

	// Autowired Services
	@Autowired
	private PostService postSvc;
	
	
}
