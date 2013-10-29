/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkapp;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.io.IOException;


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
        
        		try 
		{
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
		} 
		catch (Exception e) 
		{
			System.out.println("An error occured.");//IF AN ERROR OCCURED THEN PRINT IT
                        e.printStackTrace();
		}
        
    }
    
}



