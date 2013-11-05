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
   public static void main(String [] args)
   {
      String sName = "localhost";
      int port = 9000;
      try
      {
         System.out.println("Connecting to " + sName
                             + " on port " + port);
         Socket client = new Socket(sName, port);
         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outToServer);

         out.writeUTF("Hello from "
                      + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
         System.out.println("Server says " + in.readUTF());
         client.close();
      }catch(IOException e)
      {
      }
   }
}