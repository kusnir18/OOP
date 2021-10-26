package src.controllers.back_to_controllers;

import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.WelcomeControl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * <h1>class BackToWelcome</h1>
 *
 *  Has only constructor. It just opens Insurance modify scene
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class BackToWelcome {

    /**
     * switches to WelcomeScene, with some parameters such as width, height which are fixed
     * it passes current state object to next scene
     * @param controller
     * @throws Exception
     */

    public void returnToWelcome(Shared controller) throws Exception{

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/WelcomeScene.fxml"));
        Parent parent = load.load();
        Scene scene = new Scene(parent, 600, 400);
        controller.getStage().setScene(scene);
        ((WelcomeControl) load.getController()).setStage(controller.getStage(), controller.getState());
    }

}
