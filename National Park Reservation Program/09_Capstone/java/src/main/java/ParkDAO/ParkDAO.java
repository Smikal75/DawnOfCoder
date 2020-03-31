/**
 * 
 */
package ParkDAO;

import java.util.List;

/**
 * @author Student
 *
 */
public interface ParkDAO {

	//Not a CRUD interface. this is a Read-Only class
	public List <Park> getAllParks ();	
	public String toString(Park aPark);
	public Park getParkById(int id);
	public List <Park>  getParkByName(String name);
	public boolean addPark(Park newPark);
	
}	
