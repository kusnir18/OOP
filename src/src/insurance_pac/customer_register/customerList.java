package src.insurance_pac.customer_register;

import src.users.Insured;
import src.users.Mature;
import src.users.Senior;
import src.users.Youth;

import java.util.ArrayList;


/**
 * <h1>interface customerList</h1>
 * defines basic functions
 * {@code
 *
 *     void addToCustomerRegister(Senior person);
 *     void addToCustomerRegister(Mature person);
 *     void addToCustomerRegister(Youth person);
 *
 *     void deleteFromCustomerRegister(Mature person);
 *     void deleteFromCustomerRegister(Youth person);
 *     void deleteFromCustomerRegister(Senior person);
 *
 *     ArrayList<Insured> getCustomerRegister();
 * }
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public interface customerList {

    void addToCustomerRegister(Senior person);
    void addToCustomerRegister(Mature person);
    void addToCustomerRegister(Youth person);

    void deleteFromCustomerRegister(Mature person);
    void deleteFromCustomerRegister(Youth person);
    void deleteFromCustomerRegister(Senior person);

    ArrayList<Insured> getCustomerRegister();
}
