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

import com.skilldistillery.hospitalreview.entities.Post;

public class PostService implements PostServiceImpl {

	@Override
	public Post getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByHospitalId(Integer hospitalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByUserId(Integer hosptialId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostContainingKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByMedicalProcedureName(String medicalprocedureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByMedicalProcedureId(Integer procedureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureName(Integer hospitalId, String procedureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByHospitalIdAndMedicalProcedureId(Integer hospitalId, Integer procedureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post createPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(Post updatedPost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePostById(Integer postId) {
		// TODO Auto-generated method stub
		return false;
	}

}
