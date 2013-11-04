/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alessandra
 */
public class Serializator implements Serializable {

    public ObjectOutputStream write(Item item_w) throws FileNotFoundException, IOException {

        FileOutputStream fos;
        ObjectOutputStream oos;
        fos = new FileOutputStream("dati.dat");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(item_w);
        oos.close();
        System.out.println("Write Done");
        return oos;
    }// fine metodo scrivi 

    public ObjectInputStream read(Item item_r) throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream fis;
        ObjectInputStream ois;
        fis = new FileInputStream("dati.dat");
        ois = new ObjectInputStream(fis);

        item_r = (Item) (ois.readObject());

        ois.close();
        return ois;


    }
}