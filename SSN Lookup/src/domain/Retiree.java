package domain;

import java.io.Serializable;

/**
 * A class for storing all the information of the retiree
 *
 * @author Bisrat Atnafe
 */
public class Retiree implements Comparable<Retiree>, Serializable {

    private long ssn;
    private String fullName;
    private double monthlyBenefit;

    /**
     * A full constructor that adds a Retiree
     *
     * @param ssn
     * @param fullName
     * @param monthlyBenefit
     */
    public Retiree(long ssn, String fullName, double monthlyBenefit) {
        this.ssn = ssn;
        this.fullName = fullName;
        this.monthlyBenefit = monthlyBenefit;
    }

    /**
     * A method to get the SSN of retiree
     *
     * @return the SSN of the retiree
     */
    public long getSsn() {
        return ssn;
    }

    /**
     * A method to get the full name of the retiree
     *
     * @return full name of the retiree
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * A method to get the monthly benefit of the retiree
     *
     * @return the monthly benefit of the retiree
     */
    public double getMonthlyBenefit() {
        return monthlyBenefit;
    }

    /**
     * A method to output the Retiree, their SSN number and benefits
     *
     * @return string representing the information of the retiree
     */
    @Override
    public String toString() {
        return ssn + " : " + fullName + "\n"
                + "Monthly Benefit = $" + monthlyBenefit;
    }

    /**
     * A method to calculate a unique hash code for a retiree object
     *
     * @return the hashCode value
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.ssn ^ (this.ssn >>> 32));
        return hash;
    }

    /**
     * This method is used to compare objects of this class
     *
     * @param obj the object to compare to the current one
     * @return True if the objects are the same, False otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Retiree other = (Retiree) obj;
        return this.ssn == other.ssn;
    }

    /**
     * A method to compare Retiree objects by SSN for sorting
     *
     * @param o - the Retiree object to compare with
     * @return -1: if the current SSN is less than the provided SSN. 
     *         1 : if the current SSN is greater than the provided SSN. 
     *         0 : if the SSNs are equal
     */
    @Override
    public int compareTo(Retiree o) {
        if (this.ssn < o.ssn) {
            return -1;
        } else if (this.ssn > o.ssn) {
            return 1;
        } else {
            return 0;
        }
    }

}
