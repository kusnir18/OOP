package src.system;

import src.controllers.insurance_controllers.InsuranceCatalogShow;
import src.controllers.insurance_controllers.InsuranceCreateC;
import src.controllers.insurance_controllers.InsuranceModify;
import src.controllers.user_controllers.UserAdd;

/**
 * <h1>abstract class AppExceptions</h1>
 *
 * Class composed of nested classes, those classes are custom exceptions. Each "subclass" or rather nested class has its own method.
 * It informs current controller (the one which belongs  to opened scene) about an exception via alert window.
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */

public abstract class AppExceptions {

    // EXCEPTION CLASSES
    /**
     *Instance of this class is created when user would go out of bound of Array list or he or she would enter negative value
     */
    class NotInRangeException extends Exception{

        private String message;

        /**
         * constructor of a class which takes text as an alert message
         * @param message text which will be displayed in alert window
         */
        public NotInRangeException(String message) {
            super(message);
            this.message=message;
        }

        /**
         * Notifies controller about occurred error via alert
         * @param controller controller which belongs to currently opened screen
         */
        public void alertSend(InsuranceModify controller){
            controller.errorMessage(""+this.getMessage());
        }
    }

    /**
     *Instance of this class is created when user enters wrong type (e.g. char instead of int)
     */
    class NotATypeException extends Exception{

        /**
         * constructor of a class which takes text as an alert message
         * @param message text which will be displayed in alert window
         */
        public NotATypeException(String message) {
            super(message);
        }

        /**
         * Notifies controller about occurred error via alert
         * @param controller controller which belongs to currently opened screen
         */
        public void alertSend(UserAdd controller){
            controller.errorMessage(""+this.getMessage());
        }
    }

    /**
     *Instance of this class is created when text is un-parsable
     */
    class ParsingException extends Exception{

        /**
         * constructor of a class which takes text as an alert message
         * @param message text which will be displayed in alert window
         */
        public ParsingException(String message) {
            super(message);
        }

        /**
         * Notifies controller about occurred error via alert
         * @param controller controller which belongs to currently opened screen
         */
        public void alertSend(InsuranceModify controller){
            controller.errorMessage(""+this.getMessage());
        }
        /**
         * Notifies controller about occurred error via alert
         * @param controller controller which belongs to currently opened screen
         */
        public void alertSend(InsuranceCatalogShow controller){
            controller.errorMessage(""+this.getMessage());
        }
    }

}
