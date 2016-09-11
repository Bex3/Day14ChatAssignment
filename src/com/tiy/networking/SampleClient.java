package com.tiy.networking;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

/**
 * Created by bearden-tellez on 8/25/16.
 */
public class SampleClient {
    public static void main(String[] args) {
        System.out.println("Run the client server");
        //Private String messageToServer;

        try{
            Scanner inputScanner = new Scanner(System.in);
            Socket clientSocket = new Socket ("localhost", 8024); //"localhost", 8024 ;"10.0.0.129"
            System.out.println("Connection established");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //output
            System.out.println("output stream initialized");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input - inputstream gives you the bits and bytes inputstreamreader gives us chars instead of bytes
            //bufferedReader allows for easier reading of the InputStreamReader content
            System.out.println("input stream initialized");
//            out.write("Hello");

            System.out.println("Please enter your name in this format name=whateverYourNameIs");
            String name = inputScanner.nextLine();
            out.println(name);

//            String clientInput = in.readLine();
//            String clientInput;
            String serverInput = in.readLine();
            while (serverInput != null) {
                System.out.println("Enter your message ");
//                out.println("Enter your message");
                String clientInput = inputScanner.nextLine();
                System.out.println(clientInput);
//                String messageToServer = inputScanner.nextLine();
                out.println("Sending " + clientInput + " to the server ...");
                out.println(clientInput);


                if (in != null) {
                    System.out.println("Server response: " + in.readLine());
                }
            }
            clientSocket.close();

            } catch (IOException exception) {
                exception.printStackTrace(); //see the exception
        }
    }
}
