package com.tiy.networking;

import com.sun.corba.se.spi.activation.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

/**
 * Created by bearden-tellez on 8/25/16.
 */
public class SampleServer {
/*Socket theSocket = null;

    public SampleServer(){}
    public SampleServer(Socket inBriceWeTrust){
        this.theSocket = inBriceWeTrust;
    }*/


    public void StartServer() {
        System.out.println("Booting server");
        try {
            ServerSocket serverListener = new ServerSocket(8005); //8005?
            System.out.println("Ready to listen");

            while(true) {
                Socket incomingConnection = serverListener.accept();
                ConnectionHandler handler = new ConnectionHandler(incomingConnection);
                Thread runningThreadServer = new Thread(handler);
                runningThreadServer.start();
            }
//            //blocking now
//            Socket clientSocket = serverListener.accept();
//            System.out.println("Connected");
//
//            System.out.println("clientSocket = " + clientSocket);
//
//            System.out.println("Connected with" + clientSocket.getInetAddress().getHostAddress());
//
//            // connect to the server on the target port
//
//            // once we connect to the server, we also have an input and output stream
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            // send the server an arbitrary message
//            out.println("I sent you a message - RBT");
//            // read what the server returns
//            String serverResponse = in.readLine();
//
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println("Received message: " + inputLine + " from " + serverListener.toString());
//                out.println(out);
//            }
//
//            // close the connection
//            clientSocket.close();

        } catch (IOException exception){
            exception.printStackTrace(); //gotta see where my errors are
        }
    }

}
