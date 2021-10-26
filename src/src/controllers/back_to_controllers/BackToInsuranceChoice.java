package src.controllers.back_to_controllers;

import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.insurance_controllers.InsuranceChoice;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * <h1>class BackToInsuranceChoice</h1>
 *
 *  Has only constructor. It just opens Insurance choice scene
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class BackToInsuranceChoice {

    /**
     * switches to Insurance choice scene, with some parameters such as width, height which are fixed
     *  it passes current state object to next scene
     * @param controller Shared
     * @throws Exception
     */
    public void returnToInsuranceChoice(Shared controller) throws Exception{

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/insurance_scenes/InsuranceChoiceScene.fxml"));
        Parent parent = load.load();
        Scene scene = new Scene(parent, 600, 400);
        controller.getStage().setScene(scene);
        ((InsuranceChoice) load.getController()).setStage(controller.getStage(), controller.getState());
    }

}
