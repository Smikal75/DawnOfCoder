package ReservationDAO;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import CampGroundDAO.Campground;
import CampsiteDAO.Campsite;

public interface ReservationDAO {


	public int makeReservation(Reservation rs);
	public String cancelReservation(int confirmationNumber);
	public List<Reservation> upcomingReservations();
	
	public Reservation getReservationByConfirmation(int confirmationNumber);

}
