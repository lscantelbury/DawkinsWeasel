package com.company;

import java.util.Random;

public class Main {
    static String TARGET = "Me thinks it is like a weasel";
    static String RESULT_STRING = "";
    static char[] ALPHABET = {
                    ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o','p', 'q', 'r', 's', 't',
                    'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                    'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                    'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                    'Y', 'Z'
    };
    static int CHANCE_OF_MUTATION = 10;

    public static void main(String[] args) {
        int generation = 1;
        generatesRandomString();
        
        long start = System.currentTimeMillis();
        while (!RESULT_STRING.equals(TARGET)){
            mutate();
            System.out.println(RESULT_STRING + " - Generation " + generation);
            generation++;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time: "+ (end - start)+ " miliseconds");

    }

    static void generatesRandomString(){
        StringBuilder resultString = new StringBuilder(RESULT_STRING);
        Random generator = new Random();
        for (int i = 0; i < TARGET.length(); i++){
            resultString.append(ALPHABET[generator.nextInt(0,53)]);
        }
        RESULT_STRING = resultString.toString();
    }
    static void mutate(){
        Random generator = new Random();
        if (generator.nextInt() < CHANCE_OF_MUTATION){
            int randomIntFromString = generator.nextInt(0, RESULT_STRING.length());
            char randomCharFromString = RESULT_STRING.charAt(randomIntFromString);

            if (randomCharFromString != TARGET.charAt(randomIntFromString)){
                StringBuilder resultString = new StringBuilder(RESULT_STRING);
                resultString.setCharAt(randomIntFromString, ALPHABET[generator.nextInt(0, 53)]);
                RESULT_STRING = resultString.toString();
            }
        }
    }
}
