package src.insurance_pac.insurance_catalog.insurance_programs;

import java.io.Serializable;

/**
 * <h1>class ContractInfo</h1>
 *
 * Data class that hold datums of getDateOfExpiration and dateOfBeginning
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class ContractInfo implements Serializable {

    private long dateOfBeginning;
    private long getDateOfExpiration;

    /**
     * Gets dateOfBeginning
     * @return long
     */
    public long getDateOfBeginning() {
        return dateOfBeginning;
    }

    /**
     * Sets dateOfBeginning
     * @param dateOfBeginning long
     */
    public void setDateOfBeginning(long dateOfBeginning) {
        this.dateOfBeginning = dateOfBeginning;
    }

    /**
     * Sets DateOfExpiration
     * @return long
     */
    public long getGetDateOfExpiration() {
        return getDateOfExpiration;
    }

    /**
     * Sets DateOfExpiration
     * @param getDateOfExpiration long
     */
    public void setGetDateOfExpiration(long getDateOfExpiration) {
        this.getDateOfExpiration = getDateOfExpiration;
    }
}
