package src.controllers.user_controllers;

import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.WelcomeControl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * <h1>class UserChoice</h1>
 * Allows you to select from actions/buttons regarding user operations
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class UserChoice extends Shared {

    @FXML
    Button btnAddPerson;
    @FXML
    Button btnList;
    @FXML
    Button btnChange;
    @FXML
    Button btnCheck;
    @FXML
    Button btnHome;

    /**
     *Changes scene to UserCreateScene
     */
    private void actionUser(){

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/user_scenes/UserCreateScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((UserAdd) load.getController()).setStage(this.getStage(), this.getState());
    }

    /**
     *Changes scene to UserDisplayAllScene
     */
    private void actionDisplay(){
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
     *Changes scene to UserChangeScene
     */
    private void actionChange(){
        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/user_scenes/UserChangeScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((UsersChange) load.getController()).setStage(this.getStage(), this.getState());

    }

    /**
     *Changes scene to UserExistScene
     */
    private void actionCheck(){
        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/user_scenes/UserExistScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((UserCheck) load.getController()).setStage(this.getStage(), this.getState());

    }

    /**
     *Changes scene to WelcomeScene
     */
    private void actionMenu(){

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/WelcomeScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent, 600, 400);
        this.getStage().setScene(scene);
        ((WelcomeControl) load.getController()).setStage(this.getStage(), this.getState());
    }

    /**
     * Performs methods defined in this class based on what button is pushed
     */
    public void initialize(){

        btnAddPerson.setOnAction(e -> {
            try {
                this.actionUser();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnList.setOnAction(e -> {
            try {
                this.actionDisplay();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnChange.setOnAction(e -> {
            try {
                this.actionChange();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnHome.setOnAction(e -> {
            try {
                this.actionMenu();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        btnCheck.setOnAction(e -> {
            try {
                this.actionCheck();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

}
