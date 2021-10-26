package src.users;

import src.insurance_pac.InsuranceCompany;

/**
 * <h1>class Kid </h1>
 * This class should be used for  creating specific instances, unlike class Person or Insured person
 * This class Youth suits as an specific user category
 *
 * extends Youth
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class Kid extends Youth implements UnderAged{

    /**
     * Class constructor
     * @param myInformation
     * myInformation PersonalInformation as an parameter
     */
    public Kid(PersonalInformation myInformation) {
        super(myInformation);
    }

    /**
     * Method that enables user to change Insurance
     * BUT class kid is restricted so it can be set only to state insurance_pac
     * @param yourInsuranceCompany
     * yourInsuranceCompany InsuranceCompany is a parameter,
     * it uses InsuranceCompany as a visitor
     * it takes care of registration of Mature member
     */
    @Override
    public void changeInsurance(InsuranceCompany yourInsuranceCompany) {
        if(yourInsuranceCompany.getBillingInformation().getCode_ofInsurance()==0){
            //System.out.println("Hura");
            yourInsuranceCompany.addToRegister(this);
            yourInsuranceName =  yourInsuranceCompany.getBillingInformation().getCompanyName();
            yourInsuranceCompanyID =  yourInsuranceCompany.getBillingInformation().getCode_ofInsurance();
            return;
        }

        yourInsuranceCompany.setUnAutorisedChange();
    }///polymorphism

    /**
     * Method that restricts and ban signOfInsurance and increments value of unauthorised change inside InsuranceCompany object by one
     * @param yourInsuranceCompany
     * yourInsuranceCompany InsuranceCompany
     */
    @Override
    public void signOffInsurance(InsuranceCompany yourInsuranceCompany) {
        yourInsuranceCompany.setUnAutorisedChange();
    }///change it later for poly morphism no action allowed MAYBE

}
