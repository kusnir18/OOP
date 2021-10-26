package src.controllers.insurance_controllers;

import src.controllers.back_to_controllers.BackToInsuranceChoice;
import src.controllers.shared_gettersAndSettres.SharedPlus;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * <h1>class InsuranceCustomerList</h1>
 * Allows you to display customer list based by insurance company
 * By index you choose which one (insurance company)
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class InsuranceCustomerList extends SharedPlus {

    @FXML
    TextArea display;
    @FXML
    TextArea displaySecond;
    @FXML
    TextField txtIndex;

    @Override
    public TextArea getDisplay() {
        return display;
    }

    public TextArea getDisplaySecond() {
        return displaySecond;
    }

    public TextField getTxtIndex() {
        return txtIndex;
    }

    /**
     * Displays all companies to  TextArea display;
     */
    @FXML
    public void actionRefresh() {
        getState().printAllInsuranceCompanies(this);
    }

    /**
     * Changes scene to InsuranceChoiceScene
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
     * Refreshes user displayed based on index from TextField txtIndex; because users differ from insurance company to insurance company
     */
    @FXML
    public void actionRefreshUsers() {
        getState().printCorrespondingUsers(this);
    }
}
