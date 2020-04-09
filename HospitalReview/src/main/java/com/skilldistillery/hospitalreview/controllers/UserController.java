package com.skilldistillery.hospitalreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.hospitalreview.entities.User;
import com.skilldistillery.hospitalreview.services.UserService;

/* 
 * ***************************************************************
 * @ RestController -  implies both @ Controller and @ ResponseBody:
 * Controller acts on both model(Objects) and view (visualization of the data).
 *  
 * Controllers controls the data flow into model object and updates 
 * the view whenever data changes. It keeps view and model separate.
 * 
 * @ ResponseBody annotation changes the way Spring handles 
 a controller method's return value from trying to map 
 it to a generated view, to returning a JSON representation 
 of an object, or a text value representation of a primitive type.
 
 * @ RequestMapping Spring provides shortcuts for HTTP Verbs
 * ******************************************************************
*/
@RequestMapping("api")
@RestController // implies both @Controller and @ResponseBody
public class UserController {
	
	// Autowire your services
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("user")
	public List<User> allUsers(){
		System.out.println("got to list all");
		return userSvc.getAllUsers();
	}
	
	@GetMapping("user/{userId}")
	public User userById(@PathVariable Integer userId) {
		System.out.println("got to list one");
		return userSvc.findById(userId);
	}

}
