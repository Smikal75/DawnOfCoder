package ReservationDAO;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO implements ReservationDAO {

	private JdbcTemplate jdbcTemplate;

public JDBCReservationDAO (DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}

private Reservation mapRowToReservation(SqlRowSet results) {
	Reservation theReservation = new Reservation();
	theReservation.setReservationId(results.getInt("reservation_id"));
	theReservation.setSiteId(results.getInt("site_id"));
	theReservation.setReservationName(results.getString("name"));
	theReservation.setFromDate(LocalDate.parse(results.getString("from_date")));
	theReservation.setToDate(LocalDate.parse(results.getString("to_date")));
	theReservation.setCreatedDate(LocalDate.parse(results.getString("create_date")));
	

	return theReservation;
}

	@Override
	public int makeReservation(Reservation rs) {
		String sqlMakeReservation = "INSERT INTO reservation ( site_id, name, from_date, "
				+ " to_date, create_date) "
				+ "VALUES ( ?, ?, ?, ?, ?) ";
		jdbcTemplate.update(sqlMakeReservation, rs.getSiteId(), rs.getReservationName(),
				rs.getFromDate(), rs.getToDate(), rs.getCreatedDate());
		String sqlConfirmationNum = "SELECT reservation_id FROM reservation WHERE "
				+ " site_id = ? AND name = ? AND from_date = ? AND to_date = ? AND create_date = ? ";
		SqlRowSet reservationGetter = jdbcTemplate.queryForRowSet(sqlConfirmationNum, rs.getSiteId(), rs.getReservationName(),
				rs.getFromDate(), rs.getToDate(), rs.getCreatedDate());
		int reservationNumber= -1;
		while (reservationGetter.next()) {
			reservationNumber = reservationGetter.getInt("reservation_id");
			
		}

		return reservationNumber;

	}

	@Override
	public String cancelReservation(int confirmationNumber) {
		
		String sqlNukeReservation = "DELETE FROM reservation WHERE reservation_id = ? ";
		jdbcTemplate.update(sqlNukeReservation, confirmationNumber);
		return "Reservation #: " + confirmationNumber + " cancellation has been confirmed.";
	}

	@Override // bonus feature 
	public List<Reservation> upcomingReservations() {
//	 TODO Auto-generated method stub
	return null;
	}


	@Override
	public Reservation getReservationByConfirmation(int confirmationNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
