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

@RestController // implies both @Controller and @ResponseBody
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class UserController {
	
	// Autowire your services
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("users")
	public List<User> allUsers(){
		System.out.println("----------- Someone is trying to get all User : " + "-------------");
		return userSvc.getAllUsers();
	}
	
	@GetMapping("user/{userId}")
	public User userById(@PathVariable Integer userId) {
		System.out.println("----------- Someone is trying to get a User : " + "-------------");
		return userSvc.findById(userId);
	}
	
	@GetMapping("user/search/{keyword}")
	public List<User> getUsersByKeyword(@PathVariable String keyword) {
		System.out.println("----------- Someone is trying to get Users that match with : " + keyword + "-------------");
		return userSvc.findByUsersByKeyword(keyword);
	}
	
	@PostMapping("user")
	public User addUser(@RequestBody User user) {
		System.out.println("----------- Someone is trying to create a User : " + "-------------");
		User newUser = userSvc.createUser(user);
		return newUser;
	}
	
	@PutMapping("user")
	public User updateUser(@RequestBody User user) {
		System.out.println("----------- Someone is trying to update a User : " + "-------------");
		user = userSvc.updateUser(user);
		return user;
	}
	
	// update user by Id
	
//	@PutMapping("user/{userId}")
//	public User updateUserById(@PathVariable Integer userId, @RequestBody User user) {
//		System.out.println("----------- Someone is trying to update  User : " + userId + " -------------");
//		
//	}
	
	@DeleteMapping("user")
	public Boolean deleteUser(@RequestBody User user) {
		System.out.println("----------- Someone is trying to delete a User : " + "-------------");
		return userSvc.deleteUser(user.getUsername());
	}

	
	@DeleteMapping("user/{userId}")
	public Boolean deleteUserById(@PathVariable Integer userId) {
		System.out.println("----------- Someone is trying to delete a User by Id : " + "-------------");
		return userSvc.deleteUserbyId(userId);
	}
	
	
	

}
