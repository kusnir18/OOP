package src.controllers.insurance_controllers;

import src.controllers.back_to_controllers.BackToInsuranceChoice;
import src.controllers.shared_gettersAndSettres.Shared;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * <h1>class InsuranceCreateC</h1>
 * Allows you to Create new insurance company and it adds it to the ehealth system
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class InsuranceCreateC extends Shared {

    @FXML
    TextField txtName;
    @FXML
    TextField txtProgram;

    public TextField getTxtName() {
        return txtName;
    }

    public TextField getTxtProgram() {
        return txtProgram;
    }

    /**Creates new company and it adds it to the ehealth system
     */
    @FXML
    public void actionBuildCompany(){
        getState().createInsurance(this);
        try {
            (new BackToInsuranceChoice()).returnToInsuranceChoice(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
