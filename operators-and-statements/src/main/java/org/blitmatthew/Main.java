package org.blitmatthew;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = 5 + 4;
        System.out.println(sum);
        int difference = 2 - 10;
        System.out.println(difference);
        int product = 5 * 5;
        System.out.println(product);
        double quotient = 55.00 / 7.00;
        System.out.println(quotient);
        double remainder = 55.55 % 7;
        System.out.println(remainder);

        double orderOfOperations = 45.00 - (35.00 * 6) / (250 + 36);
        double order2 = (35.00 * 6) / (250 + 36);
        System.out.println(orderOfOperations);
        System.out.println(order2);

        sum = sum + 5;
        System.out.println(sum);

        sum += 7;
        System.out.println(sum);

        difference -= 9;
        System.out.println(difference);

        product *= 17;
        System.out.println(product);

        String p1 = "Hello, ";
        String p2 = "World";

        String nullAble = null;
        System.out.println(p1 + p2);

        System.out.println(p1 == p2);

        System.out.println(product >= difference);

        System.out.println(p1 != null);
        System.out.println(nullAble != null);

        for(int i = 0; i < 100; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            else {
                System.out.println(i);
            }
        }
        //&& we have both be true to get true
        //|| we have to have one true to be true
        // ! we false to be true
        boolean programmingRunning = true;
        if(!programmingRunning) {
            System.out.println("Program ended.");
        }


        //For Loops

        String abc = "abc";

        System.out.println(abc.length());
        for(int i = 0; i < abc.length(); i++){
            System.out.println(abc.charAt(i));
        }

        char[] abc2 = {'a', 'b', 'c', 'd', 'e'};

        for(char a : abc2) {
            System.out.println(a);
        }

        Animal[] animals = {
                new Animal("Cat", 2),
                new Animal("Dog", 3),
                new Animal("Snake", 1),
                new Animal("Bear", 7)
        };

        for(Animal animal : animals){
            System.out.println(animal.getType());
        }
        Scanner scanner = new Scanner(System.in);

//        while(programmingRunning){
//            String response = scanner.nextLine();
//            if (response.equals("Yes")) {
//                programmingRunning = false;
//            }
//        }

        do {
            String response = scanner.nextLine();
            if (response.equals("Yes")) {
                programmingRunning = false;
           }
        } while (programmingRunning);
    }
}