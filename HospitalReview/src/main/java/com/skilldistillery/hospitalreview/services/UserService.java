package com.skilldistillery.hospitalreview.services;

import java.util.List;

import com.skilldistillery.hospitalreview.entities.User;

/* ***************************************************************
 * Services are classes that hold business logic 
 * that can be utilized throughout your application. 
 * The implementation inside of a service is unimportant 
 * to the member calling upon its methods.
 * 
 * ***************************************************************
 */
public interface UserService {
	
	public User updateUser(User updatedUser);
	
	public boolean deleteUser(String username);
	
	public User findByUsername(String username);
	
	public List<User> getAllUsers();

	public User findById(Integer userId);

	public User createUser(User user);
}
