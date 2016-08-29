package com.tiy.networking;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by bearden-tellez on 8/28/16.
 */
public class StringPart2 {

    public static void main (String[] args) {
        Scanner inputScanner = new Scanner (System.in);
        System.out.println("Please enter a string, if you enter multiple items please separate them by a space.");
        String testString = String.valueOf(inputScanner.nextLine());
        String[] testArray = testString.split(" ");

        System.out.println("Did you enter a 1. variable, 2. method or 3. class name? Please enter the number associated with your choice.");

        int typeOption = Integer.valueOf(inputScanner.nextLine());

        if (typeOption == 1) {
            System.out.println("You entered a variable.");
            System.out.print(testArray[0].substring(0).toLowerCase());
            for (int counter = 1; counter < testArray.length; counter++){
                System.out.print(testArray[counter].substring(0,1).toUpperCase() + testArray[counter].substring(1).toLowerCase());
            }

        } else if (typeOption == 2) {
            System.out.println("You entered a method");
            System.out.print(testArray[0].substring(0).toLowerCase());
            for (int counter = 1; counter < testArray.length; counter++){
                System.out.print(testArray[counter].substring(0,1).toUpperCase() + testArray[counter].substring(1).toLowerCase());
            }
            System.out.print("()");
        } else if (typeOption == 3) {
            System.out.println("You entered a class name");
            for (String currentString: testArray){
                System.out.print(currentString.substring(0,1).toUpperCase() + currentString.substring(1).toLowerCase());
            }
            System.out.print(" {}");
        }

        //String testString = "john has a red bike";
        //String testString = String.valueOf(inputScanner.nextLine());
        //String[] testArray = testString.split(" ");



            //System.out.print(testArray[0].substring(0,1).toUpperCase() + testArray[0].substring(1).toLowerCase());
            //System.out.print(testArray[1].substring(0,1).toUpperCase() + testArray[1].substring(1).toLowerCase());
            //System.out.print(testArray[2].substring(0,1).toUpperCase() + testArray[2].substring(1).toLowerCase());
            //System.out.print(testArray[3].substring(0,1).toUpperCase() + testArray[3].substring(1).toLowerCase());
            //System.out.println(testArray[4].substring(0,1).toUpperCase() + testArray[4].substring(1).toLowerCase());
//
//        for (String currentString: testArray){
//            System.out.print(currentString.substring(0,1).toUpperCase() + currentString.substring(1).toLowerCase());
//        }
    }
}
