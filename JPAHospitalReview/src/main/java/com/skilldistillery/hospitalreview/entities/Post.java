package com.skilldistillery.hospitalreview.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="medicalprocedure_id")
	private MedicalProcedure medicalprocedure;
	
	// C O N S T R U C T O R S
	
	public Post() {
		super();
	}

	public Post(int id, String review, Date createDate) {
		super();
		this.id = id;
		this.review = review;
		this.createDate = createDate;
	}
	
	// G E T T E R S & S E T T E R S
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public MedicalProcedure getMedicalProcedure() {
		return medicalprocedure;
	}

	public void setMedicalProcedure(MedicalProcedure medicalProcedure) {
		this.medicalprocedure = medicalProcedure;
	}
	
	// H A S H & T O S T R I N G 

	@Override
	public String toString() {
		return "Post [id=" + id + ", review=" + review + ", createDate=" + createDate + "]";
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
		Post other = (Post) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
