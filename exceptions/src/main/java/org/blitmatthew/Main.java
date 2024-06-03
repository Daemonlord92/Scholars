package org.blitmatthew;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        try {
            int quotient = 3/0;
            System.out.println(quotient);
        } catch (RuntimeException e) {
            System.out.println(e);
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
                       throw new RuntimeException("Needs to be between 1-3 to work!");
               }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        System.out.println("The Try Ran");


    }
}