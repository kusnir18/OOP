package src.controllers.back_to_controllers;

import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.user_controllers.UserChoice;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * <h1>class BackToUserChoice</h1>
 *
 *  It has only constructor. It just opens UserChoiceScene
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class BackToUserChoice {

    /**
     * switches to UserChoiceScene, with some parameters such as width, height which are fixed
     * it passes current state object to next scene
     * @param controller
     * @throws Exception
     */

    public void returnToUserChoice(Shared controller) throws Exception{

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/user_scenes/UserChoiceScene.fxml"));
        Parent parent = load.load();
        Scene scene = new Scene(parent, 600, 400);
        controller.getStage().setScene(scene);
        ((UserChoice) load.getController()).setStage(controller.getStage(), controller.getState());
    }
}
