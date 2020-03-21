package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {

	// F I E L D S
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="review")
	private String review;
	
	@Column(name="create_date")
	private String createDate;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	
	@OneToOne
	@JoinColumn(name="hospital_id")
	private Procedure procedure;
	
	// C O N S T R U C T O R S
	public Post() {
		super();
	}
}
