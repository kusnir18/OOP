package src.serialisation;

import src.system.DataStorage;

import java.io.*;
/**
 * <h1>class Serial</h1>
 * Serialise and deserialize DataStorage object
 *
 * @author  Maros Kusnir
 * @version 1.0
 * @since   2019
 */
public class Serial {

    /**
     * It serialise data which are thrown into the parameter into file on your computer. Access mentioned file, writes data in and closes it when its done.
     * @param data is a object which will be serialised to "my_precious.data"
     * @throws SerialisationException which is custom exception which is thrown when data is serialised
     */
    public void serialise(DataStorage data) throws SerialisationException {

        DataStorage d = data;
        //d.getRuntime().halt();

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("my_precious.data"));
            out.writeObject(d);
            out.close();
        } catch (IOException e) {
            throw new SerialisationException();
        }

       // d.getRuntime().haltPause();
    }

    /**
     * It deserialize data which are saved in "my_precious.data" on your computer. Accesses mentioned file, deserialize content to DataStorage object
     * closes route when it is done and returns it back
     * @param data
     * @return DataStorage which is contains program and data
     * @throws Exception thrown when data is deserialize and error occurred
     */
    public DataStorage deserialise(DataStorage data) throws Exception{


        ObjectInputStream in = new ObjectInputStream(new FileInputStream("my_precious.data"));
        DataStorage extract = (DataStorage)in.readObject();


        in.close();

        return extract;
    }

    /**
     * Exception with a custom message, which is thrown when error regarding serialisation occurs
     */
    class SerialisationException extends IOException{

        public String toString() {
            return "SerialisationException";
        }
    }

    /**
     * Exception with a custom message, which is thrown when error regarding deserialization occurs
     */
    class DeserialisationException extends IOException{
        public String toString() {
            return "The program did not load data";
        }
    }

}