package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public Project mapRowToProj (SqlRowSet rowSet) {
		Project project= new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString ("name"));
		if (rowSet.getString("from_date") == null) { 
			project.setStartDate(LocalDate.MIN);
		} else {
		project.setStartDate(LocalDate.parse(rowSet.getString("from_date")));}
		if (rowSet.getString("to_date")==null) {
			project.setEndDate(LocalDate.MAX);
		} else {
		project.setEndDate(LocalDate.parse(rowSet.getString("to_date")));}
		
		return project;
	}
	@Override
	public List<Project> getAllActiveProjects() {
		List <Project> projectsList = new ArrayList<> ();
		
		SqlRowSet projects = jdbcTemplate.queryForRowSet("SELECT * FROM project;");
		while (projects.next()) {
		Project activeProject =	mapRowToProj(projects);	
		if ((activeProject.getEndDate().isAfter(LocalDate.now())   &&
			activeProject.getStartDate().isBefore(LocalDate.now()) )) {
			projectsList.add(activeProject);
		}
		}
		
		return projectsList;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
	String fireWorker = "DELETE FROM project_employee WHERE employee_id= " + employeeId + 
			" AND project_id = " + projectId + ";";
	jdbcTemplate.update(fireWorker);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
	String addEmployeeToProjectSql = "INSERT INTO project_employee (employee_id, project_id) "
			+ "VALUES (" + employeeId + ", " + projectId + " );";
	jdbcTemplate.update(addEmployeeToProjectSql);
	}

}

