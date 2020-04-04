package com.skilldistillery.hospitalreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.hospitalreview.repositories.UserRepository;

import entities.User;


/* ***************************************************************
 * Services are classes that hold business logic 
 * that can be utilized throughout your application. 
 * The implementation inside of a service is unimportant 
 * to the member calling upon its methods.
 * 
 * ***************************************************************
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	
}
