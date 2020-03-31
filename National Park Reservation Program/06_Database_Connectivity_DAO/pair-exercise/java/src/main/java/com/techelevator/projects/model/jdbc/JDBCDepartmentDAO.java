package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	private Department mapRowToDept (SqlRowSet rowSet) {
		Department department= new Department();
		department.setId(rowSet.getLong("department_id"));
		department.setName(rowSet.getString ("name"));
		return department;
	}
	
	@Override
	public List<Department> getAllDepartments() {
		List <Department> departmentsList = new ArrayList<> ();
		SqlRowSet departments = jdbcTemplate.queryForRowSet("SELECT * FROM department;");
		while (departments.next()) {
			departmentsList.add( mapRowToDept(departments));			
		}
		
		return departmentsList;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List <Department> departmentsList = new ArrayList<> ();
		String selectDeptByNameSql = "SELECT name, department_id FROM department WHERE name LIKE ?";
		String searchTerm = "%" + nameSearch + "%"; 
				SqlRowSet departments = jdbcTemplate.queryForRowSet(selectDeptByNameSql, searchTerm);
		while (departments.next()) {
			departmentsList.add(mapRowToDept (departments));	}
		return departmentsList;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String updateDeptSql = "UPDATE department SET name = '" + updatedDepartment.getName() + "' WHERE department_id = '" + updatedDepartment.getId() + "';";
		jdbcTemplate.update(updateDeptSql);
				
				
	}

	@Override
	public Department createDepartment (Department newDepartment) {
		String updateDeptSql = "INSERT INTO department VALUES ( ? , ? );";
		jdbcTemplate.update(updateDeptSql, 
				newDepartment.getId(),
				newDepartment.getName());
		Department confirmed = getDepartmentById(newDepartment.getId());
		return confirmed;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department answer = null;
		String selectDeptByNameSql = "SELECT name, department_id FROM department WHERE department_id = ?;";
				SqlRowSet departments = jdbcTemplate.queryForRowSet(selectDeptByNameSql, id);
		if (departments.next()) {
		answer = mapRowToDept (departments);}
		return answer;
		
	}

}
