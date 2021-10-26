package src.controllers.shared_gettersAndSettres;

import javafx.scene.control.TextArea;

/**
 * <h1>class SharedPlusPlus</h1>
 * Class that holds shared getters and setters across controllers
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */


public abstract class SharedPlusPlus extends SharedPlus{

    @Override
    public TextArea getDisplay() {
        return display;
    }

    public abstract TextArea getDisplaySecond();

    public abstract TextArea getDisplayThird();

}
