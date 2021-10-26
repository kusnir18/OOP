package src.users;

import src.insurance_pac.InsuranceCompany;

/**
 * <h1>class Youth</h1>
 * This class should be used for  creating specific instances, unlike class Person or Insured person
 * This class Youth suits as an specific user category
 *
 * extends InsuredPerson implements Insured
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */


public class Youth extends InsuredPerson implements Insured{

    /**
     * Class constructor
     * @param myInformation
     * myInformation PersonalInformation as an parameter
     */
    public Youth(PersonalInformation myInformation) {
        super(myInformation);
    }

    /**
     * Method that enables user to change Insurance
     * @param yourInsuranceCompany
     * yourInsuranceCompany InsuranceCompany is a parameter,
     * it uses InsuranceCompany as a visitor
     * it takes care of registration of Youth member
     */
    @Override
    public void changeInsurance(InsuranceCompany yourInsuranceCompany) {

        yourInsuranceCompany.addToRegister(this);
        yourInsuranceName =  yourInsuranceCompany.getBillingInformation().getCompanyName();
        yourInsuranceCompanyID =  yourInsuranceCompany.getBillingInformation().getCode_ofInsurance();

    }

    /**
     * Method that signs user off insurance_pac
     * @param yourInsuranceCompany
     * yourInsuranceCompany, InsuranceCompany is a parameter, it is an insurance company which you are currently in
     */
    @Override
    public void signOffInsurance(InsuranceCompany yourInsuranceCompany) {
        if( yourInsuranceCompanyID==-1 || yourInsuranceName==null){
            return;
        }
        yourInsuranceCompany.deleteFromRegister(this);

    }

}
