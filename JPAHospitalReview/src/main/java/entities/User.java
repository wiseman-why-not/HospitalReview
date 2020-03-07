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
	private int id;
	private String username;

}
