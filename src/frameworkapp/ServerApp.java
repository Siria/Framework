/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
// import per implementare la Reflection
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

/**
 *
 * @author alessandra
 */
public class ServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        try {
            final int PORT = 6677;//SET NEW CONSTANT VARIABLE: PORT
            ServerSocket server = new ServerSocket(PORT); //SET PORT NUMBER
            System.out.println("Waiting for clients...");//AT THE START PRINT THIS

            while (true)//WHILE THE PROGRAM IS RUNNING
            {
                Socket s = server.accept();//ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT

                System.out.println("Client connected from " + s.getLocalAddress().getHostName());	//	TELL THEM THAT THE CLIENT CONNECTED

                Client chat = new Client(s);//CREATE A NEW CLIENT OBJECT
                Thread t = new Thread(chat);//MAKE A NEW THREAD
                t.start();//START THE THREAD
            }
        } catch (Exception e) {
            System.out.println("An error occured.");//IF AN ERROR OCCURED THEN PRINT IT
            e.printStackTrace();
        }

// utilizzo Reflection
        
        // "frameworkapp.Item"

        try {
            // Ottengo il riferimento alla Classe di interesse
            Class c = Class.forName("frameworkapp.Item");

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


            // Recupero la lista dei Campi della Classe
            Field campi[] = c.getDeclaredFields();

            // Visualizzo i dati di Ciascun Campo
            for (int i = 0; i < campi.length; i++) {
                Field campoCorrente = campi[i];
                System.out.println("Campo n." + (i + 1) + ":");
                System.out.println("Nome: " + campoCorrente.getName());
                System.out.println("Tipo: " + campoCorrente.getType());
                String modificatore = Modifier.toString(campoCorrente.getModifiers());
                System.out.println("Modificatore: " + modificatore);

                // Visualizzo i Metodi
                Method listaMetodi[] = c.getDeclaredMethods();   
                for (int k = 0; k < listaMetodi.length; k++) {
                    Method currentMethod = listaMetodi[k];

                    // Full description del Metodo
                    String fullDesc = currentMethod.toString();
                    System.out.println("Metodo n." + (k + 1) + ": " + fullDesc);

                    // Nome e Modificatore del Metodo
                    System.out.println("Nome: " + currentMethod.getName());
                    String modificatoreM = Modifier.toString(currentMethod.getModifiers());
                    System.out.println("Modificatore d'Accesso: " + modificatoreM);

                    // Eventuali Parametri del Metodo
                    Class tipiParam[] = currentMethod.getParameterTypes();
                    if (tipiParam.length == 0) {
                        System.out.println("Il metodo suddetto non prevede alcun parametro!");
                    } else {
                        System.out.println("Il metodo suddetto prevede i seguenti parametri: ");
                    }
                    for (int j = 0; j < tipiParam.length; j++) {
                        System.out.println(tipiParam[j].getName());
                    }

                    // Parametro di Ritorno
                    Class returnType = currentMethod.getReturnType();
                    System.out.println("Tipo di ritorno: " + returnType.getName());

                    //Eventuali Eccezioni
                    Class eccezioni[] = currentMethod.getExceptionTypes();
                    if (eccezioni.length == 0) {
                        System.out.println("Il metodo suddetto non solleva eccezioni!");
                    } else {
                        System.out.println("Il metodo suddetto può sollevare le seguienti eccezioni: ");
                    }
                    for (int j = 0; j < eccezioni.length; j++) {
                        System.out.println(eccezioni[j].getName());
                    }
                }
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Classe non trovata!");
        }


    }
    
}


