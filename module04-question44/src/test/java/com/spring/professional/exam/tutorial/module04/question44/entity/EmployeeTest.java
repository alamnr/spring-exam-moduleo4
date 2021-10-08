package com.spring.professional.exam.tutorial.module04.question44.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeTest {

	private static final Employee EMPLOYEE_1 = new Employee(1, "Jane", "Dipa", "jane@repo.com");
	private static final Employee EMPLOYEE_2 = new Employee(2, "John", "Doe", "john@repo.com");
	
	@Autowired private TestEntityManager testEntityManager;
	
	@Test
	public void shouldStoreEmployeeAndFindById() {
		testEntityManager.merge(EMPLOYEE_1);
		testEntityManager.merge(EMPLOYEE_2);
		
		assertEquals(EMPLOYEE_1, testEntityManager.find(Employee.class, 1));
		assertEquals(EMPLOYEE_2, testEntityManager.find(Employee.class, 2));
	}
}
