package CampGroundDAO;

public class Campground {


	private int campgroundId;
	private int parkId;
	private String campgroundName;
	private int openFromMonth;
	private int closedFromMonth;
	private double dailyFee;

	public Campground() {

	}

	public Campground(int campgroundId, int parkId, String campgroundName, int openFromMonth, int closedFromMonth,
			double dailyFee) {
		super();
		this.campgroundId = campgroundId;
		this.parkId = parkId;
		this.campgroundName = campgroundName;
		this.openFromMonth = openFromMonth;
		this.closedFromMonth = closedFromMonth;
		this.dailyFee = dailyFee;
	}

	public int getCampgroundId() {
		return campgroundId;
	}

	public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public String getCampgroundName() {
		return campgroundName;
	}

	public void setCampgroundName(String campgroundName) {
		this.campgroundName = campgroundName;
	}

	public int getOpenFromMonth() {
		return openFromMonth;
	}

	public void setOpenFromMonth(int openFromMonth) {
		this.openFromMonth = openFromMonth;
	}

	public int getClosedFromMonth() {
		return closedFromMonth;
	}

	public void setClosedFromMonth(int closedFromMonth) {
		this.closedFromMonth = closedFromMonth;
	}

	public double getDailyFee() {
		return dailyFee;
	}

	public void setDailyFee(double dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	public static String mmToMonth (int mm) {
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		return months[mm -1];
		}
	
	@Override
	public String toString() {
		return  String.format( "%-80s" , campgroundName) 
			+ String.format("%-8s", mmToMonth(openFromMonth)) 
			+ String.format("%-8s", mmToMonth(closedFromMonth)) 
			+"$"+ String.format( "%.2f" , dailyFee);
		
		
		
	}
}
