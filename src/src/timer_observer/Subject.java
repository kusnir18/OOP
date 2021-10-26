package src.timer_observer;

/**
 * <h1>interface Subject</h1>
 * It acts as a subject interface in observer pattern, that means it declares key functions as an addition to array list,
 * deletion from array list, and notifying its subjects when change occurs
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */


public interface Subject {

    void registerSubject   (Observer observer);
    void unregisterSubject (Observer observer);
    void notifyObserver();
    void notifyEnd();

}
