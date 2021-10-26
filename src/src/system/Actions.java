package src.system;

import src.controllers.shared_gettersAndSettres.SharedPlus;
import src.controllers.shared_gettersAndSettres.SharedPlusPlus;
import src.controllers.insurance_controllers.*;
import src.controllers.state_controllers.StateRegulationController;
import src.controllers.user_controllers.UserAdd;
import src.controllers.user_controllers.UserCheck;
import src.controllers.user_controllers.UsersChange;
import src.insurance_pac.InsuranceCompany;
import src.insurance_pac.StandardInsuranceCompany;
import src.insurance_pac.company_information.InsuranceInformation;
import src.insurance_pac.insurance_catalog.insurance_programs.RegularInsurance;
import src.users.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>cabstract class Actions</h1>
 *
 *  Abstract class of all logic. Controllers are often a parameter whose texFields or textViews are often altered.
 *  Here all logic is done.
 *
 *  extends AppExceptions
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public abstract class Actions extends AppExceptions {

    /**
     * Prints all insurances into TextArea with some other information such as index, name, number of programs and code of insurance
     * @param controller which has a method getDisplay (which accesses TextArea)
     */

    public void printAllInsuranceCompanies(SharedPlus controller){

        controller.getDisplay().clear();

        //for loop - responsible for printing
        int counter=0;
        for (InsuranceCompany i: controller.getState().getAllInsurance()) {
            controller.getDisplay().appendText("------\n");
            controller.getDisplay().appendText("Index of the insurance_pac company "+counter+"\n");
            controller.getDisplay().appendText("Name of the insurance_pac company: "+ i.getBillingInformation().getCompanyName()+"\n");
            controller.getDisplay().appendText("Number of insurance_pac programs: "+ i.getCatalog().getCatalog().size()+"\n");
            controller.getDisplay().appendText("code of insurance_pac: "+ i.getBillingInformation().getCode_ofInsurance());

            controller.getDisplay().appendText("\n");

            counter++;
        }
    }

    /**
     * Prints all users/ customers of a particular company
     * @param controller which has a method getDisplay (which accesses TextArea) and Textfield for index, for choosing a corresponding company
     */

    public void printAllUsersCompanies(SharedPlus controller){

        controller.getDisplay().clear();

        int counter = 0;
        for (Person i: controller.getState().getAllCitizens()) {

            controller.getDisplay().appendText("------\n");
            controller.getDisplay().appendText("Index: "+counter+"\n");
            controller.getDisplay().appendText("Full Name: "+ i.getMyPersonalInformation().getFullName()+"\n");

            //select what type is it
            if(i instanceof Kid){
                controller.getDisplay().appendText("Category: Kid"+"\n");
            } else if(i instanceof Youth){
                controller.getDisplay().appendText("Category: Youth"+"\n");
            }else if (i instanceof Mature){
                controller.getDisplay().appendText("Category: Mature"+"\n");
            }else if(i instanceof Senior){
                controller.getDisplay().appendText("Category: Senior"+"\n");
            }

            controller.getDisplay().appendText("Their insurance company: "+i.getYourInsuranceName()+"\n");
            controller.getDisplay().appendText("Their insurance company: "+i.getYourInsuranceProgram().getNameOfProgram()+"\n");

            controller.getDisplay().appendText("\n");
            counter++;
        }

    }

    /**
     * Prints all insurances into TextArea with some other information such as index, name, number of programs and code of insurance
     * @param controller which has a method getDisplay (which accesses TextArea)
     */

    public void printAllInsuranceCompanies(SharedPlusPlus controller){

        controller.getDisplay().clear();

        //for loop - responsible for printing
        int counter=0;
        for (InsuranceCompany i: controller.getState().getAllInsurance()) {
            controller.getDisplaySecond().appendText("------\n");
            controller.getDisplaySecond().appendText("Index of the insurance_pac company "+counter+"\n");
            controller.getDisplaySecond().appendText("Name of the insurance_pac company: "+ i.getBillingInformation().getCompanyName()+"\n");
            controller.getDisplaySecond().appendText("Number of insurance_pac programs: "+ i.getCatalog().getCatalog().size()+"\n");
            controller.getDisplay().appendText("code of insurance_pac: "+ i.getBillingInformation().getCode_ofInsurance());

            controller.getDisplaySecond().appendText("\n");

            counter++;
        }
    }

    /**
     * Allows to create and add new insurance program into, it takes extract inserted information from text fields and it creates insurance company from received name of the insurance and via recieved name of the program
     * @param controller which has Textfields with insurance name and insurance program name
     */
    public void createInsurance(InsuranceCreateC controller){
        //creates all necessary instances
        StandardInsuranceCompany insurance = new StandardInsuranceCompany();
        InsuranceInformation info = new InsuranceInformation();
        RegularInsurance program = new RegularInsurance();

        info.setCompanyName(""+controller.getTxtName().getText());
        program.setNameOfProgram(""+controller.getTxtProgram().getText());

        //fills the object with data
        insurance.setBillingInformation(info);
        insurance.getCatalog().addToOfferCatalog(program);

        (controller.getState()).addInsurance(insurance);
        insurance.getBillingInformation().setCode_ofInsurance(controller.getState().getAllInsurance().size()-1);

    }

    /**
     * Creates person and adds it to DataStorage, where it is added to arraylist and it also sets insurance and insurance program to default state option: to 0 index of a state program
     * @param controller that has Textfields dedicated for name of user and its category
     */

    public void createPerson(UserAdd controller) {

        PersonalInformation info = new PersonalInformation();
        info.setFullName(""+controller.getTxtFullName().getText());

        try {
            this.testTypeUserCreation(controller, info);
        }catch (NotATypeException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test whether input from textfield is correct. Whether text is parsable to int and whether int is in range 0-3.
     * @param controller that has Textfields dedicated for name of user and its category
     * @param info name of a user
     * @throws NotATypeException when input is incorrect char/ int is not in range 0-3
     */
    private void testTypeUserCreation(UserAdd controller, PersonalInformation info)throws NotATypeException {
        InsuredPerson user;
        if ((""+controller.getCategory().getText()).equals("0")){
            user= new Youth(info);
            user.changeInsurance(controller.getState().getOneInsurance(0)); //default is state insurance always on 0 index
            user.changeInsuranceProgram(0, controller.getState().getOneInsurance(0)); //default is program always on 0 index
            controller.getState().addCitizen(user);
            //System.out.println("RUN - 0");

        }else if ((""+controller.getCategory().getText()).equals("1")){
            user= new Mature(info);
            user.changeInsurance(controller.getState().getOneInsurance(0));//default is state insurance always on 0 index
            user.changeInsuranceProgram(0, controller.getState().getOneInsurance(0));//default is program always on 0 index
            controller.getState().addCitizen(user);
            //System.out.println("RUN - 1");

        }else if ((""+controller.getCategory().getText()).equals("2")){
            user= new Senior(info);
            user.changeInsurance(controller.getState().getOneInsurance(0));//default is state insurance always on 0 index
            user.changeInsuranceProgram(0, controller.getState().getOneInsurance(0));//default is program always on 0 index
            controller.getState().addCitizen(user);
            //System.out.println("RUN - 2");
        }else if ((""+controller.getCategory().getText()).equals("3")){
            user= new Kid(info);
            user.changeInsurance(controller.getState().getOneInsurance(0));//default is state insurance always on 0 index
            user.changeInsuranceProgram(0, controller.getState().getOneInsurance(0));//default is program always on 0 index
            controller.getState().addCitizen(user);
            //System.out.println("RUN - 2");
        }else {
            NotATypeException error = new NotATypeException("Only numbers from 0-3"); //not an option
            error.alertSend(controller);
            throw error;
        }
    }

    /**
     * Adds program to DataStorage and  it also test for correct input
     * @param controller that has Textfields dedicated for name of program and has correct specification by indexes which insurance company to change and which program
     */
    public void addProgram(InsuranceModify controller){
        try {
            this.testProgram(controller);
        }catch (ParsingException e1){
            System.out.println(e1.getMessage());
        }catch (NotInRangeException e2){
            System.out.println(e2.getMessage());
        }catch (Exception e){
        }

    }

    /**
     * Test for correct input, Does Textfields have a dedicated text field with name of program and has correct specification by indexes which insurance company to change and which program
     * @param controller
     * @throws NotInRangeException index of program from program catalog is out of range or insurance is out of range
     * @throws ParsingException when program excepts int index not a char
     */
    private void testProgram(InsuranceModify controller) throws NotInRangeException,ParsingException {

        int value =0;
        RegularInsurance program = new RegularInsurance();
        program.setNameOfProgram(""+controller.getTxtProgramName().getText());

        try {
            value = Integer.parseInt(controller.getIndex().getText());
        }catch (Exception e){

            ParsingException missing = new ParsingException("Input is not a whole number \n");
            missing.alertSend(controller);
            throw missing;
        }


        if((controller.getState().getAllInsurance().size() >= value) && (value >= 0) ){
            controller.getState().getOneInsurance(value).getCatalog().addToOfferCatalog(program);//
            return;
        }
        NotInRangeException missing = new NotInRangeException("That insurance_pac does not exist \n");
        missing.alertSend(controller);
        throw missing;
    }

    /**
     * Prints out offer catalog to corresponding TextArea, from correctly indexed insurnance company
     * @param controller which has a TextAreas for insurance display, and Textarea for offer catalog to display and TextField that is used for index (of type int which has to be in range)
     */
    public void printCatalog(InsuranceCatalogShow controller){

        int value=0;

        try {
            value = Integer.parseInt(controller.getTxtIndex().getText()); //test for correct input type

        }catch (Exception e){
            e.getMessage();
            return;
        }
        //test range
        try {
            controller.getDisplaySecond().appendText("insurance_pac company >>>"+controller.getState().getOneInsurance(value).getBillingInformation().getCompanyName()+"\n");
            controller.getDisplaySecond().appendText("insurance_pac programs: \n");
            controller.getDisplaySecond().appendText("\n");
        }catch (Exception e){
            ParsingException missing = new ParsingException("Out of range \n");
            missing.alertSend(controller);
            return;
        }

        //prints offer catalog
        controller.getState().getOneInsurance(value).getCatalog().getCatalog()
                .forEach(e -> controller.getDisplaySecond().appendText(e.getNameOfProgram() + "\n"));
    }

    /**
     * Prints offer catalog of indexed insurance company
     * @param controller it has to have three TextAreas with getters
     */
    public void printCatalogB(UsersChange controller){

        int value=0;

        try {
            value = Integer.parseInt(controller.getCompanyIndex().getText());

        }catch (Exception e){
            e.getMessage();
            return;
        }

        controller.getDisplayThird().appendText("insurance_pac company >>>"+controller.getState().getOneInsurance(value).getBillingInformation().getCompanyName()+"\n");
        controller.getDisplayThird().appendText("insurance_pac programs: \n");
        controller.getDisplayThird().appendText("\n");
//

        int[] counter = new int[]{0}; //it has to be an array other wise it does not work because int must not change within lambda expression
        //prints catalog also with indexs
        controller.getState().getOneInsurance(value).getCatalog().getCatalog().forEach(e -> {
            controller.getDisplayThird().appendText(""+counter[0]+"\n");
            controller.getDisplayThird().appendText(""+ e.getNameOfProgram()+"\n");

            counter[0]++;
        });
    }

    /**
     * Prints out to TextArea Users that belong to specific insurance company which is acces via index
     * RTTI is used here for display of type
     * @param controller has to have a TextAreas for display of information and it has to have TextField with integer value that is in range of arraylist
     */
    public void printCorrespondingUsers(InsuranceCustomerList controller){

        int value=0;

        try {
            value = Integer.parseInt(controller.getTxtIndex().getText());
        }catch (Exception e){
            return;
        }

        if(value<0 || value >= controller.getState().getAllInsurance().size()){
            return;
        }

        controller.getDisplaySecond().appendText("insurance_pac company >>>"+controller.getState().getOneInsurance(value).getBillingInformation().getCompanyName()+"\n");
        controller.getDisplaySecond().appendText("customers: \n");
        controller.getDisplaySecond().appendText("\n");

        int counter=0;
        for (Insured i: controller.getState().getOneInsurance(value).getRegister().getCustomerRegister()) {

            controller.getDisplaySecond().appendText(counter+"\n");
            controller.getDisplaySecond().appendText(""+ i.getMyPersonalInformation().getFullName()+"\n");

            if(i instanceof Kid){
                controller.getDisplaySecond().appendText("Category: Kid"+"\n");
            }else if(i instanceof Youth){
                controller.getDisplaySecond().appendText("Category: Youth"+"\n");
            }else if (i instanceof Mature){
                controller.getDisplaySecond().appendText("Category: Mature"+"\n");
            }else if(i instanceof Senior){
                controller.getDisplaySecond().appendText("Category: Senior"+"\n");
            }

            controller.getDisplaySecond().appendText("\n");
            counter++;
        }

    }

    /**
     * Picks user, picks insurance company, picks insurance program. Changes insurance company and insurance program to picked user. It changes insurance company via indexes and program via index too.
     * It is tested whether indexes are correct (e.g. not a negative number of char), it is safe to use.
     * If everything is in order it changes  Insurance and a program of indexed user
     * @param controller that has 3 TextAreas and 3 Textfields. 3 textfield are being used for extracting indexes and TextAreas for text display
     */
    public void confirmChange(UsersChange controller){

        int value1=-1;
        int value2=-1;
        int value3=-1;


        try {
            value1 = Integer.parseInt(controller.getUserIndex().getText());
            //System.out.println(""+value1);
        }catch (Exception e){
            e.getMessage();
            e.getCause();
            return;
        }
        try {
            value2 = Integer.parseInt(controller.getCompanyIndex().getText());
            //System.out.println(""+value2);
        }catch (Exception e){
            e.getMessage();
            e.getCause();
            return;
        }
        try {
            value3 = Integer.parseInt(controller.getProgramIndex().getText());
            //System.out.println(""+value3);
        }catch (Exception e){
            e.getMessage();
            e.getCause();
            return;
        }


        if(value1 == -1 || value2 == -1 || value3 == -1){
            System.out.println("end---1");
            return;
        }


        Person person = controller.getState().getOneCitizens(value1);

        int oldInsurance = person.getYourInsuranceCompanyID();


        InsuranceCompany insuranceCompany = controller.getState().getOneInsurance(value2);
        System.out.println("Insurance company ::: selected:::"+insuranceCompany.getBillingInformation().getCompanyName());
        System.out.println("previous "  + person.getYourInsuranceCompanyID());
        controller.getState().getOneInsurance(person.getYourInsuranceCompanyID()).getBillingInformation().getCode_ofInsurance();

        person.signOffInsurance(controller.getState().getOneInsurance(oldInsurance));
        person.changeInsurance(insuranceCompany);
       // person.se

        if(person instanceof UnderAged){
            return;
        }
        person.changeInsuranceProgram(value3, insuranceCompany);

    }

    /**
     * Checks whether inserted name do exist in DataStorage
     * @param controller which has a textfield for name of insurance and with corresponding getter
     */

    public void insuranceExistCheck(InsuranceCheck controller){
        String inputName = controller.getTextField().getText();

        List<String> names = controller.getState().getAllInsurance().stream().map(c -> c.getBillingInformation().getCompanyName()).collect(Collectors.toList());
        boolean contains = names.stream().anyMatch(inputName::equals);

        if(contains){
            controller.getTextField().setText("It exists");
        }else{
            controller.getTextField().setText("It does not exist yet");
        }
    }

    /**
     * Extracts information from input textfields and alters regulations, by changing fee values
     * @param controller StateRegulationController which has three textfields that inputs int
     */
    public void extractRegulations(StateRegulationController controller){

        //test for correct input
        try {
            controller.getState().getRegulations().setInsuranceMinimum(Integer.parseInt(controller.getTxtMin().getText()));
            //System.out.println(""+value1);
        }catch (Exception e){
            e.getMessage();
            e.getCause();
            return;
        }

        try {
            controller.getState().getRegulations().setInsuranceMinimum(Integer.parseInt(controller.getTxtMid().getText()));
            //System.out.println(""+value2);
        }catch (Exception e){
            e.getMessage();
            e.getCause();
            return;
        }
        try {
            controller.getState().getRegulations().setInsuranceMinimum(Integer.parseInt(controller.getTxtMax().getText()));
            //System.out.println(""+value3);
        }catch (Exception e){
            e.getMessage();
            e.getCause();
            return;
        }
        //sets fee values and actualise it inside state insurances
        int value;
        for (InsuranceCompany company: controller.getState().getAllInsurance()){
            value = company.setRegulations(controller.getState().getRegulations());
        }
    }

    /**
     * Checks whether inserted name do exist in DataStorage
     * @param controller which has a textfield for name and corresponding getter
     */
    public void userExistCheck(UserCheck controller){
        String inputName = controller.getTextField().getText();

        List<String> names = controller.getState().getAllCitizens().stream().map(c -> c.getMyPersonalInformation().getFullName()).collect(Collectors.toList());
        boolean contains = names.stream().anyMatch(inputName::equals);

        if(contains){
            controller.getTextField().setText("It exists");
        }else{
            controller.getTextField().setText("It does not exist yet");
        }

    }

}
