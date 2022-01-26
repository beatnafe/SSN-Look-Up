package dataaccess;

import domain.Retiree;

/**
 * The class used to interact with the data of Retiree
 *
 * @author Bisrat Atnafe
 */
public class SsnMap {

    private static int CAPACITY = 1024;
    private IDataAccess data = new DataAccessFileImpl();

    /**
     * Get the retiree in the map after being provided with SSN.
     *
     * @param ssn the SSN number to search
     * @return the retiree that was assigned the SSN
     */
    public Retiree get(long ssn) {
        int hashCode = hash(ssn);
        SsnAvl retirees = data.retrieveAvl(hashCode);
        if (retirees == null) {
            return null;
        }
        return retirees.get(ssn);
    }

    /**
     * Insert the SSN into an AVL tree
     *
     * @param ssn the SSN number of the Retiree
     * @param r Retiree to insert
     * @return True if the Retiree was inserted, False otherwise
     */
    public boolean insert(long ssn, Retiree r) {
        int hashCode = hash(ssn);
        SsnAvl retirees = data.retrieveAvl(hashCode);
        if (retirees == null) {
            retirees = new SsnAvl();
        }
        if (this.get(ssn) != null) {
            return false;
        }
        retirees.add(r);
        return data.saveAvl(hashCode, retirees);
    }

    /**
     * Remove the SSN from an AVL tree
     *
     * @param ssn the SSN number of the Retiree
     * @return True if the Retiree was removed, False if not.
     */
    public boolean remove(long ssn) {
        int index = hash(ssn);
        SsnAvl avl = data.retrieveAvl(index);
        if (avl == null) {
            return false;
        }
        boolean check = avl.remove(get(ssn));
        data.saveAvl(index, avl);
        return check;
    }

    /**
     * Hash method
     *
     * @param ssn : SSN
     * @return an integer depending on what the hashcode is
     */
    public int hash(long ssn) {
        int hashCode = (int) (ssn ^ (ssn >>> 32));
        return supplementalHash(hashCode) & (CAPACITY - 1);
    }

    /**
     * Hash used to help come up with a hashCode
     *
     * @param h integer that's a parameter from hash Method
     * @return integer that helps come up with a hashCode
     */
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

}
