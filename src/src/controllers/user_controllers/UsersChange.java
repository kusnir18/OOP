package src.controllers.user_controllers;

import javafx.scene.control.Button;
import src.controllers.shared_gettersAndSettres.SharedPlusPlus;
import src.controllers.back_to_controllers.BackToUserChoice;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * <h1>class UsersChange</h1>
 * Allows you to change insurance program and insurance company at once
 * You can select also the same company or even the came program if you want.
 *
 * This controller has TextFields for indexes and TextAreas for text display
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class UsersChange extends SharedPlusPlus {

    @FXML
    TextField userIndex;
    @FXML
    TextField companyIndex;
    @FXML
    TextField programIndex;

    @FXML
    TextArea display;
    @FXML
    TextArea displaySecond;
    @FXML
    TextArea displayThird;

    @FXML
    Button btnUserRefresh;
    @FXML
    Button btnRefreshCompanies;
    @FXML
    Button btnRefreshPrograms;

    public TextField getUserIndex() {
        return userIndex;
    }
    public TextField getCompanyIndex() {
        return companyIndex;
    }
    public TextField getProgramIndex() {
        return programIndex;
    }

    @Override
    public TextArea getDisplaySecond() {
        return displaySecond;
    }
    @Override
    public TextArea getDisplayThird() {
        return displayThird;
    }

    /**
     * Changes scene to UserChoiceScene and perform change of insurance and insurance program
     */
    @FXML
    private void confirmChange() {
        getState().confirmChange(this);
        try {
            (new BackToUserChoice()).returnToUserChoice(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes scene to UserChoiceScene
     */
    @FXML
    private void actionHome() {
        try {
            (new BackToUserChoice()).returnToUserChoice(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * based on what button is pressed this method performs other methods from this class
     */
    public void initialize(){

        btnUserRefresh.setOnAction(e-> getState().printAllUsersCompanies(this));
        btnRefreshCompanies.setOnAction(e-> getState().printAllInsuranceCompanies(this));
        btnRefreshPrograms.setOnAction(e->  getState().printCatalogB(this));

    }
}