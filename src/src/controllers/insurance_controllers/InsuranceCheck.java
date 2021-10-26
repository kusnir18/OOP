package src.controllers.insurance_controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.back_to_controllers.BackToInsuranceChoice;

/**
 * <h1>class InsuranceCheck</h1>
 * Allows you to check the name of potential  name of insurance, whether it is already used
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class InsuranceCheck extends Shared {

    @FXML
    TextField textField;
    @FXML
    Label txtLabel;

    public TextField getTextField() {
        return textField;
    }

    /**
     *Provides name check, by passing controller to logic where data is extracted from input fields
     */
    @FXML
    public void check(){
        getState().insuranceExistCheck(this);
    }

    /**
     *Changes scene to InsuranceChoiceScene
     */
    @FXML
    public void goHome(){
        try {
            (new BackToInsuranceChoice()).returnToInsuranceChoice(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
