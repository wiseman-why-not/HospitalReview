package entities;

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



class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	private Hospital hospital;
	
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
		hospital = em.find(Hospital.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
		hospital = null;
		em.close();
	}

	@Test
	@DisplayName("username test")
	void test1() {
		assertEquals("mortysmith", user.getUsername());
	}
	
	@Test
	@DisplayName("hospital anme test")
	void test2() {
		assertEquals("Denver Health", hospital.getName());
	}
	

}
