package com.tiy.networking;


/**
 * Created by bearden-tellez on 8/28/16.
 */
public class testString {
    public static void main(String[] args) {
        String testString = "this is the string to combine";
        char[] charArray = testString.toCharArray();
//        System.out.println(testString.split(" ")[0]); //go through and prints ind.
//        System.out.println(testString.split(" ")[1]);
//        System.out.println(testString.split(" ")[2]);
//        System.out.println(testString.split(" ")[3]);
//        System.out.println(testString.split(" ")[4]);
//        System.out.println(testString.split(" ")[5]);


        System.out.println(testString.toUpperCase()); //everything is upper case

        System.out.println(testString.toLowerCase()); //everything lower
        System.out.println(testString.substring(1, 5)); //prints from first number to second number




        for (int counter = charArray.length; counter >= 0; counter ++){
            System.out.print(testString.split(" ")[counter]);
        }
    }

}
