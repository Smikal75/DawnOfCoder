package CampsiteDAO;

import java.time.LocalDate;
import java.util.List;

import CampGroundDAO.Campground;

public interface CampsiteDAO {
//CRUD
	public boolean addCampsite (Campsite newCampsite);
	public List <Campsite> getCampsitesByCampgroundId (Campground campground);
	public List <Campsite> getCampsitesByParkId (Campground campground);
	public List <Campsite> getCampsitesByAllSpecified (Campground campground);
	public List <Campsite> available(Campground cg, LocalDate startDate, LocalDate endDate);
	
		
}
