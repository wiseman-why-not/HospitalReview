package com.skilldistillery.hospitalreview.repositories;
/* 
 * Spring Data JPA in particular allows us to get some of the basic 
 * necessities for any app (CRUD functionality) without writing any 
 * implementation code.
 * 
 * JpaRepository gives us queries by using a 
 * naming convention. useful for aggregating 
 * data over the entity represented by the repository.
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.hospitalreview.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	// To query by properties of objects contained in an entity, 
	// use underscore (_).
	
	// SELECT * FROM Post WHERE hospital_id = (some number);
	List<Post> findByHospital_id(Integer id);
	
	// SELECT * FROM Post WHERE medicalprocedure_id = (some number);
	List<Post> findByMedicalprocedure_id(Integer id);
	
	// SELECT * FROM Post WHERE user_id = (some number);
	List<Post> findByUser_id(Integer id);
}
