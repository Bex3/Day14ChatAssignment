package com.tiy.networking;

/**
 * Created by bearden-tellez on 8/25/16.
 */
public class StringReverser {

    public static void main(String[] args) {
        String testString = "something";
        char[] charArray = testString.toCharArray();

        for(int counter = charArray.length -1; counter < 0; counter --) {
            System.out.print(charArray[counter]);
        }
    }
}
