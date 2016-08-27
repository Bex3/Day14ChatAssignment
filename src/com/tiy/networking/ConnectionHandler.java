
package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;


/**
 * Created by bearden-tellez on 8/25/16.
 */

public class ConnectionHandler implements Runnable {
    Socket clientSocket = null;

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    private String clientUserName = null;

    public void run() {
        try {
            handleIncomingConnections(clientSocket);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

/*    public ConnectionHandler(){

    }*/

    public ConnectionHandler(Socket incomingConnection) {
        this.clientSocket = incomingConnection;
    }


    private void handleIncomingConnections(Socket incomingConnection) throws IOException {
        //IntSummaryStatistics serverListener = null; //not sure what this is

        //Socket clientSocket = serverListener.accept(incomingConnection); //revisit this later
        System.out.println("Connected");

        System.out.println("clientSocket = " + clientSocket);

        System.out.println("Connected with " + clientSocket.getInetAddress().getHostAddress());

        String name = clientSocket.getInetAddress().getHostAddress();

        // once we connect to the server, we also have an input and output stream
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("Hello, please enter your name in the following format name=WhateverYourNameIs.");

        while (true) {
            String serverResponse = in.readLine();
            Scanner inputScanner = new Scanner(System.in);
            String inputLine = inputScanner.nextLine();
            if (getClientUserName() == null) {
                if ((inputLine.split("=")[0]).equals("name")) {
                    out.println("Your name is " + inputLine);
                    setClientUserName(inputLine);
                    System.out.println("Your name is " + getClientUserName());
                    String newInputLine = inputScanner.nextLine();
                    System.out.println((inputLine.split("=")[1]) + " said " + newInputLine); //in.toString())
                } else {
                    System.out.println("Transmission error please try again later");
                    out.println("Transmission error please try again later");
                    break;
                }
            }
            //clientSocket.close();
        }
        clientSocket.close();
    }
}