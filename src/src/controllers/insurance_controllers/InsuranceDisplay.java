package src.controllers.insurance_controllers;

import src.controllers.back_to_controllers.BackToInsuranceChoice;
import src.controllers.shared_gettersAndSettres.SharedPlus;
import javafx.fxml.FXML;

/**
 * <h1>class InsuranceDisplay</h1>
 * Allows you to display into TextArea all insurance companies
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */
public class InsuranceDisplay extends SharedPlus {

    /**
     *Changes scene to InsuranceChoiceScene scene
     */
    @FXML
    public void actionHome(){
        try {
            (new BackToInsuranceChoice()).returnToInsuranceChoice(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays all insurance companies to TextArea
     */
    @FXML
    public void actionRefresh(){
        getState().printAllInsuranceCompanies(this);
    }
}
