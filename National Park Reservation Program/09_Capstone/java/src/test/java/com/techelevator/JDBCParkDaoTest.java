package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;



	import java.sql.SQLException;
import java.util.List;

import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.FixMethodOrder;
	import org.junit.runners.MethodSorters;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.datasource.SingleConnectionDataSource;
	import org.springframework.jdbc.support.rowset.SqlRowSet;

	import ParkDAO.JDBCParkDAO;
import ParkDAO.Park;
	

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public class JDBCParkDaoTest {

		
		private static SingleConnectionDataSource dataSource;
		private JdbcTemplate jdbcTemplate;
		private JDBCParkDAO daoP;
		private Park testPark;
		
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
		public void addPark() {
		
		String sqlAddPark = "INSERT INTO park (park_id, name, location, establish_date, area, visitors, description ) "
			+ "VALUES ( 9999, 'TestPark' , 'Jupiter , '1055-01-01', 31313131 , 51515151, 'in outerspace yo')";
				
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(sqlAddPark);
				daoP = new JDBCParkDAO(dataSource);
				daoP.addPark(testPark);
				}
			
	
	@Test
	  public void test_to_get_all_park() {

        List<Park> allPark = daoP.getAllParks();
        int parkCount = 0;
        for (int i = 0; i < allPark.size(); i++) {
            parkCount++;
        }
        assertNotNull(allPark);
        assertEquals(parkCount, allPark.size());
       }

	
	}
	

