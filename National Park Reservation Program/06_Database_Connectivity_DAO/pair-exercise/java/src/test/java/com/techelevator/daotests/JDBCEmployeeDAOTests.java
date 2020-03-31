package com.techelevator.daotests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCEmployeeDAOTests {
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	private Employee testEmployee;
	private JdbcTemplate jdbcTemplate;

	// before we run any tests, we are going to set the datasource

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/department_projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		// we can disable the autocommit for the connections so we acn rollback after
		// each test
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() {
		dataSource.destroy();
	}

	@Before // dummy object use this to generate
	public void setupEmployee() {
		String sqlInsertEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, "
				+ "gender, hire_date) " + "VALUES (19, 2, 'Joe', 'Test', '1066-01-01', 'M', '1066-01-01')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertEmployee);
		dao = new JDBCEmployeeDAO(dataSource);
		SqlRowSet testing = jdbcTemplate.queryForRowSet("SELECT * FROM employee WHERE employee_id = 19");
		if (testing.next()) {
			testEmployee = dao.mapRowToEmployee(testing);
		}
	}

	public boolean equalsEmployee(Employee a, Employee b) {
		boolean isEqual = a.getId() == b.getId() && a.getDepartmentId() == b.getDepartmentId()
				&& a.getFirstName().equals(b.getFirstName()) && a.getLastName().equals(b.getLastName())
				&& a.getGender() == b.getGender();
		return isEqual;
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void get_all_employees_returns_test() {
		List<Employee> searchResults = dao.getAllEmployees();
		boolean isListed = false;
		for (Employee searchResult : searchResults) {
			if (equalsEmployee(testEmployee, searchResult)) {
				isListed = true;
			}
		}

		assertTrue(isListed);

	}
	// *SearchEmployeesByName

	@Test
	public void get_employee_by_name_test() {
		List<Employee> searchResults = dao.searchEmployeesByName("Joe", "Test");
		Employee newEmployee = searchResults.get(0);
		assertTrue(equalsEmployee(newEmployee, testEmployee));

	}

	@Test
	public void get_employees_without_projects() {
		List<Employee> searchResults = dao.getEmployeesWithoutProjects();
		boolean isListed = false;
		for (Employee searchResult : searchResults) {
			if (equalsEmployee(testEmployee, searchResult)) {
				isListed = true;
			}
		}

		assertTrue(isListed);

	}
	// getEmployeesByProject
}
