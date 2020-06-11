package com.skilldistillery.hospitalreview.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.hospitalreview.entities.Hospital;
import com.skilldistillery.hospitalreview.entities.User;



class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	private Hospital hospital;
	private MedicalProcedure medicalprocedure;
	private Post post;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("HospitalReviewPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 5);
		hospital = em.find(Hospital.class, 2);
		medicalprocedure = em.find(MedicalProcedure.class, 2);
		post = em.find(Post.class, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
		hospital = null;
		medicalprocedure = null;
		post = null;
		em.close();
	}

	@Test
	@DisplayName("username test")
	void test1() {
		assertEquals("mortysmith", user.getUsername());
	}
	
	@Test
	@DisplayName("hospital name test")
	void test2() {
		assertEquals("Saint Joseph Hospital", hospital.getName());
	}
	
	@Test
	@DisplayName("medicalprocedure test")
	void test3() {
		assertEquals("Circumcision", medicalprocedure.getProcedureName());
	}
	
	@Test
	@DisplayName("post test")
	void test4() {
		assertEquals("Another test review for a hospital", post.getReview());
	}


}
