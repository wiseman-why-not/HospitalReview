package com.skilldistillery.hospitalreview.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="medicalprocedure")
public class MedicalProcedure {

	// F I E L D S
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="procedure_name")
	private String procedureName;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "cost")
	private Integer cost;
	
	@OneToOne(mappedBy="medicalprocedure")
	private Post post;
	
	// C O N S T R U C T O R S
	
	public MedicalProcedure() {
		super();
		// TODO Auto-generated constructor stub
	}


	// G E T T E R S & S E T T E R S
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	// H A S H & T O S T R I N G 

	@Override
	public String toString() {
		return "Procedure [id=" + id + ", procedureName=" + procedureName + ", description=" + description + ", cost="
				+ cost ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalProcedure other = (MedicalProcedure) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
