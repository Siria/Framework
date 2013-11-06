/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 *
 * @author alessandra
 */
public class Item_ext implements Externalizable{
    private static final long serialVersionUID = 1;
    public String nome;
    public String descrizione;

    public Item_ext() {
        nome = "";
        descrizione = "";
    }

    public Item_ext(String n, String d) {
        nome = n;
        descrizione = d;
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

    @Override
    public void writeExternal(ObjectOutput oo) throws IOException {
        oo.writeObject(nome);
        oo.writeObject(":");
        oo.writeObject(descrizione);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException {
        nome = (String)oi.readObject();
        String tmp = (String)oi.readObject();
        descrizione = (String) oi.readObject();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
