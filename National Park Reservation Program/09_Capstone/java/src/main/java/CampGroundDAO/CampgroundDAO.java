package CampGroundDAO;

import java.util.List;

public interface CampgroundDAO {
//CRUD
	
	public boolean addCampground (Campground newCg);
	public List <Campground> getAllCampgrounds();
	public Campground getCampgroundById(int campgroundId);
	public List<Campground> getCampgroundByParkId(int parkId);
	public boolean isOpen(Campground cg, int startMonth, int closeMonth);
	public double campgroundTotalFee(Campground cg, int numberOfDays);
	public Campground getCampgroundByName(String cgName) ;
}
