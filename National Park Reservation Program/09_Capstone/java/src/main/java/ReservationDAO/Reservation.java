package ReservationDAO;

import java.time.LocalDate;

public class Reservation {

	private int reservationId;
	private int siteId;
	private String reservationName;
	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalDate createdDate;
	/**
	 * @param reservationId
	 * @param siteId
	 * @param reservationName
	 * @param fromDate
	 * @param toDate
	 * @param createdDate
	 */
	public Reservation( int siteId, String reservationName, LocalDate fromDate, LocalDate toDate,
			LocalDate createdDate) {
		
		this.siteId = siteId;
		this.reservationName = reservationName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.createdDate = createdDate;
	}
	
	public Reservation() {
		
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
}
