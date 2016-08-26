
package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.IntSummaryStatistics;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;


/**
 * Created by bearden-tellez on 8/25/16.
 */

public class ConnectionHandler implements Runnable{
    Socket clientSocket = null;

    public void run() {
        try {
            handleIncomingConnections(clientSocket);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public ConnectionHandler(){

    }

    public ConnectionHandler(Socket incomingConnection) {
        this.clientSocket = incomingConnection;
    }


    private void handleIncomingConnections(Socket incomingConnection) throws IOException {
        //IntSummaryStatistics serverListener = null; //not sure what this is

        //Socket clientSocket = serverListener.accept(incomingConnection); //revisit this later
        System.out.println("Connected");

        System.out.println("clientSocket = " + clientSocket);

        System.out.println("Connected with" + clientSocket.getInetAddress().getHostAddress());

        // once we connect to the server, we also have an input and output stream
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //if (){
          //  System.out.println("Transmission error please try again later");
         //   break;
        //} else {

            // send the server an arbitrary message
            System.out.println("I sent you a message - RBT");
            // read what the server returns
            String serverResponse = in.readLine();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received message: " + inputLine + " from " + in.toString());
                out.println(out);
            }
        //}
        // close the connection
        clientSocket.close();
    }

}
