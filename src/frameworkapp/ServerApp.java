/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

import java.net.*;
import java.io.*;
// import per implementare la Reflection
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alessandra
 */
public class ServerApp extends Thread {

    private static int port;
    private ServerSocket serverSocket;

    public ServerApp(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(20000);
    }

    /**
     * @param args the command line arguments
     */
    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                ObjectInputStream in = new ObjectInputStream(server.getInputStream());

                // ricevo dati dal client
                System.out.println("Ricevo dal client....");
                Object obj = in.readObject();
//                byte[] dati = new byte[1000];
//                ByteArrayInputStream byte_stream = new ByteArrayInputStream(dati);
//                ObjectInputStream ois = new ObjectInputStream(byte_stream); //byte_stream);
//                Object o = ois.readObject();
//                //Class c = (Class) ois.readObject();
//                Class c = ois.readObject().getClass();
//                ois.close();
//                System.out.println(o.toString());
                System.out.println(obj.toString());
                System.out.println(obj.getClass().getCanonicalName());
                System.out.println("Fine ricezione...");

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        port = 9000;
        try {
            Thread t = new ServerApp(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // utilizzo Reflection
        // Lo si fa per rendere manipolabile un oggetto pur non conoscendo
        // la classe
        // Stampe di prova
        // "frameworkapp.Item"
        /*
        try {
            System.out.println("Iniziano le stampe di prova... ");
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
*/



    }
}
