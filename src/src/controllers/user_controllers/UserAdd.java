package src.controllers.user_controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.back_to_controllers.BackToUserChoice;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * <h1>class UserAdd</h1>
 * Allows you to add people to the system.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class UserAdd extends Shared {

    @FXML
    TextField txtFullName;
    @FXML
    TextField category;
    @FXML
    Button btnFinishReg;

    public TextField getTxtFullName() {
        return txtFullName;
    }

    public TextField getCategory() {
        return category;
    }

    /**
     * initilise action when btnFinishReg is presses - person is added to the system and scene is change to UserChoiceScene
     */
    public void initialize(){
        btnFinishReg.setOnAction(e -> {
            try {
                this.getState().createPerson(this);//
                (new BackToUserChoice()).returnToUserChoice(this);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    /**
     * Pops up alert window with corresponding message
     * @param text text which will be shown on alert
     */
    public void errorMessage(String text){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText(""+text);

        alert.showAndWait();
    }
}

//Thrash code:
/*    @FXML
    public void actionCreatePerson() throws Exception{

        getState().createPerson(this);
        (new BackToUserChoice()).returnToUserChoice(this);
    }*/
