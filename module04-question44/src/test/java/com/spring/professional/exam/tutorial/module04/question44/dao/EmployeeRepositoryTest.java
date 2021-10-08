package com.spring.professional.exam.tutorial.module04.question44.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.professional.exam.tutorial.module04.question44.entity.Employee;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	private static final Employee EMPLOYEE_1 = new Employee(1, "John", "Doe", "john@repo.com");
	private static final Employee EMPLOYEE_2 = new Employee(2, "Jane", "Dipa", "jane@repo.com");
	private static final Employee EMPLOYEE_3 = new Employee(3, "Tom", "From", "tom@repo.com");
	
	@Autowired private EmployeeDao employeeDao;
	@Autowired private TestEntityManager testEntityManager;
	
	@Test
	public void shouldStoreEmployees() {
		employeeDao.saveAll(Arrays.asList(EMPLOYEE_1,EMPLOYEE_2));
		
		assertEquals(EMPLOYEE_1, testEntityManager.find(Employee.class, 1));
		assertEquals(EMPLOYEE_2, testEntityManager.find(Employee.class, 2));
	}
	
	@Test
	public void shouldFindEmployeeByEmail() {
		testEntityManager.merge(EMPLOYEE_1);
		testEntityManager.merge(EMPLOYEE_2);
		testEntityManager.merge(EMPLOYEE_3);
		
		assertEquals(EMPLOYEE_1, employeeDao.findByEmail(EMPLOYEE_1.getEmail()));
		assertEquals(EMPLOYEE_2, employeeDao.findByEmail(EMPLOYEE_2.getEmail()));
		assertEquals(EMPLOYEE_3, employeeDao.findByEmail(EMPLOYEE_3.getEmail()));
	}
	
	
	
}
