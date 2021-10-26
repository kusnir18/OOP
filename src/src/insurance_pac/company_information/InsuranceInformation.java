package src.insurance_pac.company_information;

import java.io.Serializable;

/**
 * <h1>class InsuranceInformation</h1>
 *
 * Provides getters and setters for BillingInformation, allows access to data
 *
 * class InsuranceInformation extends BillingInformation implements Serializable
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class InsuranceInformation extends BillingInformation implements Serializable {

    private String companyName;
    private int code_ofInsurance;

    //private long ICO;
    //private long DIC;
    //private String IC_DPH;


    /**
     * Gets company name
     * @return String
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets company name
     * @param companyName Sting
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets code_ofInsurance
     * @return int
     */
    public int getCode_ofInsurance() {
        return code_ofInsurance;
    }

    /**
     * Sets setCode_ofInsurance
     * @param code_ofInsurance int
     */
    public void setCode_ofInsurance(int code_ofInsurance) {
        this.code_ofInsurance = code_ofInsurance;
    }
}


/*    public long getICO() {
        return ICO;
    }

    public void setICO(long ICO) {
        this.ICO = ICO;
    }

    public long getDIC() {
        return DIC;
    }

    public void setDIC(long DIC) {
        this.DIC = DIC;
    }

    public String getIC_DPH() {
        return IC_DPH;
    }

    public void setIC_DPH(String IC_DPH) {
        this.IC_DPH = IC_DPH;
    }*/
