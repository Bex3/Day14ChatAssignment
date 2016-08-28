package com.tiy.networking;

import java.util.Scanner;

/**
 * Created by bearden-tellez on 8/28/16.
 */
public class StringPart2 {

    public static void main (String[] args) {
        Scanner inputScanner = new Scanner (System.in);
        //System.out.println("Please enter a string, if you enter multiple items please separate them by a space.");
        String testBString = "Hello my name is Rebecca";

        System.out.println("Did you enter a 1. variable, 2. method or 3. class name? Please enter the number associated with your choice.");
        char[] charArray = testBString.toCharArray();
        String[] preSplit = (testBString.split(" "));

        int typeOption = Integer.valueOf(inputScanner.nextLine());

        if (typeOption == 1) {
            System.out.println("You entered a variable.");
            System.out.print("my");

        } else if (typeOption == 2) {
            System.out.println("You entered a method");
            System.out.print(testBString.split(" ") + testBString.substring(1));


            System.out.print("()");

        } else if (typeOption == 3) {
            System.out.println("You entered a class name");
            System.out.print("My"+ testBString.split(" "));

            System.out.print(" {}");
        }


    }
}
