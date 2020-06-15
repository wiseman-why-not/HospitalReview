package com.skilldistillery.hospitalreview.services;

import java.util.List;

import com.skilldistillery.hospitalreview.entities.Post;

public interface PostServiceImpl {
	
	public Post getAllPost();
	
	public List<Post> getAllPostByHospitalId(Integer hospitalId);
	
	public List<Post> getAllPostByUserId(Integer hosptialId);
	
	public List<Post> getAllPostByUsername(String username);
	
	public List<Post> getAllPostContainingKeyword(String keyword);
	
	public List<Post> getAllPostByMedicalProcedureName(String medicalprocedureName);
	
	public List<Post> getAllPostByMedicalProcedureId(Integer procedureId);
	
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureName(Integer hospitalId, String procedureName);
	
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureId(Integer hospitalId, Integer procedureId);
	
	public Post createPost(Post post);
	
	public Post updatePost(Post updatedPost);
	
	public Post updatePostById(Integer postId);
	
	public boolean deletePostById(Integer postId);
	
	
	
}
