/**
 * 
 */
package CampGroundDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import ParkDAO.Park;

/**
 * @author Student
 *
 */
public class JDBCCampgroundDAO implements CampgroundDAO {
	private JdbcTemplate jdbcTemplate;

	public JDBCCampgroundDAO (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private Campground mapRowToCampground(SqlRowSet results) {
		Campground theCampground = new Campground();
		theCampground.setParkId(results.getInt("park_id"));
		theCampground.setCampgroundName(results.getString("name"));
		theCampground.setCampgroundId(results.getInt("campground_id"));
		theCampground.setOpenFromMonth(results.getInt("open_from_mm"));
		theCampground.setClosedFromMonth(results.getInt("open_to_mm"));
		theCampground.setDailyFee(results.getDouble("daily_fee"));

		return theCampground;
	}
	
	@Override
	public boolean addCampground(Campground newCg) {
		String sqlAddCampground = "INSERT INTO campground (campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee)"
				+ "VALUES ( ?, ? , ? , ? , ?, ? ) ";
		jdbcTemplate.update(sqlAddCampground, newCg.getCampgroundId(), newCg.getParkId(), newCg.getCampgroundName(), 
							newCg.getOpenFromMonth(), newCg.getClosedFromMonth(), newCg.getDailyFee());
		return true;

	}
	@Override
	public List<Campground> getAllCampgrounds() {
		Campground theCampground = new Campground();
		List<Campground> allCampgrounds = new ArrayList<>();
		String sqlCampgroundTable = "SELECT * FROM campground ORDER name ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCampgroundTable);
		while (results.next()) {
			theCampground = mapRowToCampground(results);
			allCampgrounds.add(theCampground);
		}

		return allCampgrounds;
	}

	@Override
	public Campground getCampgroundById(int campgroundId) {
		Campground campgroundCgId = new Campground();
		String sqlCampgroundCgById = "SELECT * FROM campground WHERE campground_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCampgroundCgById, campgroundId);
		while (results.next()) {
			campgroundCgId = mapRowToCampground(results);
					}

		return campgroundCgId;
	}

	@Override
	public List <Campground> getCampgroundByParkId(int parkId) {
		List <Campground> cgsByPark = new ArrayList <> ();
;		Campground cgByParkid = new Campground();
		String sqlCampgroundParkById = "SELECT * FROM campground WHERE park_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCampgroundParkById, parkId);
		while(results.next()) {
			cgByParkid = mapRowToCampground(results);
			cgsByPark.add(cgByParkid);
		}

		return cgsByPark;
	}
	
	@Override
	public Campground getCampgroundByName(String cgName) {
		Campground cgByCgName = new Campground();
		String sqlCampgroundParkById = "SELECT * FROM campground WHERE name = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCampgroundParkById, cgName);
		while(results.next()) {
			cgByCgName = mapRowToCampground(results);
		}

		return cgByCgName;
	}
	@Override
	public boolean isOpen(Campground cg, int startMonth, int closeMonth) {
		boolean isOpen = false;
		if (startMonth >= cg.getOpenFromMonth() && closeMonth <= cg.getClosedFromMonth()) {
		isOpen = true;
	}
		return isOpen;
	}

	@Override
	public double campgroundTotalFee(Campground cg, int numberOfDays) {
	Double totalFee = numberOfDays * cg.getDailyFee();
		return totalFee;
	}

}
