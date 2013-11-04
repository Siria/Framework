/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

import java.io.Serializable;

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
}
