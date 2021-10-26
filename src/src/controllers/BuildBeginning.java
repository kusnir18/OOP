package src.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.system.DataStorage;

import java.io.IOException;

/**
 * <h1>class BuildBeginning</h1>
 * Builds first scene from scratch. Sets parameters such as width and height.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class BuildBeginning {

    /**
     * Constructor that builds first scene of the program
     * @param primaryStage place where scene is built
     * @param state data object
     */
    public BuildBeginning(Stage primaryStage, DataStorage state){

        FXMLLoader load= new FXMLLoader(getClass().getResource("/src/gui/WelcomeScene.fxml"));
        Parent parent = null;
        try {
            parent = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(parent, 600, 400);

        ((WelcomeControl) load.getController()).setStage(primaryStage, state);

        primaryStage.setTitle("eHealth");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
