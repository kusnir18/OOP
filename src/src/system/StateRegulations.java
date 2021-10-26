package src.system;

import java.io.Serializable;

/**
 * <h1>class StateRegulations</h1>
 *
 * Class that holds state information about amount of fee based on income
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class StateRegulations implements Serializable {

    protected int insuranceMinimum;
    protected int insuranceMiddle;
    protected int insuranceMillionaire;

    /**
     * Gets insurance_pac minimum fee
     * @return int
     */
    public int getInsuranceMinimum() {
        return insuranceMinimum;
    }

    /**
     * Sets  insurance_pac minimum fee
     * @param insuranceMinimum int
     */
    public void setInsuranceMinimum(int insuranceMinimum) {
        this.insuranceMinimum = insuranceMinimum;
    }

    /**
     * Gets insurance_pac middle fee
     * @return int
     */
    public int getInsuranceMiddle() {
        return insuranceMiddle;
    }

    /**
     * Sets  insurance_pac middle fee
     * @param insuranceMiddle int
     */
    public void setInsuranceMiddle(int insuranceMiddle) {
        this.insuranceMiddle = insuranceMiddle;
    }

    /**
     * Gets insurance_pac maximum fee
     * @return int
     */
    public int getInsuranceMillionaire() {
        return insuranceMillionaire;
    }

    /**
     * Sets  insurance_pac maximum fee
     * @param insuranceMillionaire int
     */
    public void setInsuranceMillionaire(int insuranceMillionaire) {
        this.insuranceMillionaire = insuranceMillionaire;
    }
}
