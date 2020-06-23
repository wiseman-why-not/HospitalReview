package com.skilldistillery.hospitalreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
