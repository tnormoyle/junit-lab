package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	private Student student1;

	@Before
	public void setUp() throws Exception {
		student1 = new Student("Jane", "Smith");
	}

	@Test
	public void testGetCurrentEarnedCr() {
		int credits = 45;
		student1.setCurrentEarnedCr(credits);
		assertEquals(credits, student1.getCurrentEarnedCr());
	}
	@Test
	public void testReadyToGraduate1() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	@Test
	public void testNotReadyToGraduate1() {
		student1.setCurrentEarnedCr(100);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());		
	}
	@Test
	public void testNotReadyToGraduate2() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(1.8);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());		
	}
	@Test
	public void testNotReadyToGraduate3() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(false);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());		
	}
	@Test
	public void testNotReadyToGraduate4() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(false);
		assertFalse(student1.readyToGraduate());
	}
	@Test
	public void testReadyToGraduate2() {
		student1.setCurrentEarnedCr(122);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	@Test
	public void testGetCurrentRemainingCr1() {
		student1.setCurrentEarnedCr(118);
		student1.getCurrentRemainingCr();
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	@Test
	public void testGetCurrentRemainingCr2() {
		student1.setCurrentEarnedCr(120);
		student1.getCurrentRemainingCr();
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	@Test
	public void testGetCurrentRemainingCr3() {
		student1.setCurrentEarnedCr(122);
		student1.getCurrentRemainingCr();
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	@Test
	public void testStudentCount() {
		int count = Student.getStudentCount();
		new Student("Joe", "Jones");
		assertEquals(count+1,Student.getStudentCount());
	}
	@Test
	public void testStudentID() {
		int count = Student.getStudentCount();
		Student s2 = new Student("Joe", "Jones");
		assertEquals(String.format("%07d", count+1),s2.getId());
	}

}
