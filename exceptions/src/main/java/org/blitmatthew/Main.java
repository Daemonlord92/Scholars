package org.blitmatthew;

import org.blitmatthew.exception.IncorrectSelectionException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String readFirstLineFromFile(String path) throws IOException {
        try (FileReader fr = new FileReader(path);
             BufferedReader br =  new BufferedReader(fr)) {
            return br.readLine();
        }
    }

    public static void main(String[] args){
        System.out.println("Hello world!");
        try {
            int quotient = 3/0;
            System.out.println(quotient);
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            System.out.println("I'm running after the math exception!");
        }

        Scanner scan = new Scanner(System.in);
        int choice = 0;
        boolean running = true;
        try {
           while(running) {
               System.out.println("""
                       1.Print Something
                       2.Print Something Else
                       3.Exit
                       """);
               choice = scan.nextInt();
               switch (choice) {
                   case 1:
                       System.out.println("Hooray First Print");
                       break;
                   case 2:
                       System.out.println("Second Print");
                       break;
                   case 3:
                       running = false;
                       System.exit(0);
                   default:
                       throw new IncorrectSelectionException("Needs to be between 1-3 to work!");
               }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (IncorrectSelectionException e) {
            System.out.println(e);
        }

        System.out.println("The Try Ran");
        try{
            System.out.println(readFirstLineFromFile("src/main/resources/example.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}