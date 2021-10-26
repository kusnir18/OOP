package src.controllers.state_controllers;

import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.back_to_controllers.BackToWelcome;
import src.controllers.insurance_controllers.InsuranceDisplay;
import src.controllers.user_controllers.UserDisplayAll;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * <h1>class StateChoiceController</h1>
 * Allows user to choose from buttons/ which run methods
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class StateChoiceController extends Shared {

    /**
     *Change scene to InsurancesDisplayScene scene
     */
    @FXML
    public void actionAllInsurance(){

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/insurance_scenes/InsurancesDisplayScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((InsuranceDisplay) load.getController()).setStage(this.getStage(), this.getState());

    }

    /**
     *Change scene to UserDisplayAllScene scene
     */
    @FXML
    public void actionAllCitizien() {
        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/user_scenes/UserDisplayAllScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((UserDisplayAll) load.getController()).setStage(this.getStage(), this.getState());
    }

    /**
     *Change scene to WelcomeScene scene
     */
    @FXML
    public void actionHome() throws Exception{
        new BackToWelcome().returnToWelcome(this);
    }

    /**
     *Change scene to StateRegScene scene
     */
    @FXML
    public void progressiveRaise() throws Exception{
        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/state_scenes/StateRegScene.fxml"));
        Parent parent = load.load();
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((StateRegulationController) load.getController()).setStage(this.getStage(), this.getState());

    }
}
