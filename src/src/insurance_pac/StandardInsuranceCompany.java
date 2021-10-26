package src.insurance_pac;

import src.insurance_pac.company_information.InsuranceInformation;
import src.insurance_pac.customer_register.CustomerRegister;
import src.insurance_pac.insurance_catalog.InsuranceCatalog;
import src.system.StateRegulations;
import src.users.Mature;
import src.users.Senior;
import src.users.Youth;

import java.io.Serializable;

/**
 * <h1>class StandardInsuranceCompany</h1>
 *
 * Instance of this class represents a normal non-state fully functional insurance_pac company
 * It has customer register, offer catalog, billing information and other fields and Arraylists
 * It also enables customers to be added and deleted from registers
 *
 * implements CompanyBasic, CompanyBasic.CompanyDeletions, Serializable
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class StandardInsuranceCompany extends InsuranceCompany implements Serializable {

    private int counter;
    private InsuranceInformation billingInformation;
    private InsuranceCatalog mainCatalog;
    private InsuranceCatalog specialCatalog;
    private CustomerRegister register;
    private int unAutorisedChange;

    /**
     * Increments when unauthorised change occur
     */
    public void unAutorisedChange() {
        this.unAutorisedChange = unAutorisedChange++;
    }

    /**
     * Class constructor that initialises integer fields to zero and it initialises all Arraylists and  objects
     */
    public StandardInsuranceCompany() {
        counter = 0;
        this.billingInformation= new InsuranceInformation();
        this.mainCatalog= new InsuranceCatalog();
        this.specialCatalog= new InsuranceCatalog();
        this.register= new CustomerRegister();
        unAutorisedChange=0;
    }

    /**
     * Passes person parameter to customer, where it is added.
     * Actualise persons code of insurance_pac to value from current instance of an insurance_pac
     * Actualise persons code of insurance_pac name to value from current instance of an insurance_pac
     * Increments customer count by one.
     *
     * @param person Senior
     */
    @Override
    public void addToRegister(Senior person) {
        if (person.getYourInsuranceCompanyID() ==  billingInformation.getCode_ofInsurance()){
            return;
        }
        person.signOffInsurance(this); //toto zvlast na persona
        person.setYourInsuranceCompanyID(billingInformation.getCode_ofInsurance());
        person.setYourInsuranceName(billingInformation.getCompanyName());
        register.addToCustomerRegister(person);
        counter++;
    }

    /**
     * Passes person parameter to customer, where it is added.
     * Actualise persons code of insurance_pac to value from current instance of an insurance_pac
     * Actualise persons code of insurance_pac name to value from current instance of an insurance_pac
     * Increments customer count by one.
     *
     * @param person Mature
     */
    @Override
    public void addToRegister(Mature person) {
        if (person.getYourInsuranceCompanyID() ==  billingInformation.getCode_ofInsurance()){
            return;
        }
        person.signOffInsurance(this);
        person.setYourInsuranceCompanyID(billingInformation.getCode_ofInsurance());
        person.setYourInsuranceName(billingInformation.getCompanyName());
        register.addToCustomerRegister(person);
        counter++;
    }

    /**
     * Passes person parameter to customer, where it is added.
     * Actualise persons code of insurance_pac to value from current instance of an insurance_pac
     * Actualise persons code of insurance_pac name to value from current instance of an insurance_pac
     * Increments customer count by one.
     *
     * @param person Youth
     */
    @Override
    public void addToRegister(Youth person) {
        if (person.getYourInsuranceCompanyID() ==  billingInformation.getCode_ofInsurance()){
            return;
        }
        person.signOffInsurance(this);
        person.setYourInsuranceCompanyID(billingInformation.getCode_ofInsurance());
        person.setYourInsuranceName(billingInformation.getCompanyName());
        register.addToCustomerRegister(person);
        counter++;
    }

    ////
    /**
     * Passes person parameter to customer, where it is deleted if it matches current (this  very instance of) insurance_pac company.
     * Actualise persons code of insurance_pac to value from current instance -1, default value for non-assigned value
     * Decrements customer count by one.
     *
     * @param person Mature
     */
    @Override
    public void deleteFromRegister(Mature person){
        if (person.getYourInsuranceCompanyID() ==  billingInformation.getCode_ofInsurance()){
            person.setYourInsuranceCompanyID(-1);
            register.deleteFromCustomerRegister(person);
            counter--;
        }
    }

    /**
     * Passes person parameter to customer, where it is deleted if it matches current (this  very instance of) insurance_pac company.
     * Actualise persons code of insurance_pac to value from current instance -1, default value for non-assigned value
     * Decrements customer count by one.
     *
     * @param person Senior
     */
    @Override
    public void deleteFromRegister(Senior person){
        if (person.getYourInsuranceCompanyID() ==  billingInformation.getCode_ofInsurance()){
            person.setYourInsuranceCompanyID(-1);
            register.deleteFromCustomerRegister(person);
            counter--;
        }
    }

    /**
     * Passes person parameter to customer, where it is deleted if it matches current (this  very instance of) insurance_pac company.
     * Actualise persons code of insurance_pac to value from current instance -1, default value for non-assigned value
     * Decrements customer count by one.
     *
     * @param person Youth
     */
    @Override
    public void deleteFromRegister(Youth person){
        if (person.getYourInsuranceCompanyID() ==  billingInformation.getCode_ofInsurance()){
            person.setYourInsuranceCompanyID(-1);
            register.deleteFromCustomerRegister(person);
            counter--;
        }
    }

    /**
     * Gets offer catalog
     * @return InsuranceCatalog
     */
    @Override
    public InsuranceCatalog getCatalog() {
        return mainCatalog;
    }

    /**
     * Gets length of offer catalog
     * @return int
     */
    public int lengthOfCatalog() {
        return mainCatalog.getCatalog().size();
    }

    /**
     * Sets offer catalog
     * @param mainCatalog InsuranceCatalog
     */
    @Override
    public void setCatalog(InsuranceCatalog mainCatalog) {
        this.mainCatalog = mainCatalog;
    }

    /**
     * Gets billing information
     * @return InsuranceInformation
     */
    @Override
    public InsuranceInformation getBillingInformation() {
        return billingInformation;
    }

    /**
     * Sets Insurance information by passed parameter
     * @param billingInformation InsuranceInformation
     */
    @Override
    public void setBillingInformation(InsuranceInformation billingInformation) {
        this.billingInformation = billingInformation;
    }

    /**
     * Gets user registers, instance which has many registers
     * @return
     */
    public CustomerRegister getRegister() {
        return register;
    }

    /**
     * Gets state regulations
     * @return
     */
    @Override
    public StateRegulations getRegulations() {
        return null;
    }

    /**
     * Sets regulations
     * @param regulations
     * @return 0 when it is used
     */
    @Override
    public int setRegulations(StateRegulations regulations) {
        this.unAutorisedChange();
        return 0;
    }

    /**
     * Increments when unauthorised change occur
     */
    public void setUnAutorisedChange() {
        this.unAutorisedChange++;
    }
}
