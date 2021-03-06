package com.skilldistillery.hospitalreview.services;

import java.util.List;

import com.skilldistillery.hospitalreview.entities.Hospital;
import com.skilldistillery.hospitalreview.entities.Post;
import com.skilldistillery.hospitalreview.entities.User;

public interface PostService {
	
	public List<Post> getAllPost();
	
	Post getPostById(Integer postId);
	
	public List<Post> getAllPostByHospitalId(Integer hospitalId);
	
	public List<Post> getAllPostByUserId(Integer hosptialId);
	
	public List<Post> getAllPostByUsername(String username);
	
	public List<Post> getAllPostContainingKeyword(String keyword);
	
	public List<Post> getAllPostByMedicalProcedureName(String medicalprocedureName);
	
	public List<Post> getAllPostByMedicalProcedureId(Integer procedureId);
	
	public List<Post> getAllPostByHospital(Hospital hospital);
	
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureName(Integer hospitalId, String procedureName);
	
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureId(Integer hospitalId, Integer procedureId);
	
	public List<Post> getAllPostByHospitalAndUser(Hospital hospital, User user);
	
	public Post createPost(Post post);
	
	public Post updatePost(Post updatedPost);
	
	public Post updatePostById(Integer postId, Post updatedPost);
	
	public boolean deletePostById(Integer postId);

}
