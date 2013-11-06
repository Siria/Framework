/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alessandra
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 1;
    public String nome;
    public String descrizione;

    public Item() {
        nome = "";
        descrizione = "";
    }

    public Item(String n, String d) {
        this.nome = n;
        this.descrizione = d;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean equals(Object o) {
        Item t = (Item) o;
        if ((t.getNome().equals(nome)) && (t.getDescrizione().equals(descrizione))) {
            return true;
        }
        return false;
    }
    public String toString(){
    return nome+":"+descrizione;
    }
//    //    public ObjectOutputStream write(Item item_w) throws FileNotFoundException, IOException {
//    public ByteArrayOutputStream writeObjectInputStream(ByteArrayOutputStream bytestream,Object obj, Class c) throws FileNotFoundException, IOException {
//
//        
//        ObjectOutputStream oos;
//        oos = new ObjectOutputStream(bytestream);
//        oos.writeObject(obj);
//        // controllare
//        //oos.writeObject(this);
//        oos.writeObject(c);
//        oos.close();
//        System.out.println("Write Done");
//        return bytestream;
//    }// fine metodo scrivi 
//
//    public ObjectInputStream readObjectInputStream(byte[] dati) throws FileNotFoundException, IOException, ClassNotFoundException {
//        
//        ByteArrayInputStream byteStream;
//        ObjectInputStream ois;
//        byteStream = new ByteArrayInputStream(dati);
//        ois = new ObjectInputStream(byteStream);
//        //item_r = (Item) (ois.readObject());
//        return ois;
//
//    }
}
