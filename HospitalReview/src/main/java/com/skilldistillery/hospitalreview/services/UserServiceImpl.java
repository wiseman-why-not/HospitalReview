package com.skilldistillery.hospitalreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.hospitalreview.entities.User;
import com.skilldistillery.hospitalreview.repositories.UserRepository;


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
	
	
	// C R E A T E
	public User createUser(User user) {
		// will attempt to find an id, and will auto-gen one
		// when none is found. Done by JPA Repository
		User newUser = userRepo.findById(user.getId() ).get();
		
		userRepo.saveAndFlush(newUser);
		return newUser;
	}
	
	// R E A D
	@Override
	public User findByUsername(String username) {
		User user = userRepo.findByUsername(username);
		return user;
	}
	
	@Override
	public User findById(Integer userId) {
		return userRepo.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	// U P D A T E 
	@Override
	public User updateUser(User updatedUser) {
		User oldUser = userRepo.findByUsername(updatedUser.getUsername() );
		
		if (updatedUser.getGender() != null) {
			oldUser.setGender(updatedUser.getGender());
		}
		
		// saves and returns the user in the database.
		userRepo.saveAndFlush(oldUser);
		return oldUser;
	}

	// D E L E T E
	@Override
	public boolean deleteUser(String username) {
		User user = userRepo.findByUsername(username);
		 
		try {
			userRepo.delete(user);
			return true;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	
}
