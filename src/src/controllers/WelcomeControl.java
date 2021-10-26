package src.controllers;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import src.controllers.back_to_controllers.BackToInsuranceChoice;
import src.controllers.back_to_controllers.BackToUserChoice;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import src.controllers.shared_gettersAndSettres.Shared;
import src.controllers.state_controllers.StateChoiceController;
import src.timer_observer.Observer;
import src.timer_observer.ProgramTimeSingleton;
import src.serialisation.Serial;

import java.io.IOException;

/**
 * <h1>class WelcomeControl</h1>
 * This is a welcome screen it act basically as a menu, it has multiple buttons. State, User and Insurance actions which takes you to next choice scene.
 * There are also another 2 buttons which allows you to load and deserialize data (btn Load) and Save button which allows you to save changes, which were performed
 *
 * This controller acts also as an observer, it is notified every second and value of label is hanged by that. If it hits 30 second then the programs end  without saved changes
 *
 * extends Shared implements Observer
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class WelcomeControl extends Shared implements Observer{

    @FXML
    Button btnCitizen;
    @FXML
    Button btnInsurance;
    @FXML
    Button btnState;
    @FXML
    Button btnSave;
    @FXML
    Button btnLoad;
    @FXML
    Label labelTime;


    public Label getLabelTime() {
        return labelTime;
    }


    /**
     * method that creates scene StateChoiceScene and hands over stage and state
     */
    @FXML
    private void actionState() {
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
     * initialise all button action are here
     *
     * load button - loads data and deserialise them from file, and resets timer that measure inactive time
     * save button - saves data and serialise them to file, and resets timer that measure inactive time
     * state button - opens state menu scene for state
     * user button - opens state menu scene for user
     * insurance button - opens state menu scene for insurance
     *
     */
    public void initialize(){

        btnLoad.setOnAction(e -> {      //button LOAD loads  data from file, and deserialize them
            try {
                ProgramTimeSingleton.getInstance().stopChange();
                ProgramTimeSingleton.getInstance().allowChange();

                setState((new Serial()).deserialise(getState()));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnSave.setOnAction(e -> {  //save button - saves data and serialise them to file, and resets timer that measure inactive time
            try {
                ProgramTimeSingleton.getInstance().stopChange();
                ProgramTimeSingleton.getInstance().allowChange();

                (new Serial()).serialise(getState());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnState.setOnAction(e-> {  //     * state button - opens state menu scene for state
            try {
                ProgramTimeSingleton.getInstance().stopChange();
                ProgramTimeSingleton.getInstance().unregisterSubject(this);

                this.actionState();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnInsurance.setOnAction(e -> {
            try {   //                    * insurance button - opens state menu scene for insurance
                ProgramTimeSingleton.getInstance().stopChange();
                ProgramTimeSingleton.getInstance().unregisterSubject(this);

                (new BackToInsuranceChoice()).returnToInsuranceChoice(this);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btnCitizen.setOnAction(e -> {   //     * user button - opens state menu scene for user
            try {
                ProgramTimeSingleton.getInstance().stopChange();
                ProgramTimeSingleton.getInstance().unregisterSubject(this);

                (new BackToUserChoice()).returnToUserChoice(this);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

    }


    /**
     * Class constructor, registers this controller to observer pattern
     * and allows subject in observer pattern to make changes
     */

    public WelcomeControl() {
        ProgramTimeSingleton.getInstance().registerSubject(this);
        ProgramTimeSingleton.getInstance().allowChange();
    }

    /**
     * Updates label by a new value
     * @param RunTime shows amount of seconds that have passes. Shows inactive time.
     */
    @Override
    public void update(long RunTime) {
        Platform.runLater(()->{
            this.getLabelTime().setText(""+ RunTime);
            //System.out.println("" + id+ ": " +time);
        });
    }

    /**
     * closes stage and end the program
     */
    @Override
    public void halt(){
        Platform.runLater(()->{
            this.getStage().close();
        });
    }

}
