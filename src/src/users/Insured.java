package src.users;

import src.insurance_pac.InsuranceCompany;

public interface Insured {

    /**
     * <h1>Interface Insured</h1>
     * Acts as a blueprint for common functions
     * @author  Maros Kusnir
     * @version 1.0
     * @since   2019
     */
    PersonalInformation getMyPersonalInformation();
    void signOffInsurance(InsuranceCompany yourInsuranceCompany);
}
