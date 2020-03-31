package com.techelevator.projects.model.jdbc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDate;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Employee mapRowToEmployee (SqlRowSet rowSet) {
		Employee employee= new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId(rowSet.getLong("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDay(LocalDate.parse(rowSet.getString("birth_date")));
		employee.setGender(rowSet.getString("gender").charAt(0));
		employee.setHireDate(LocalDate.parse(rowSet.getString("hire_date")));
		return employee;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List <Employee> EmployeeList = new ArrayList<> ();
		SqlRowSet employees = jdbcTemplate.queryForRowSet("SELECT * FROM employee;");
		while (employees.next()) {
			EmployeeList.add(mapRowToEmployee(employees));			
		}
		
		return EmployeeList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List <Employee> EmployeeList = new ArrayList<> ();
		String firstNameSql = "first_name LIKE '%" + firstNameSearch +
				"%'";
		String lastNameSql = "last_name LIKE '%" + lastNameSearch +
				"%'";
		String selectEmployeeByNameSql = "SELECT * FROM employee WHERE " + lastNameSql + " AND " + firstNameSql + ";";
		SqlRowSet employees = jdbcTemplate.queryForRowSet( selectEmployeeByNameSql);
		while (employees.next()) {
			EmployeeList.add(mapRowToEmployee(employees));	}
		return EmployeeList;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List <Employee> EmployeeList = new ArrayList<> ();
		SqlRowSet employees = jdbcTemplate.queryForRowSet("SELECT * FROM employee WHERE department_id = " + id + ";");
		while (employees.next()) {
			EmployeeList.add(mapRowToEmployee(employees));			
		}
		
		return EmployeeList;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List <Employee> EmployeeList = new ArrayList<> ();
		SqlRowSet employees = jdbcTemplate.queryForRowSet("SELECT * FROM employee as e " +
				"WHERE e.employee_id NOT IN (SELECT project_employee.employee_id FROM project_employee );");
		while (employees.next()) {
			EmployeeList.add(mapRowToEmployee(employees));			
		}
		
		return EmployeeList;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List <Employee> EmployeeList = new ArrayList<> ();
		String employeesOnProjectSql ="SELECT * FROM employee AS e JOIN project_employee AS pe ON e.employee_id = "
				+ "pe.employee_id WHERE project_id = ? ;";
		SqlRowSet employees = jdbcTemplate.queryForRowSet(employeesOnProjectSql, projectId);
		while (employees.next()) {
			EmployeeList.add(mapRowToEmployee(employees));			
		}
		
		return EmployeeList;
	
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String changeDeptSql ="UPDATE employee SET department_id = " + departmentId + " WHERE employee_id = " 
				+ employeeId + " ;" ;
		jdbcTemplate.update(changeDeptSql);
	}

}
