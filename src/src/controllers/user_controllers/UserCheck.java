package src.controllers.user_controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.back_to_controllers.BackToUserChoice;

/**
 * <h1>class UserCheck</h1>
 * Allows you to check the name of potential name for the person, whether it is used
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class UserCheck extends Shared {

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
        getState().userExistCheck(this);
    }

    /**
     * Change scene to UserChoiceScene scene
     * @throws Exception
     */
    @FXML
    public void goHome() throws Exception{
        (new BackToUserChoice()).returnToUserChoice(this);
    }


}