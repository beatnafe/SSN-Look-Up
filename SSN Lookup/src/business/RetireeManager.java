package business;

import dataaccess.SsnMap;
import domain.Retiree;

/**
 * A business class for managing Retiree through the application UI
 *
 * @author Bisrat Atnafe
 *
 */
public class RetireeManager {

    private SsnMap map;

    /**
     * Constructor that instantiates the map
     */
    public RetireeManager() {
        map = new SsnMap();
    }
    
    /**
     * This method adds a new Retiree to a SsnMap
     *
     * @param retiree an object of Retiree Type to be added
     * @return True if added, False otherwise
     */
    public boolean add(Retiree retiree) {
        return map.insert(retiree.getSsn(), retiree);
    }
    
    /**
     * This method deletes the retiree if the SSN matches the parameter 
     *
     * @param ssn a value of long data type which is the SSN that is in the map
     * @return True if deleted, False otherwise
     */
    public boolean delete(long ssn) {
        return map.remove(ssn);
    }
    
    /**
     * This method gets a Retiree if the SSN matches the parameter
     *
     * @param ssn a value of long data type which is the SSN that is in the map
     * @return the Retiree if the SSN is in the map, Null otherwise
     */
    public Retiree get(long ssn) {
        return map.get(ssn);
    }

}
