package com.tiy.networking;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

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

            Socket clientSocket = new Socket ("localhost", 8024); //"localhost", 8024 ;"10.0.0.129"
            System.out.println("Connection established");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //output
            System.out.println("output stream initialized");

//            out.write("Hello");

            out.println("Please enter your name in this format name=whateverYourNameIs");

            System.out.println("sent message asking for name");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input - inputstream gives you the bits and bytes inputstreamreader gives us chars instead of bytes
                                        //bufferedReader allows for easier reading of the InputStreamReader content
            System.out.println("input stream initialized");

            //System.out.println("Please provide your name");
            //out.println("Please enter your name in this format name=whateverYourNameIs");
            //System.out.println("sent message asking for name");

            //while(true) {
                String serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);
                serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);

                //out.println("Please enter exit once finished");
            //}

           // clientSocket.close();
        } catch (IOException exception) {
            exception.printStackTrace(); //see the exception
        }
    }
}
