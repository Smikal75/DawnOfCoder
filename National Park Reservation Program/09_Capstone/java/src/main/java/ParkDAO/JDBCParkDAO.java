package ParkDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// mapRowToPark
	public Park mapRowToPark(SqlRowSet results) {
		Park thePark = new Park();
		thePark.setParkId(results.getInt("park_id"));
		thePark.setParkName(results.getString("name"));
		thePark.setParkLocation(results.getString("location"));
		thePark.setEstablishedDate(LocalDate.parse(results.getString("establish_date")));
		thePark.setParkArea(results.getInt("area"));
		thePark.setVisitors(results.getInt("visitors"));
		thePark.setParkDesc(results.getString("description"));
		return thePark;
	}

	@Override
	public List<Park> getAllParks() {
		Park thePark = new Park();
		List<Park> allParks = new ArrayList<>();
		String sqlParksTable = "SELECT * FROM park ORDER BY name ;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParksTable);
		while (results.next()) {
			thePark = mapRowToPark(results);
			allParks.add(thePark);
		}

		return allParks;
	}
	

	@Override
	public String toString(Park aPark) {
		 int charCount = 0;
		String[] paragraph = aPark.getParkDesc().split(" ");
		String pStr1 = String.format("%-20s", "\n"+aPark.getParkName().toUpperCase()+ " NATIONAL PARK\n") + 
	     String.format("%-20s", "Location:") + String.format("%-60s\n", aPark.getParkLocation()) + 
	     String.format("%-20s", "Established:") + String.format("%-60s\n", aPark.getEstablishedDate()) + 
	     String.format("%-20s", "Area:") + String.format("%-60s\n", aPark.getParkArea()) + 
	    String.format("%-20s", "Annual Visitors:") + String.format("%-60s\n\n", aPark.getVisitors());
	   for (String line:paragraph) {
		  
		   pStr1 += line + " ";
		   charCount = charCount + line.length() + 1;
		   if (charCount >= 70) {
			   pStr1 += "\n";
			   charCount = 0;}
		   }
	   
		return pStr1;
	}

	@Override
	public Park getParkById(int id) {
		Park thePark = new Park();
		String sqlParkById = "SELECT * FROM park WHERE park_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkById, id);
		while(results.next()) {
			thePark = mapRowToPark(results);
					}

		return thePark;
	}

	@Override
	public List <Park> getParkByName(String name) {
		Park thePark = new Park();
		List<Park> allParksByName = new ArrayList<>();
		String sqlParkById = "SELECT * FROM park WHERE name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlParkById, name);
		if (results.next()) {
			thePark = mapRowToPark(results);
			allParksByName.add(thePark);
		}
		return allParksByName;
	}

	@Override
	public boolean addPark(Park newPark) {
		String sqlAddPark = "INSERT INTO park (park_id, name, location, establish_date, area, visitors, description)"
				+ "VALUES ( ?, ? , ? ,? , ?, ?, ?) ";
		jdbcTemplate.update(sqlAddPark, newPark.getParkId(), newPark.getParkName(), newPark.getParkLocation(),
				newPark.getEstablishedDate(), newPark.getParkArea(), newPark.getVisitors(), newPark.getParkDesc());
		return true;

	}

}
