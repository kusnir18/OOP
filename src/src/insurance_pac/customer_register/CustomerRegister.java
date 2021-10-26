package src.insurance_pac.customer_register;

import src.users.Insured;
import src.users.Mature;
import src.users.Senior;
import src.users.Youth;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h1>class CustomerRegister</h1>
 *
 * Class that contains Arraylists of users.
 * It takes care of deletions and addition via visitor
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class CustomerRegister implements customerList, Serializable {

    private ArrayList <Insured> customerRegister;
    private ArrayList <Senior>  seniorRegister;
    private ArrayList <Mature>  matureRegister;
    private ArrayList <Youth>  youthRegister;

    /**
     * Class constructor that initialises ArrayLists
     */
    public CustomerRegister() {
        this.customerRegister = new ArrayList<Insured>();
        this.seniorRegister = new ArrayList<Senior>();
        this.matureRegister = new ArrayList<Mature>();
        this.youthRegister = new ArrayList<Youth>();
    }

///

    /**
     * Adds senior customer
     * @param person Senior
     */
    @Override
    public void addToCustomerRegister(Senior person) {
        customerRegister.add(person);
        seniorRegister.add(person);
    }

    /**
     * Adds mature customer
     * @param person Mature
     */
    @Override
    public void addToCustomerRegister(Mature person) {
        customerRegister.add(person);
        matureRegister.add(person);
    }

    /**
     * Adds youth customer
     * @param person Youth
     */
    @Override
    public void addToCustomerRegister(Youth person) {
        customerRegister.add(person);
        youthRegister.add(person);
    }
///

    /**
     * Deletes senior customer
     * @param person Senior
     */
    @Override
    public void deleteFromCustomerRegister(Senior person) {
        customerRegister.remove(person);
        seniorRegister.remove(person);
    }

    /**
     * Deletes mature customer
     * @param person Mature
     */
    @Override
    public void deleteFromCustomerRegister(Mature person) {
        customerRegister.remove(person);
        matureRegister.remove(person);
    }

    /**
     * Deletes youth customer
     * @param person Youth
     */
    @Override
    public void deleteFromCustomerRegister(Youth person) {
        customerRegister.remove(person);
        youthRegister.remove(person);
    }

    /**
     * Gets customer register
     * @return ArrayList<Insured> customer register
     */
    @Override
    public ArrayList<Insured> getCustomerRegister() {
        return customerRegister;
    }
}
