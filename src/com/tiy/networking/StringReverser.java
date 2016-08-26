package com.tiy.networking;

import java.util.Scanner;

/**
 * Created by bearden-tellez on 8/25/16.
 */
public class StringReverser {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        //String testString = String.valueOf(inputScanner.nextLine());
        String testString = "something";
        char[] charArray = testString.toCharArray();
        for(int counter = charArray.length -1; counter < 0; counter --) {
            System.out.print(charArray[counter]);
        }
    }
}
