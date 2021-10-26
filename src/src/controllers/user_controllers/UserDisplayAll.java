package src.controllers.user_controllers;

import javafx.scene.control.Button;
import src.controllers.shared_gettersAndSettres.SharedPlus;
import src.controllers.back_to_controllers.BackToUserChoice;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * <h1>class UserDisplayAll</h1>
 * Allows you to display all registered people from system to gui
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class UserDisplayAll extends SharedPlus {

    @FXML
    TextArea display;
    @FXML
    Button btnBack;
    @FXML
    Button btnShow;

    /**
     * Displays (btnShow) all registered people from system to gui or goes yo user choice scene when btnBack (button) is pressed
     */
    public void initialize(){
        btnShow.setOnAction(e -> getState().printAllUsersCompanies(this) );

        btnBack.setOnAction(e-> {
            try {
                (new BackToUserChoice()).returnToUserChoice(this);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

    }
}
