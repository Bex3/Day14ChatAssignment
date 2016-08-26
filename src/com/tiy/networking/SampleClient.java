package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

/**
 * Created by bearden-tellez on 8/25/16.
 */
public class SampleClient {
    public static void main(String[] args) {
        System.out.println("Run the client server");

        try{

            Socket clientSocket = new Socket ("localhost", 8024);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //output
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input - inputstream gives you the bits and bytes inputstreamreader gives us chars instead of bytes
                                        //bufferedReader allows for easier reading of the InputStreamReader content
            System.out.println("Please provide your name");

            String serverResponse = in.readLine();

            clientSocket.close();
        } catch (IOException exception) {
            exception.printStackTrace(); //see the exception
        }
    }
}
