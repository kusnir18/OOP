package src.insurance_pac;

import src.insurance_pac.company_information.InsuranceInformation;
import src.insurance_pac.customer_register.CustomerRegister;
import src.insurance_pac.insurance_catalog.InsuranceCatalog;
import src.users.Mature;
import src.users.Senior;
import src.users.Youth;


/**
 * <h1>interface CompanyBasic</h1>
 *
 * Provides blueprint for insurance_pac companies
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public interface CompanyBasic {

    InsuranceCatalog getCatalog();
    InsuranceInformation getBillingInformation();
    CustomerRegister getRegister();

    void setBillingInformation(InsuranceInformation billingInformation);
    void addToRegister(Senior person);
    void addToRegister(Mature person);
    void addToRegister(Youth person);
    int lengthOfCatalog();
    void setCatalog(InsuranceCatalog mainCatalog);


    interface CompanyDeletions{

        void deleteFromRegister(Senior person);
        void deleteFromRegister(Mature person);
        void deleteFromRegister(Youth person);
    }

}
