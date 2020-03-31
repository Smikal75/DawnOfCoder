package CampsiteDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import CampGroundDAO.Campground;



public class JDBCCampsiteDAO implements CampsiteDAO {
	private JdbcTemplate jdbcTemplate;

public JDBCCampsiteDAO (DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}
	
private Campsite mapRowToCampsite(SqlRowSet results) {
	Campsite theCampsite = new Campsite();
	theCampsite.setSiteID(results.getInt("site_id"));
	theCampsite.setCampgroundId(results.getInt("campground_id"));
	theCampsite.setSiteNum(results.getInt("site_number"));
	theCampsite.setMaxOccupancy(results.getInt("max_occupancy"));
	theCampsite.setAccessible(results.getBoolean("accessible"));
	theCampsite.setMaxRVlength(results.getInt("max_rv_length"));
	theCampsite.setUtilities(results.getBoolean("utilities"));

	return theCampsite;
}

	
	@Override
	public boolean addCampsite(Campsite newCampsite) {
		String sqlAddCampsite = "INSERT INTO site (site_id, campground_id, site_number, "
				+ " max_occupancy, accessible, max_rv_length, utilities) "
				+ "VALUES ( ?, ? , ? ,? , ?, ?, ?) ";
		jdbcTemplate.update(sqlAddCampsite, newCampsite.getSiteID(), newCampsite.getCampgroundId(), newCampsite.getSiteNum(),
				newCampsite.getMaxOccupancy(), newCampsite.isAccessible(), newCampsite.getMaxRVlength(), newCampsite.isUtilities());
		return true;

	}
	

	@Override
	public List<Campsite> getCampsitesByCampgroundId(Campground campground) {
		Campsite theCampsite = new Campsite();
		List<Campsite> campsitesByCgId = new ArrayList<>();
		String sqlCampsitebyNumberTable = "SELECT * FROM site ORDER site_number ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCampsitebyNumberTable);
		while (results.next()) {
			theCampsite = mapRowToCampsite(results);
			campsitesByCgId.add(theCampsite);
		}

		return campsitesByCgId;
	}
	@Override
	public List<Campsite> getCampsitesByParkId(Campground campground) {
		Campsite theCampsite = new Campsite();
		List<Campsite> campsitesByParkId = new ArrayList<>();
		String sqlCampsitebyNumberTable = "SELECT * FROM site JOIN campground ON site.campground_id = campground.campground_id "
				+ " ORDER campground_id ASC, site_number ASC,  ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCampsitebyNumberTable);
		while (results.next()) {
			theCampsite = mapRowToCampsite(results);
			campsitesByParkId.add(theCampsite);
		}

		return campsitesByParkId;
	}

	@Override //BONUS C
	public List<Campsite> getCampsitesByAllSpecified(Campground campground) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List <Campsite> available(Campground cg, LocalDate arrivingOn, LocalDate departingOn) {
		List<Campsite> availableSites = new ArrayList<>();
		
		LocalDate ld = LocalDate.of(2020, 1, 15);
		
		Campsite theCampsite = new Campsite();
		String sqlAvailableSites = "SELECT * FROM site WHERE campground_id = ? AND site_id NOT IN (SELECT site_id FROM reservation " + 
				"WHERE ( to_date <= ? AND from_date >= ? ) " + 
				"OR ( to_date <= ? AND from_date >= ? ) " + 
				"OR (to_date >= ? AND to_date <= ? )) LIMIT 5 ;";
		

		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAvailableSites, cg.getCampgroundId() , arrivingOn , 
				arrivingOn , departingOn , departingOn , arrivingOn , departingOn  );

		while (results.next()) {
			theCampsite = mapRowToCampsite(results);
			availableSites.add(theCampsite);
		}

		return availableSites;
	
	}


}
