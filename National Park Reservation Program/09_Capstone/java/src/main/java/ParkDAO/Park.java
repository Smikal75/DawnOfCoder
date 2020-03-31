package ParkDAO;

import java.time.LocalDate;

public class Park {

	
	private int parkId;
	private String parkName;
	private String parkLocation;
	private LocalDate establishedDate;
	private int parkArea;
	private int visitors;
	private String parkDesc;
	
	
	/**
	 * @param parkId
	 * @param parkName
	 * @param parkLocation
	 * @param establshedDate
	 * @param parkArea
	 * @param visitors
	 * @param parkDesc
	 */
	public Park(int parkId, String parkName, String parkLocation, LocalDate establishedDate, int parkArea, int visitors,
			String parkDesc) {
		this.parkId = parkId;
		this.parkName = parkName;
		this.parkLocation = parkLocation;
		this.establishedDate = establishedDate;
		this.parkArea = parkArea;
		this.visitors = visitors;
		this.parkDesc = parkDesc;
	}
	
	public Park () {
		
	}
	
	
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getParkLocation() {
		return parkLocation;
	}
	public void setParkLocation(String parkLocation) {
		this.parkLocation = parkLocation;
	}
	public LocalDate getEstablishedDate() {
		return establishedDate;
	}
	public void setEstablishedDate(LocalDate establishedDate) {
		this.establishedDate = establishedDate;
	}
	public int getParkArea() {
		return parkArea;
	}
	public void setParkArea(int parkArea) {
		this.parkArea = parkArea;
	}
	public int getVisitors() {
		return visitors;
	}
	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}
	public String getParkDesc() {
		return parkDesc;
	}
	public void setParkDesc(String parkDesc) {
		this.parkDesc = parkDesc;
	}

	@Override
	public String toString() {
		return parkName ;
	}
	
}
