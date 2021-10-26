package src.controllers.insurance_controllers;

import javafx.scene.control.Alert;
import src.controllers.back_to_controllers.BackToInsuranceChoice;
import src.controllers.shared_gettersAndSettres.SharedPlus;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * <h1>class  InsuranceCatalogShow</h1>
 *
 * Allows user to communicate with giu
 * Enables user to do actions based on what do they click on,- buttons
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class InsuranceCatalogShow extends SharedPlus {

    @FXML
    TextArea display;

    @FXML
    TextArea displaySecond;

    @FXML
    TextField txtIndex;

    /**
     * gets TextField
     * @return TextField
     */
    public TextField getTxtIndex() {
        return txtIndex;
    }

    /**
     * Gets (display) TextArea
     * @return TextArea
     */
    @Override
    public TextArea getDisplay() {
        return display;
    }

    /**
     * Gets displaySecond
     * @return TextArea
     */
    public TextArea getDisplaySecond() {
        return displaySecond;
    }

    /**
     * access state object and prints all Insurance companies on display
     */
    @FXML
    public void actionRefresh() {
        getState().printAllInsuranceCompanies(this);
    }

    /**
     * Change scenes to InsuranceChoiceScene
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
     * Prints catalog to a display
     */
    @FXML
    public void actionShow(){
        getState().printCatalog(this);
    }


    /**
     * Pops up alert window with corresponding message
     * @param text text which will be shown on alert
     */
    public void errorMessage(String text){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText(""+text);

        alert.showAndWait();
    }

}
