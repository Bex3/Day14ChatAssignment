package com.tiy.networking;

import java.util.Scanner;

/**
 * Created by bearden-tellez on 8/25/16.
 */
public class StringReverser {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter a word that you would like to have reversed by the magical word reverser!");
        String testString = String.valueOf(inputScanner.nextLine());
        //String testString = "something";
        System.out.println("You input " + testString);
        char[] charArray = testString.toCharArray();
        //System.out.println(charArray);

        for(int counter = charArray.length -1; counter >= 0; counter --) {
           System.out.print(charArray[counter]);

        }

    }

}
