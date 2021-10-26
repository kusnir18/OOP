package src.insurance_pac.insurance_catalog.insurance_programs;

import src.system.StateRegulations;

import java.io.Serializable;

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

public class RegularInsurance implements InsuranceProgram, Serializable {
    private String nameOfProgram;

    private ContractInfo timeDetails;
    private StateRegulations regulations;

    /**
     * Default con
     */
    public RegularInsurance() { //just for src.testing
        this.nameOfProgram = "statna";
    }

    public RegularInsurance(String nameOfProgram) {
        this. regulations = regulations;
        this.nameOfProgram = "statna";
        timeDetails = new ContractInfo();

    }

    /**
     * Sets name of a program
     * @param nameOfProgram String
     */
    public void setNameOfProgram(String nameOfProgram) {
        this.nameOfProgram = nameOfProgram;
    }

    /**
     * gets name of a program
     * @return String
     */
    public String getNameOfProgram() {
        return nameOfProgram;
    }

    //    }
//        this.timeDetails = timeDetails;
//    public void setTimeDetais(ContractInfo timeDetails) {
//
//    }
//        this.nameOfProgram = nameOfProgram;
//    public RegularInsurance(String nameOfProgram) {
//    public RegularInsurance(StateRegulations regulations) {
//        this. regulations = regulations;
//        this.nameOfProgram = "statna";
//        timeDetails = new ContractInfo();
//
//    }
}
