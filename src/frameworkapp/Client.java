/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;

/**
 *
 * @author alessandra
 */
import java.io.*;
import java.net.*;
public class Client
{
    private static String serverName;
   public static void main(String [] args) throws IOException
   {
      String sName = "localhost";
      int port = 9000;
      try
      {
         System.out.println("Connecting to " + sName + " on port " + port);
         Socket client = new Socket(sName, port);
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         ObjectOutputStream out = new ObjectOutputStream(outToServer);

            // Genero l'output per il server
            System.out.println("Sono nel Client. Genero l'output per il server...");
            Item item = new Item("Marco", "studente");
            System.out.println(item.nome +"." + item.descrizione);
            Class i_class = item.getClass();
            System.out.println(i_class.getSimpleName());       

            out.writeObject(item);
                    
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
         System.out.println("Server risponde con "+ in.readByte());
          
         client.close();
      }catch(IOException e)
      {
      }
   }
}