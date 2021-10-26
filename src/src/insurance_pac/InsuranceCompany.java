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
 * <h1> abstract class InsuranceCompany</h1>
 *
 * Provides layout for Insurance companies, necessary functions
 *
 * implements CompanyBasic, CompanyBasic.CompanyDeletions, Serializable
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public abstract class InsuranceCompany implements CompanyBasic, CompanyBasic.CompanyDeletions, Serializable {

    private InsuranceCatalog mainCatalog;
    private InsuranceInformation billingInformation;
    public abstract InsuranceCatalog getCatalog();
    public abstract int lengthOfCatalog();
    public abstract void setCatalog(InsuranceCatalog mainCatalog);


    public abstract InsuranceInformation getBillingInformation();
    public abstract void setBillingInformation(InsuranceInformation billingInformation);

    public abstract void addToRegister(Senior person);
    public abstract void addToRegister(Mature person);
    public abstract void addToRegister(Youth person);

    public abstract void deleteFromRegister(Senior person);
    public abstract void deleteFromRegister(Mature person);
    public abstract void deleteFromRegister(Youth person);

    public abstract CustomerRegister getRegister();

    public abstract StateRegulations getRegulations();
    public abstract int setRegulations(StateRegulations regulations);


    public abstract void setUnAutorisedChange();

}
