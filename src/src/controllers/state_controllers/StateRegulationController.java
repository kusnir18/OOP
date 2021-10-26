package src.controllers.state_controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import src.controllers.shared_gettersAndSettres.Shared;

import java.io.IOException;

/**
 * <h1>class StateRegulationController</h1>
 * Controls scene which allows user to fill fee limits, regulated by state.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */



public class StateRegulationController extends Shared {

    @FXML
    TextField txtMin;
    @FXML
    TextField txtMid;
    @FXML
    TextField txtMax;

    public TextField getTxtMin() {
        return txtMin;
    }

    public TextField getTxtMid() {
        return txtMid;
    }

    public TextField getTxtMax() {
        return txtMax;
    }

    /**
     * Opens StateChoiceScene scene
     */
    @FXML
    public void back(){

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/state_scenes/StateChoiceScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((StateChoiceController) load.getController()).setStage(this.getStage(), this.getState());
    }

    /**
     * Opens StateChoiceScene allows logic to change its regulations fees from input via getState().extractRegulations(this);
     */
    @FXML
    public void confirm(){

        getState().extractRegulations(this);

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/state_scenes/StateChoiceScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((StateChoiceController) load.getController()).setStage(this.getStage(), this.getState());
    }

}
