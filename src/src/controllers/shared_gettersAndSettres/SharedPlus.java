package src.controllers.shared_gettersAndSettres;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * <h1>class SharedPlus</h1>
 * Class that holds shared getters and setters across controllers
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public abstract class SharedPlus extends Shared implements PossesDisplay{

    @FXML
    TextArea display;

    @Override
    public TextArea getDisplay() {
        return display;
    }

    @Override
    public void setDisplay(TextArea display) {
        this.display = display;
    }

}
