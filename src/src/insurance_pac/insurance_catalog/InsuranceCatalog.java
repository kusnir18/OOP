package src.insurance_pac.insurance_catalog;

import src.insurance_pac.insurance_catalog.insurance_programs.InsuranceProgram;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * <h1>class InsuranceCatalog</h1>
 *
 * Class that acts as a data structure for keeping offers of insurance_pac programs
 * It also has methods that allows you to access it
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class InsuranceCatalog implements Serializable {

    private ArrayList <InsuranceProgram> catalog;

    //Constructors

    /**
     * Class constructor that initialise inner arraylist that acts as a catalog
     */
    public InsuranceCatalog() {
        this(new ArrayList<InsuranceProgram>());
    }

    /**
     * Class constructor that assignees parameter to its inner array list
     * @param catalog
     */
    public InsuranceCatalog(ArrayList <InsuranceProgram> catalog) {
        this.catalog = catalog;
    }

    //Mutators - methods

    /**
     * Allows you to add to offer catalog
     * @param newProgram InsuranceProgram one instance of a program
     */
    public void addToOfferCatalog(InsuranceProgram newProgram) {
         catalog.add(newProgram);
    }

    //Getters and Setters

    /**
     * gets offer catalog
     * @return catalog of offers
     */
    public ArrayList<? extends InsuranceProgram> getCatalog() {
        return catalog;
    }

    //       public void deleteFromOfferCatalog(int index) {
//        catalog.remove(index);
//    }
//
//    public void deleteFromOfferCatalog(InsuranceProgram program) {
//        catalog.remove(program);
//    }
//    public void setCatalog(ArrayList<InsuranceProgram> catalog) {
//        this.catalog = catalog;
//    }

}
