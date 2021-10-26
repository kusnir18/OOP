package src.system;

import src.insurance_pac.InsuranceCompany;
import src.users.Person;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h1>DataStoragen class</h1>
 *
 * Acts as an core of a program, it holds ArrayLists of instances. All data regarding key logic is here.
 *
 * {@code
 *     private ArrayList<Person> allCitizens;
 *     private ArrayList <InsuranceCompany>  allInsurance;
 * }
 * It allows programmer for an easy data access.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class DataStorage extends Actions implements Serializable, Runnable {

    private ArrayList<Person> allCitizens;
    private ArrayList <InsuranceCompany>  allInsurance;
    private StateRegulations regulations;

    //private ProgramTime Runtime;
    //private ProgramTime runTime;


    /**
     * Constructor that sets default values and initialise ArrayLists
     * {@code
     *   allCitizens = new ArrayList<Person>();
     *   allInsurance = new ArrayList<InsuranceCompany>();
     *   regulations = new StateRegulations();
     * }
     */
    public DataStorage(){
        allCitizens = new ArrayList<Person>();
        allInsurance = new ArrayList<InsuranceCompany>();
        regulations = new StateRegulations();
    }
    /*
    public ProgramTime getRunTime() {
        return runTime;
    }*/

    //ADDING ONE UNIT

    /**
     * Method that adds citizen to Arraylist
     * @param person Person
     */
    public void addCitizen(Person person) {
        allCitizens.add(person);
    }

    /**
     * Method that adds insurance_pac to Arraylist
     * @param insurance InsuranceCompany
     */
    public void addInsurance(InsuranceCompany insurance) {
        allInsurance.add(insurance);
    }

    /**
     *Allows you to access one instance of citizen/user by index
     * @param index int
     * @return Person
     */
    public Person getOneCitizens(int index) {
        return allCitizens.get(index);
    }

    /**
     *Allows you to access one instance of insurance_pac by index
     * @param index int
     * @return Insurance
     */
    public InsuranceCompany getOneInsurance(int index) {
        return allInsurance.get(index);
    }

    //get and set all
    /**
     *Allows you to access whole ArrayList
     * @return allCitizens ArrayList<Person>
     */
    public ArrayList<Person> getAllCitizens() {
        return allCitizens;
    }

    /**
     *Allows you to access whole ArrayList
     * @return allInsurance ArrayList<InsuranceCompany>
     */
    public ArrayList<InsuranceCompany> getAllInsurance() {
        return allInsurance;
    }

    /**
     *Allows you to state regulations fees
     * @return regulations
     */
    public StateRegulations getRegulations() {
        return regulations;
    }

/*    public void setRegulations(StateRegulations regulations) {
        this.regulations = regulations;
    }*/

    @Override
    public void run() {
        while(1==1){}
    }

/*    public ProgramTime getRuntime() {
        return Runtime;
    }

    public void setRuntime(ProgramTime runtime) {
        Runtime = runtime;
    }*/
}


/*    //REMOVING ONE UNIT
    public void removeInsurance(int index) {
        allInsurance.remove(index);
    }
    public void removeCitizen(int index) {
        allCitizens.remove(index);
    }*/


/*    public void setAllCitizens(ArrayList<Person> allCitizens) {
        this.allCitizens = allCitizens;
    }

    public void setAllInsurance(ArrayList<InsuranceCompany> allInsurance) {
        this.allInsurance = allInsurance;
    }*/

