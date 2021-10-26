package src.controllers.insurance_controllers;

import src.controllers.back_to_controllers.BackToInsuranceModify;
import src.controllers.back_to_controllers.BackToWelcome;
import src.controllers.shared_gettersAndSettres.Shared;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * <h1>class InsuranceChoice</h1>
 *
 * Allows you to select from actions/buttons regarding insurance operations
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class InsuranceChoice extends Shared {

    /**
     *Changes scene to InsuranceCreateScene
     */
    @FXML
    public void actionCreateInsurance() {

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/insurance_scenes/InsuranceCreateScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((InsuranceCreateC) load.getController()).setStage(this.getStage(), this.getState());
    }

    /**
     *Changes scene to InsurancesDisplayScene
     */
    @FXML
    public void actionDisplayCmp() {

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
     *Changes scene to InsuranceModifyScene
     */
    @FXML
    public void actionInsuranceCatalog() {
        try {
            (new BackToInsuranceModify()).returnToInsureModify(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Changes scene to InsuranceUsersScene
     */

    @FXML
    public void actionCustomers() {

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/insurance_scenes/InsuranceUsersScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((InsuranceCustomerList) load.getController()).setStage(this.getStage(), this.getState());
    }

    /**
     *Changes scene to WelcomeScene
     */
    @FXML
    public void actionMenu() {
        try {
            (new BackToWelcome()).returnToWelcome(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Changes scene to InsuranceExistScene
     */
    @FXML
    public void actionCheck() {
        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/insurance_scenes/InsuranceExistScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((InsuranceCheck) load.getController()).setStage(this.getStage(), this.getState());
    }

    /**
     *Changes scene to InsuranceCatalogScene
     */
    @FXML
    public void actionCatalog() {
        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/insurance_scenes/InsuranceCatalogScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((InsuranceCatalogShow) load.getController()).setStage(this.getStage(), this.getState());
    }

}
