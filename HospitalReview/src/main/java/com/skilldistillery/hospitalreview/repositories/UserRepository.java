package com.skilldistillery.hospitalreview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.hospitalreview.entities.User;



/* 
 * Spring Data JPA in particular allows us to get some of the basic 
 * necessities for any app (CRUD functionality) without writing any 
 * implementation code.
 * 
 * JpaRepository gives us queries by using a 
 * naming convention. useful for aggregating 
 * data over the entity represented by the repository.
 */


public interface UserRepository extends JpaRepository<User, Integer> {


	User findByUsername(String username);
}
