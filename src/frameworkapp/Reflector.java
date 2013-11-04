/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alessandra
 */
public class Reflector {

    Constructor[] getConstructor(String string) {

            // Ottengo il riferimento alla Classe di interesse
            Class c = null;
        try {
            c = Class.forName(string);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reflector.class.getName()).log(Level.SEVERE, null, ex);
        }

            // Acquisisco la lista dei costruttori
            Constructor listaCostruttori[] = c.getConstructors();
            System.out.println("Numero Costruttori: " + listaCostruttori.length);

            // Stampo a video i dettagli di ciascun costruttore
            for (int i = 0; i < listaCostruttori.length; i++) {
                String fullDesc = listaCostruttori[i].toString();
                System.out.println("Costruttore n." + (i + 1) + ": " + fullDesc);
                Class tipiParam[] = listaCostruttori[i].getParameterTypes();
                if (tipiParam.length == 0) {
                    System.out.println("Nessun Parametro!");
                    continue;
                }
                System.out.println("Parametri: ");
                for (int j = 0; j < tipiParam.length; j++) {
                    System.out.println(tipiParam[j].getName());
                }

            } 
        return listaCostruttori;
            

        
    }
    

}
