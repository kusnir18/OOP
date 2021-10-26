package src.controllers.shared_gettersAndSettres;

import javafx.stage.Stage;
import src.system.DataStorage;

/**
 * <h1>class Shared</h1>
 * Class that holds shared getters and setters across controllers
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */
public abstract class Shared {

    private Stage stage;
    private DataStorage state;

    public void setStage(Stage stage, DataStorage state) {
        this.setState(state);
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public DataStorage getState() {
        return state;
    }

    public void setState(DataStorage state) {
        this.state = state;
    }
}
