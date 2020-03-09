package entities;

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
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	private List<Post> posts;
	
	// C O N S T R U C T O R S

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
