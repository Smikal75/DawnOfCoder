package com.techelevator;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import CampsiteDAO.Campsite;
import CampsiteDAO.JDBCCampsiteDAO;



public class JDBCCampsiteDAOTest {
	
	private static SingleConnectionDataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private JDBCCampsiteDAO daoCs;
	private Campsite testCs;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);
		
}
	@AfterClass
	public static void closeDataSource() {
		dataSource.destroy();
	}
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Before
	public void addCampsite() {
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
