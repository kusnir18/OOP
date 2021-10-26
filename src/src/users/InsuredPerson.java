package src.users;

import src.insurance_pac.InsuranceCompany;
import src.insurance_pac.insurance_catalog.insurance_programs.InsuranceProgram;

public class InsuredPerson extends Person{

    /**
     * <h1>class InsuredPerson</h1>
     *
     * Is a class that specify actions related to insurance_pac companies
     * Unlike  Person class this class focuses only on person-insurance_pac actions
     *
     *       Sole purpose of this object is to gather common functionality
     *       This class should not be used as an instance by it self
     *
     * @author  Maros Kusnir
     * @version 1.0
     * @since   2019
     * @serial
     */

    protected InsuranceProgram yourInsuranceProgram;

    /**
     * Constructor that creates object Insured person and sets Your insuranceProgram to null
     * @param myInformation
     * myInformation PersonalInformation, object that holds private information
     */
    public InsuredPerson(PersonalInformation myInformation) {
        super(myInformation);
        yourInsuranceProgram=null;
    }

    /**
     * Allows user to change insurance_pac program
     * @param index
     * index int, is being tested, by private method
     * @param yourInsuranceCompany
     * yourInsuranceCompany InsuranceCompany, takes your current insurance_pac company as an argument
     */
    public void changeInsuranceProgram(int index, InsuranceCompany yourInsuranceCompany){

        if( yourInsuranceCompanyID==-1 ||yourInsuranceName==null){
            System.out.println("Firstly you have to set insurance_pac in order to choose program");
            return;
        }

        if(!(testIndex(index, yourInsuranceCompany))){
            System.out.println("This is not possible");
            return;
        }

        this.setYourInsuranceProgram(yourInsuranceCompany.getCatalog().getCatalog().get(index));
    }

    /**
     * Tests whether index in catalog does exist
     * @param index
     * index int
     * @param yourInsuranceCompany
     * yourInsuranceCompany InsuranceCompany
     * @return boolean
     */
    private boolean testIndex(int index, InsuranceCompany yourInsuranceCompany){
        if( index >= 0 && index < yourInsuranceCompany.lengthOfCatalog()){
            return true;
        }
        return false;
    }

/////

    /**
     * Sets user's insurance_pac program
     * @param yourInsuranceProgram
     * yourInsuranceProgram InsuranceProgram, it is an insurance_pac program
     */
    private void setYourInsuranceProgram(InsuranceProgram yourInsuranceProgram) {
        this.yourInsuranceProgram = yourInsuranceProgram;
    }

    public InsuranceProgram getYourInsuranceProgram() {
        return yourInsuranceProgram;
    }

    /**
     * Prevents change of the insurance_pac because this is not end category
     *  Sole purpose of this object is to gather common functionality
     *  This class should not be used as an instance by it self
     * @param yourInsuranceCompany
     * yourInsuranceCompany InsuranceCompany type, take insurance_pac as an parameter
     */
    public void changeInsurance(InsuranceCompany yourInsuranceCompany){
        System.out.println("You have to be in category in order to change insurance_pac.");
    }

    /**
     * Empty method, is used just as an holder
     * @param yourInsuranceCompany
     * yourInsuranceCompany InsuranceCompany
     */
    @Override
    public void signOffInsurance(InsuranceCompany yourInsuranceCompany) {
    }
}