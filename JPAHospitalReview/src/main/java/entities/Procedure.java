package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Procedure {

	// F I E L D S
	
	@Id
	@Column(name="procedure_name")
	private String prcedureName;
	
	@Column(name = "cost")
	private Integer cost;
	
	@Column(name="user")
	private User user;
	
	// C O N S T R U C T O R S
	
	public Procedure() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
