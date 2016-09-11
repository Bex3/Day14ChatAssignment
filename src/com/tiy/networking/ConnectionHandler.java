
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
//            PrintWriter outputToClient;
//            BufferedReader inputFromClient;
            handleIncomingConnections(clientSocket);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }


    public ConnectionHandler(Socket incomingConnection) {
        this.clientSocket = incomingConnection;
    }


    private void handleIncomingConnections(Socket incomingConnection) throws IOException {

        System.out.println("Connected");

        System.out.println("clientSocket = " + incomingConnection);

        System.out.println("Connected with " + incomingConnection.getInetAddress().getHostAddress());

        //String name = clientSocket.getInetAddress().getHostAddress();

        // once we connect to the server, we also have an input and output stream
        PrintWriter out = new PrintWriter(incomingConnection.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(incomingConnection.getInputStream()));


        //out.println("Hello, please enter your name in the following format name=WhateverYourNameIs.");

        String clientName = in.readLine();

        System.out.println(clientName);

        this.clientUserName = (clientName.split("=") [1]);
        System.out.println(clientUserName);
        out.println("Nice to meet you" + clientUserName);

        //Scanner inputScanner = new Scanner(System.in);

        String clientInput;
        while (true) {
            if (clientUserName != null && (clientInput= in.readLine()) != null) {
                //String clientResponse = in.readLine();
                    //out.println("Your name is " + clientUserName);
                    //setClientUserName(inputLine);
                    //System.out.println("Your name is " + getClientUserName());
                    //String newInputLine = inputScanner.nextLine();
                    System.out.println(clientUserName + " said " + clientInput); //in.toString())
                    out.println("Message received: " + clientInput);
                } else {
                    System.out.println("Transmission error please try again later");
                    out.println("Transmission error please try again later");
                    break;
                }
            }
            clientSocket.close();
        }
        //clientSocket.close();
}
