package src.timer_observer;

/**
 * <h1>interface Observer</h1>
 * It acts as a observer interface in observer pattern, that means it observes subject about change.
 * It declares methods such as update which updates information taken from subject and it also has its halt method which is used when program closes due to subject.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public interface Observer {

    void update(long RunTime);
    void halt();
}
