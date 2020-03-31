package com.techelevator.daotests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
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

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JDBCDepartmentDAOTests {
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	private JdbcTemplate jdbcTemplate;
	
	private static final String TEST_DEPARTMENT = "fail";
	// before we run any tests, we are going to set the datasource
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/department_projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
	
		// we can disable the autocommit for the connections so we acn rollback after
		//each test
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertDept = "INSERT INTO department (department_id, name)" +
	                           "VALUES(9, ?);";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDept, TEST_DEPARTMENT);
		dao = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	private Department mapRowToDept (SqlRowSet rowSet) {
		Department department= new Department();
		department.setId(rowSet.getLong("department_id"));
		department.setName(rowSet.getString ("name"));
		return department;
	}
	
	private Department mapStringToDepartment (Long departmentId, String name) {
		Department department= new Department();
		department.setId(departmentId);
		department.setName(name);
		return department;
	}

	private static boolean deptEquals(Department a, Department b) {
		boolean equals = (a.getId() == b.getId() && a.getName().equals(b.getName()));
		return equals;
	}
	//TESTS BELOW THIS LINE
	@Test
	public void save_new_department_read_back() {
		Department theDepartment = mapStringToDepartment((long) 8, "Testing Create Department");
		dao.createDepartment(theDepartment);
		Department testDepartment = new Department();
		testDepartment = dao.getDepartmentById(theDepartment.getId());
			assertTrue(deptEquals(theDepartment, testDepartment));
	}
	@Test
	public void save_new_department_read_back_by_name() {
		Department theDepartment = mapStringToDepartment((long) 8, "Testing Department");
		dao.createDepartment(theDepartment);
		List <Department> deptSearch = new ArrayList<> ();
			Department testDepartment = dao.searchDepartmentsByName("Testing").get(0);
			assertTrue(deptEquals(theDepartment, testDepartment));
	}
	@Test
	public void save_new_department_read_back_by_all() {
		Department theDepartment = mapStringToDepartment((long) 8, "Testing Department");
		dao.createDepartment(theDepartment);
		List <Department> deptSearch = dao.getAllDepartments();
		boolean itWorks = false;
		 for( Department dept : deptSearch ) {
			 if (deptEquals(theDepartment, dept)) {
				 itWorks = true;
			 }
		 }			
			assertTrue(itWorks);
	}
	
}
