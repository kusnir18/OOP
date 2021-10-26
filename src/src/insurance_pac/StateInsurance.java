package src.insurance_pac;

import src.system.StateRegulations;

/**
 * <h1>class StateInsurance</h1>
 *
 * Class for creating state insurance_pac which is allowed to change fee regulations
 *
 * extends StandardInsuranceCompany
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class StateInsurance extends StandardInsuranceCompany {

    private StateRegulations regulations;

    public StateInsurance() {
    }

    /**
     * Gets regulations
     * @return StateRegulations
     */
    @Override
    public StateRegulations getRegulations() {
        return regulations;
    }

    /**
     * Sets regulations
     * @param regulations StateRegulations
     * @return 1
     */
    @Override
    public int setRegulations(StateRegulations regulations) {

        this.regulations = regulations;
        return 1;
    }
}
