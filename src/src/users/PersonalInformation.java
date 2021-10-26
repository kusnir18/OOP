package src.users;

import java.io.Serializable;
import java.util.Objects;

/**
 * <h1>Personal information class</h1>
 * Personal information class holds all personal information of user.
 * Furthermore it also posses getters and setters, which allows you to access these information.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 * @serial
 */

public class PersonalInformation implements Serializable {

    private String fullName;
    private String surname;

    private int age;
    private char sex;
    private long dateOfBirth; //YYYYMMDD
    private long birthNumber; // without '/'
    private String cityOfBirth;

    private String stateOfResidence;
    private String addressOfResidence;
    private String addressOfTemporaryResidence;

    private String idNumber;        ///// -1
    private long telephoneNumber;   ///// -1
    private Boolean maritalStatus;  ///// false

    /**
     * Constructor of class PersonalInformation
     * It assigns default values to fields;
     *
     * {@code
     *         this.idNumber= "";
     *         this.telephoneNumber= -1L;
     *         this.maritalStatus= false;
     *  }
     * */
    public PersonalInformation(){ //this is default state because children does not have those;
        this.idNumber= "";
        this.telephoneNumber= -1L;
        this.maritalStatus= false;
    }

    /**
     * Gets user's telephone number
     * @return long
     */
    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets user's telephone number
     * @param telephoneNumber
     * telephoneNumber user's telephone number
     */
    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Gets user's maritalStatus
     * true for married, false for not
     * @return Boolean
     */
    public Boolean getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets user's telephone number
     * @param maritalStatus
     * maritalStatus whether user is married T/F, <b>Boolean</b>
     */
    public void setMaritalStatus(Boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Gets user's age
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets user's age
     * @param age
     * age int; positive integer
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets user's fullName
     * @return String
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets user's fullName
     * @param fullName
     * fullName String
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets user's sex
     * @return char
     */
    public char getSex() {
        return sex;
    }

    /**
     * Sets user's sex
     * @param sex
     * sex char, beginning letter M for man W for woman
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * Gets user's getMaritalStatus
     * @return long, birthNumber
     */
    public long getBirthNumber() {
        return birthNumber;
    }

    /**
     * Sets user's birthNumber
     * @param birthNumber
     * birthNumber long
     */
    public void setBirthNumber(long birthNumber) {
        this.birthNumber = birthNumber;
    }


    /**
     * Overridden equals method so it matches objects by fullName
     * @param o
     * o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalInformation that = (PersonalInformation) o;
        return Objects.equals(fullName, that.fullName);
    }

    /**
     * Overridden hashCode method so it is suited for fullName
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
