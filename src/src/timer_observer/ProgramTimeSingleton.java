package src.timer_observer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h1>class ProgramTimeSingleton</h1>
 * This class is used as timer, it runs on its own thread and  is counts time in seconds. It is a singleton and it is used in observer
 * pattern as an subject which is responsible for actualisation of information, in this case lable which shows time
 * Each second it notifies observers, and when 30 SECONDS passes and it is in main menu or also known as welcome screen it closes the program.
 * In other words when user of a program is in active for 30 seconds it closes program. But he must be only in welcome screen other wise timer does no change.
 * On top of that it also shows you time in welcomescreenScene which is de facto main menu of a program
 *
 * extends  Thread implements Subject, Serializable
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public class ProgramTimeSingleton extends  Thread implements Subject, Serializable {

    private long runningTime;
    private boolean pause;
    private boolean change;
    private ArrayList<Observer> observers;

    private static ProgramTimeSingleton ourInstance = new ProgramTimeSingleton();

    /**
     * It returns singleton instance which  is one  of a kind
     * @return
     */
    public static ProgramTimeSingleton getInstance() {
        return ourInstance;
    }

    /**
     * It is a class constructor it initialise its agragated object, array list of observers
     */
    private ProgramTimeSingleton() {
        this.runningTime = 0L;
        observers = new ArrayList<Observer>();
    }

    /**
     * Run method which is started by .start() method it runs as long as it does not count to 30 seconds or until the program is stopped.
     * It sleeps for one second.
     * If change field is false nothing happens.
     * If change field is true it allows counting to 30 seconds.
     * And it aso notifies its observers about occurred change only if field "change = true".
     */
    public void run(){
        pause=false;
        change=true;
        while(!pause){
            //System.out.println("running");
            if (change){
                this.update();
                if(runningTime==30L){
                    this.notifyEnd();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }

    }

    /**
     * Stops the run method, and by that it stops threat for good
     * It is used when program ends, in order to stop thread/timer running
     */
    public void halt(){
        pause = true;
    }

    /**
     * Increments timer (field that tracks time which is within this class) by one.
     */
    public void update() {
        System.out.println("" + runningTime++);
        this.getInstance().notifyObserver();
        //System.out.println("update");
    }

    /**
     * Allows registration of new observers into the array list
     * @param observer is an instance which will be added to array list of observers whose are regularly notified
     */
    @Override
    public void registerSubject(Observer observer) {
        observers.add(observer);
        //System.out.println("hura registroval");
    }

    /**
     * Allows deletion of observers from the array list
     * @param observer specifies which observer to delete
     */
    @Override
    public void unregisterSubject(Observer observer) {
        int inde = observers.indexOf(observer);
        observers.remove(inde);
    }

    @Override
    public void notifyObserver() {
        //System.out.println("Notified one");
        for (Observer observer: observers) {
            observer.update(runningTime);
            //System.out.println("Notified");
        }
    }

    /**
     *
     */
    public void notifyEnd() {
        for (Observer observer: observers) {
            observer.halt();
        }
        this.halt();
    }

    /**
     * Changes value of variable change to FALSE, which occurs in run method. When this method  allowChange is run it bans changes to occur within run method.
     * In other words it does not allow observer to notify its observers.
     * Furthermore it sets timer (field that tracks time) back to zero
     */
    public void stopChange(){
        change=false;
        this.runningTime = 0L;
    }

    /**
     * Changes value of variable change to TRUE, which occurs in run method. When this method  allowChange is run it allows changes to occur within run method.
     * In other words it allows observer to notify its observers.
     */
    public void allowChange(){
        change=true;
    }

}
