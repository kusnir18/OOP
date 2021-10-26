package src.system;

import src.insurance_pac.StateInsurance;
import src.insurance_pac.company_information.InsuranceInformation;
import src.insurance_pac.insurance_catalog.insurance_programs.RegularInsurance;

import java.io.Serializable;

/**
 * <h1>class CreateStateInsurance/h1>
 *
 * It creates and sets first and only state insurance_pac, and it also initialise fields and also it sets fields to default values
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class CreateStateInsurance implements Serializable {

    /**
     * it sets state insurance_pac to default state, ready for use
     *
     * {@code
     *          StateInsurance stateInsurance = new StateInsurance();
     *         InsuranceInformation stateInsInf = new InsuranceInformation();
     *         RegularInsurance program = new RegularInsurance();
     *         StateRegulations regulations= new StateRegulations();
     *
     *         regulations.setInsuranceMillionaire(550);
     *         regulations.setInsuranceMiddle(250);
     *         regulations.setInsuranceMinimum(125);
     *
     *         stateInsInf.setCompanyName("State_insurance");
     *         stateInsInf.setCode_ofInsurance(0);
     *         program.setNameOfProgram("State health welfare program");
     *
     *
     *         stateInsurance.setBillingInformation(stateInsInf);
     *         stateInsurance.getCatalog().addToOfferCatalog(program);
     *         stateInsurance.setRegulations(regulations);
     *
     *         state.addInsurance(stateInsurance);
     * }
     * @param state is an data object
     */
    public void stateInsurance(DataStorage state){

        StateInsurance stateInsurance = new StateInsurance();
        InsuranceInformation stateInsInf = new InsuranceInformation();
        RegularInsurance program = new RegularInsurance();
        StateRegulations regulations= new StateRegulations();

        regulations.setInsuranceMillionaire(550);
        regulations.setInsuranceMiddle(250);
        regulations.setInsuranceMinimum(125);

        stateInsInf.setCompanyName("State_insurance");
        stateInsInf.setCode_ofInsurance(0);
        program.setNameOfProgram("State health welfare program");


        stateInsurance.setBillingInformation(stateInsInf);
        stateInsurance.getCatalog().addToOfferCatalog(program);
        stateInsurance.setRegulations(regulations);

        state.addInsurance(stateInsurance);
    }

}
