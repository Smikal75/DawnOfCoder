package com.techelevator.daotests;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
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
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JDBCProjectDAOTests {
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
	private JdbcTemplate jdbcTemplate;

	private JDBCEmployeeDAO daoE;
	private Employee testEmployee;
	private Project testProject;

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

	@Before
	public void setupProject() {
		String sqlInsertProject = "INSERT INTO project (project_id, name, to_date, from_date) "
				+ "VALUES (8, 'testproject', '3066-01-01', '1099-01-01')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertProject);
		dao = new JDBCProjectDAO(dataSource);
		SqlRowSet testProj = jdbcTemplate.queryForRowSet("SELECT * FROM project WHERE project_id = 8");
		if (testProj.next()) {
			testProject = dao.mapRowToProj(testProj);
		}
		String sqlInsertEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, "
				+ "gender, hire_date) " + "VALUES (19, 2, 'Joe', 'Test', '1066-01-01', 'M', '1066-01-01')";
		jdbcTemplate.update(sqlInsertEmployee);
		daoE = new JDBCEmployeeDAO(dataSource);
		SqlRowSet testingE = jdbcTemplate.queryForRowSet("SELECT * FROM employee WHERE employee_id = 19");
		if (testingE.next()) {
			testEmployee = daoE.mapRowToEmployee(testingE);
		}

	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	private Project mapStringToProject(Long project_id, String name, LocalDate to_date, LocalDate from_date) {
		Project project = new Project();
		project.setId(project_id);
		project.setName(name);
		project.setStartDate(from_date);
		project.setEndDate(to_date);
		return project;
	}

	private static boolean projEquals(Project a, Project b) {
		boolean equals = a.getId() == b.getId() && a.getName().equals(b.getName());
		return equals;
	}

	public Project getProjectById(Long id) {
		Project answer = null;
		String selectProjByNameSql = "SELECT * FROM project WHERE project_id = ?;";
		SqlRowSet project = jdbcTemplate.queryForRowSet(selectProjByNameSql, id);
		if (project.next()) {
			answer = dao.mapRowToProj(project);
		}
		return answer;
	}

	public boolean equalsEmployee(Employee a, Employee b) {
		boolean isEqual = a.getId() == b.getId() && a.getDepartmentId() == b.getDepartmentId()
				&& a.getFirstName().equals(b.getFirstName()) && a.getLastName().equals(b.getLastName())
				&& a.getGender() == b.getGender();
		return isEqual;
	}

	// TESTS BELOW THIS LINE
	@Test
	public void get_all_active_projects_shows_test_project() {

		List<Project> searchResults = dao.getAllActiveProjects();
		boolean isListed = false;
		for (Project searchResult : searchResults) {
			if (projEquals(testProject, searchResult)) {
				isListed = true;
			}
		}
		assertTrue(isListed);
	}

	@Test
	public void add_employee_to_project_shows_employee_when_list_employee_by_project() {
		dao.addEmployeeToProject((long) 8, (long) 19);
		List<Employee> searchResults = daoE.getEmployeesByProjectId((long) 8);
		boolean isListed = false;
		for (Employee searchResult : searchResults) {
			if (equalsEmployee(testEmployee, searchResult)) {
				isListed = true;
			}
		}
		assertTrue(isListed);
	}
}
