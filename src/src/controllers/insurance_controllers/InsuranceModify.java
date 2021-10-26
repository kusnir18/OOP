package src.controllers.insurance_controllers;

import javafx.scene.control.Alert;
import src.controllers.back_to_controllers.BackToInsuranceChoice;
import src.controllers.shared_gettersAndSettres.SharedPlus;
import src.controllers.back_to_controllers.BackToInsuranceModify;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * <h1>class  InsuranceModify</h1>
 *
 * Allows you to add insurance programs and change scenes to insuranceChoice scene
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */
public class InsuranceModify extends SharedPlus {

    @FXML
    TextField index;

    @FXML
    TextField txtProgramName;

    public TextField getIndex() {
        return index;
    }

    public TextField getTxtProgramName() {
        return txtProgramName;
    }

    /**
     * performs addition of a new insurance program and stays on current scene
     */
    @FXML
    public void addContinue() throws Exception{
        getState().addProgram(this);
        (new BackToInsuranceModify()).returnToInsureModify(this);
    }

    /**
     * performs addition of a new insurance program and changes scene to insuranceChoiceScene
     */
    @FXML
    public void addReturn(){
        getState().addProgram(this);
        try {
            (new BackToInsuranceChoice()).returnToInsuranceChoice(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Refresh displayed information based on value of an index from TextField  with an id: index
     */
    @FXML
    public void actionRefresh(){
        getState().printAllInsuranceCompanies(this);
    }

    /**
     *Changes scene to InsuranceChoiceScene scene
     */
    @FXML
    public void actionHome() {
        try {
            (new BackToInsuranceChoice()).returnToInsuranceChoice(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Pops up alert window with corresponding message
     * @param text text which will be shown on alert
     */
    public void errorMessage(String text){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText(""+text);

        alert.showAndWait();
    }
}
