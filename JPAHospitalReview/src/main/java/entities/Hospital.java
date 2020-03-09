package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Hospital {

	// F I E L D S
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="description")
	private String description;
	
	@Column(name="time_length")
	private String timeLength;
	
	@Column(name = "doctor_name")
	private String doctorName;

	// C O N S T R U C T O R S
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
