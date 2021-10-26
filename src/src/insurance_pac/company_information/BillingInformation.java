package src.insurance_pac.company_information;

import java.io.Serializable;
/**
 * <h1>abstract class BillingInformation</h1>
 *
 * Data class it holds contact/billing information
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public abstract class BillingInformation implements Serializable {
    
    private String companyName;
    private long ICO; //
    private long DIC;
    private String IC_DPH;
}
