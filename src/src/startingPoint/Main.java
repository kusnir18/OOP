package src.startingPoint;

import src.controllers.BuildBeginning;
import javafx.application.Application;
import javafx.stage.Stage;
import src.timer_observer.ProgramTimeSingleton;
import src.system.CreateStateInsurance;
import src.system.DataStorage;

/**
 * <h1>class Main</h1>
 * This is a starting point of a program.
 * It starts eHealth program with gui.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class Main extends Application{

    private DataStorage state;

    /**
     * main function acts as a beginning
     * @param args
     */
    public static void main(String [] args){
        launch(args);
    }

    /**
     * method start creates gui
     * and also a logic of program eHealth
     * @param primaryStage
     * primaryStage Stage
     */

    @Override
    public void start(Stage primaryStage){

        state = new DataStorage();
        new CreateStateInsurance().stateInsurance(state);
        ProgramTimeSingleton o = ProgramTimeSingleton.getInstance();
        o.start();
        try {
            new BuildBeginning(primaryStage, state);
        }catch (Exception e){

            e.toString();


            System.out.println("Fatal error, program failed to start");
        }
    }

    /**
     * It overrides stop in order to stop timer when program ends.
     * @throws Exception such as in method stop
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        ProgramTimeSingleton.getInstance().halt();
    }

}