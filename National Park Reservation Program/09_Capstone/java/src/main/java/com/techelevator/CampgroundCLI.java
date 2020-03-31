package com.techelevator;

import java.time.LocalDate;
import java.util.List;

// REMEMBER TO REVIEW THE MENU CLASS!!!!! It runs on defined Arrays, not ArrayLists!!!!

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.view.Menu;

import CampGroundDAO.Campground;
import CampGroundDAO.JDBCCampgroundDAO;
import CampsiteDAO.Campsite;
import CampsiteDAO.JDBCCampsiteDAO;
import ParkDAO.JDBCParkDAO;
import ParkDAO.Park;
import ReservationDAO.JDBCReservationDAO;
import ReservationDAO.Reservation;

public class CampgroundCLI {
	private JDBCParkDAO daoP;
	private JDBCCampgroundDAO daoC;
	private JDBCCampsiteDAO daoS;
	private JDBCReservationDAO daoR;
	private Menu menu = new Menu(System.in, System.out);

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
	}

	public CampgroundCLI(DataSource datasource) {
		daoP = new JDBCParkDAO(datasource);
		daoC = new JDBCCampgroundDAO(datasource);
		daoS = new JDBCCampsiteDAO(datasource);
		daoR = new JDBCReservationDAO(datasource);
	}

	public void run() {
		boolean inMain = true;

		while (inMain) {
			System.out.printf("%-70s", "NATIONAL PARKS CAMPSITE RESERVATION SYSTEM");
			System.out.printf("%-70s", "\n\nPlease Select A Park, or press [Q] to quit\n");
			
			
			List<Park> getAllParks = daoP.getAllParks();

			
			 Park[] allParks = new Park [getAllParks.size()]; 
			 for (int x = 0 ; x < getAllParks.size() ; x++) 
			 
			 { allParks[x] = getAllParks.get(x); }
			  
			 

			Park choicePark = (Park) (menu.getChoiceFromOptions(allParks));
		
			
			System.out.printf("%-70s", "\n\nPlease Select A Campground, or press [Q] to quit\n\n");
			System.out.println(daoP.toString(choicePark));
			//// Park OBJECT SELECTED
			List<Campground> cgsAtUserPark = daoC.getCampgroundByParkId(choicePark.getParkId());

			System.out.println(String.format("%-85s", "\n\n    CAMPGROUND") + String.format("%-8s", "OPENS")
					+ String.format("%-8s", "CLOSES") + String.format("%-10s", "DAILY FEE"));
			Campground[] allCgs = new Campground[cgsAtUserPark.size()];
			
			  for (int x = 0 ; x < cgsAtUserPark.size() ; x++) { allCgs[x] =
			  cgsAtUserPark.get(x); }
 
			Campground choiceCampground = (Campground) menu.getChoiceFromOptions(allCgs);
			
			System.out.println( "You have selected " + choiceCampground.getCampgroundName() 
					+ "\n");
			LocalDate arrivingOn = LocalDate.now();
			LocalDate departingOn = LocalDate.now();
			boolean invalidDate = true;
			while (invalidDate) {		
			
			while (!arrivingOn.isAfter(LocalDate.now())) {
			arrivingOn =Query.askDate("Please enter your arrival date (yyyy-mm-dd):");
			}
			while (!departingOn.isAfter(arrivingOn)) {
			departingOn =Query.askDate("Please enter your departure date (yyyy-mm-dd):");
			}	
			
			List <Campsite> topVSites = daoS.available(choiceCampground, arrivingOn, departingOn);
			Campsite[] availableSites = new Campsite[topVSites.size()];
			
			  for (int x = 0 ; x < topVSites.size() ; x++) { availableSites[x] =
					  topVSites.get(x); }
		if (arrivingOn.getMonthValue() < choiceCampground.getOpenFromMonth() || 
			  departingOn.getMonthValue() > choiceCampground.getClosedFromMonth()) {
			System.out.println("\nThe campground is unavailable at that time; please make another selection.\n");
			arrivingOn = LocalDate.now();
			departingOn = LocalDate.now();}
			else {invalidDate=false;}
			}
			int daysInStay = 0;
			while (arrivingOn.plusDays(daysInStay).isBefore(departingOn)) {
				daysInStay ++;
			}
			double totalFee = daysInStay * choiceCampground.getDailyFee();
			System.out.println("\n The total fee for your visit will be $" + String.format("%.2f", totalFee));
			System.out.println("\n\nChoose an available site to make reservation");
			System.out.println("\t--Availble sites: " + choicePark.getParkName() + " National Park --" + 
					choiceCampground.getCampgroundName() + " Campground--");
			List <Campsite> topVSites = daoS.available(choiceCampground, arrivingOn, departingOn);
			Campsite[] availableSites = new Campsite[topVSites.size()];
			
			  for (int x = 0 ; x < topVSites.size() ; x++) { availableSites[x] =
					  topVSites.get(x); }
			Campsite choiceSite = (Campsite) menu.getChoiceFromOptions(availableSites);
			System.out.println("\n\nChoose an available site to make reservation");
			String reservationName = "'" +Query.ask("Please Enter a name for the reservation:") +"'";
			Reservation reservation = new Reservation(choiceSite.getSiteID(), reservationName, arrivingOn, departingOn, LocalDate.now());
			int confirmationNum = daoR.makeReservation(reservation);
			System.out.println("Your reservation Details : " + confirmationNum + " " +reservationName);
		}
		}
	}
	

