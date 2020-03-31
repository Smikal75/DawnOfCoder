package CampsiteDAO;

public class Campsite {


	private int siteID;
	private int campgroundId;
	private int siteNum;
	private int maxOccupancy;
	private boolean accessible;
	private int maxRVlength;
	private boolean utilities;
	
	public Campsite() {
		
	}

	/**
	 * @param siteID
	 * @param campgroundId
	 * @param siteNum
	 * @param maxOccupancy
	 * @param accessible
	 * @param maxRVlength
	 * @param utilities
	 */
	public Campsite(int siteID, int campgroundId, int siteNum, int maxOccupancy, boolean accessible, int maxRVlength,
			boolean utilities) {
		this.siteID = siteID;
		this.campgroundId = campgroundId;
		this.siteNum = siteNum;
		this.maxOccupancy = maxOccupancy;
		this.accessible = accessible;
		this.maxRVlength = maxRVlength;
		this.utilities = utilities;
	}

	public int getSiteID() {
		return siteID;
	}

	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}

	public int getCampgroundId() {
		return campgroundId;
	}

	public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}

	public int getSiteNum() {
		return siteNum;
	}

	public void setSiteNum(int siteNum) {
		this.siteNum = siteNum;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}

	public boolean isAccessible() {
		return accessible;
	}

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public int getMaxRVlength() {
		return maxRVlength;
	}

	public void setMaxRVlength(int maxRVlength) {
		this.maxRVlength = maxRVlength;
	}

	public boolean isUtilities() {
		return utilities;
	}

	public void setUtilities(boolean utilities) {
		this.utilities = utilities;
	}
	@Override
	public String toString() {
		return  "Campsite:  #" +  String.format("%5s", siteNum) + "  Occupancy: "
				+ String.format("%5s",maxOccupancy) + "  Accessible?:  " + String.format("%5s", (accessible ? "Yes":"No")) 
				+ " Max. RV length: " + String.format("%5s", maxRVlength)
				+ "ft.   utilities?:  " + String.format("%5s", (utilities ? "Yes" : "No"));
	}

}
