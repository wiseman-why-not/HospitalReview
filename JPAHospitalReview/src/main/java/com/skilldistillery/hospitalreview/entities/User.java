package com.skilldistillery.hospitalreview.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;

@Entity
@Table(name="user")
public class User {
	
	// F I E L D S
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="gender")
	private String gender;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	// C O N S T R U C T O R S

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, Integer age, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}

	// G E T T E R S & S E T T E R S
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	// H A S H & T O S T R I N G 

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", gender="
				+ gender + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
