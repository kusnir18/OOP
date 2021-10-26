package src.users;

import src.insurance_pac.InsuranceCompany;
import src.insurance_pac.insurance_catalog.insurance_programs.InsuranceProgram;

import java.io.Serializable;
/**
 * <h1> abstract class Person</h1>
 * Person class has a several functions
 *
 * Firstly:
 * It posses common and frequently used fields such as yourInsuranceName and yourInsuranceCompanyID
 * which are often used across program, thus there is no need for all personal information
 * Rest of personal information is aggregated as an instance. This class does have getters and setters for mentioned fields.
 *
 * Secondly:
 * It defines a layout for methods, which are essential for program such as changeInsuranceProgram and signOffInsurance
 *
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public abstract class Person implements Serializable {

    private PersonalInformation myInformation;
    protected String yourInsuranceName;
    protected int yourInsuranceCompanyID;

    /**
     * Constructor of class PersonalInformation
     * It initialise aggregated objects;
     * */
    public Person() {
        this( new PersonalInformation() );
    }

    /**
     * Constructor of class PersonalInformation
     * It initialise aggregated objects;
     * @param myInformation
     * myInformation PersonalInformation, its type PersonalInformation, is an object that holds personal information
     * */
    public Person(PersonalInformation myInformation) {
        this.setMyInformation(myInformation);
        yourInsuranceCompanyID = -1;
    }
/////

    /**
     * Gets user's insurance_pac company number
     * @return int
     */
    public int getYourInsuranceCompanyID() {
        return yourInsuranceCompanyID;
    }

    /**
     * Sets user's insurance_pac company number
     * @param yourInsuranceCompanyID
     * yourInsuranceCompanyID int, is an unique number of an insurance_pac company
     */
    public void setYourInsuranceCompanyID(int yourInsuranceCompanyID) {
        this.yourInsuranceCompanyID = yourInsuranceCompanyID;
    }

//////

    /**
     * Gets user's personal information
     * @return PersonalInformation
     */
    public PersonalInformation getMyPersonalInformation() {
        return myInformation;
    }

    /**
     * Sets user's personal information
     * @param myInformation
     * myInformation PersonalInformation
     */
    public void setMyInformation(PersonalInformation myInformation) {
        this.myInformation = myInformation;
    }
////

    /**
     * Gets user's InsuranceName
     * @return name of your insurance, String
     */
    public String getYourInsuranceName() {
        return yourInsuranceName;
    }

    /**
     * Sets user's insurance_pac name
     * @param yourInsuranceName
     * yourInsuranceName, it is name of your insurance
     */
    public void setYourInsuranceName(String yourInsuranceName) {
        this.yourInsuranceName = yourInsuranceName;
    }

    public abstract void changeInsurance(InsuranceCompany yourInsuranceCompany);
    public abstract void changeInsuranceProgram(int index, InsuranceCompany yourInsuranceCompany);
    public abstract void signOffInsurance(InsuranceCompany yourInsuranceCompany);

    //public abstract void setYourInsuranceProgram(InsuranceProgram yourInsuranceProgram);

    public abstract InsuranceProgram getYourInsuranceProgram();
}
