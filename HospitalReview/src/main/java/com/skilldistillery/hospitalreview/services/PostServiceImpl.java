package com.skilldistillery.hospitalreview.services;

/* ***************************************************************
 * Services are classes that hold business logic 
 * that can be utilized throughout your application. 
 * The implementation inside of a service is unimportant 
 * to the member calling upon its methods.
 * 
 * ***************************************************************
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.hospitalreview.entities.Hospital;
import com.skilldistillery.hospitalreview.entities.Post;
import com.skilldistillery.hospitalreview.entities.User;
import com.skilldistillery.hospitalreview.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	// Autowire the repositories
	@Autowired
	private PostRepository postRepo;
	
	
	// R E A D
	
	@Override
	public List<Post> getAllPost() {
		return postRepo.findAll();
	}
	
	@Override
	public Post getPostById(Integer postId) {
		return postRepo.findById(postId).get();
	}

	@Override
	public List<Post> getAllPostByHospitalId(Integer hospitalId) {
		return postRepo.findByHospital_Id(hospitalId);
	}

	@Override
	public List<Post> getAllPostByUserId(Integer userId) {
		return postRepo.findByUser_Id(userId);
	}

	@Override
	public List<Post> getAllPostByUsername(String username) {
		return postRepo.findByUser_UsernameContaining(username);
	}

	@Override
	public List<Post> getAllPostContainingKeyword(String keyword) {
		return postRepo.findByReviewContaining(keyword);
	}

	@Override
	public List<Post> getAllPostByMedicalProcedureName(String medicalprocedureName) {
		return postRepo.findByMedicalprocedureContaining(medicalprocedureName);
	}

	@Override
	public List<Post> getAllPostByMedicalProcedureId(Integer procedureId) {
		return postRepo.findByMedicalprocedure_Id(procedureId);
	}
	
	@Override
	public List<Post> getAllPostByHospital(Hospital hospital) {
		// not sure if this works.
		return postRepo.findByHospital(hospital);
	}

	@Override
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureName(Integer hospitalId, String procedureName) {
   		return postRepo.findByHospital_IdAndMedicalprocedure_procedureNameContaining(hospitalId, procedureName);
	}

	@Override
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureId(Integer hospitalId, Integer procedureId) {
		return postRepo.findByHospital_IdAndMedicalprocedure_Id(hospitalId, procedureId);
	}

	@Override
	public List<Post> getAllPostByHospitalAndUser(Hospital hospital, User user) {
		return postRepo.findByHospitalAndUser(hospital, user);
	}

	// C R E A T E
	@Override
	public Post createPost(Post post) {
		// will attempt to find an id, and will auto-gen one
		// when none is found. Done by JPA Repository.
		Post newPost = postRepo.saveAndFlush(post);
		return newPost;
	}
	
	// U P D A T E
	@Override
	public Post updatePost(Post updatedPost) {
		Post oldPost = postRepo.findById(updatedPost.getId()).get();
		
		if (updatedPost.getReview() != null) {
			oldPost.setReview(updatedPost.getReview());
		}
		
		if (updatedPost.getCreateDate() != null) {
			oldPost.setCreateDate(updatedPost.getCreateDate());
		}
		
		if (updatedPost.getHospital() != null) {
			oldPost.setHospital(updatedPost.getHospital());
		}
		
		// save and returns the post in the database
		postRepo.saveAndFlush(oldPost);
		return oldPost;
	}

	// will remove update by Id because Post object will still need to be passed.
	@Override
	public Post updatePostById(Integer postId, Post updatedPost) {
		Post oldPost = postRepo.findById(postId).get();
		
		if (updatedPost.getReview() != null) {
			oldPost.setReview(updatedPost.getReview());
		}
		
		if (updatedPost.getCreateDate() != null) {
			oldPost.setCreateDate(updatedPost.getCreateDate());
		}
		
		if (updatedPost.getHospital() != null) {
			oldPost.setHospital(updatedPost.getHospital());
		}
		
		// save and returns the post in the database
		postRepo.saveAndFlush(oldPost);
		return oldPost;
	}
	
	// D E L E T E
	@Override
	public boolean deletePostById(Integer postId) {
		Post post = postRepo.findById(postId).get();
		
		try {
			postRepo.delete(post);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		
	}


}
