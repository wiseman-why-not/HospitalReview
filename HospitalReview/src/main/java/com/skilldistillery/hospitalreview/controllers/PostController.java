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

import com.skilldistillery.hospitalreview.entities.Post;
import com.skilldistillery.hospitalreview.services.PostService;

@RestController // implies both @Controller and @ResponseBody
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class PostController {

	// Autowired services
	
	@Autowired
	private PostService postSvc;
	
	@GetMapping("posts")
	public List<Post> allPosts(){
		System.out.println("----------- Someone is trying to get all posts : " + "-------------");
		return postSvc.getAllPost();
	}
	
	@GetMapping("posts/{postId}")
	public Post allPostById(@PathVariable Integer postId){
		System.out.println("----------- Someone is trying to get a Post by Id : " + "-------------");
		return postSvc.getPostById(postId);
	}
	
	@PostMapping("post")
	public Post addPost(@RequestBody Post post) {
		System.out.println("----------- Someone is trying to create a Post : " + "-------------");
		return postSvc.createPost(post);
	}
	
	@PutMapping("post")
	public Post updatePost(@RequestBody Post post) {
		System.out.println("----------- Someone is trying to update a Post : " + "-------------");
		return postSvc.updatePost(post);
	}
	
	@PutMapping("post/{postId}")
	public Post updatePostById(@PathVariable Integer postId, @RequestBody Post post) {
		System.out.println("----------- Someone is trying to update a Post by id : " + "-------------");
		return postSvc.updatePostById(postId, post);
	}
	
	@DeleteMapping("post/{postId}")
	public boolean deletePost(@PathVariable Integer postId) {
		System.out.println("----------- Someone is trying to delete a Post : " + "-------------");
		return postSvc.deletePostById(postId);
	}
}
