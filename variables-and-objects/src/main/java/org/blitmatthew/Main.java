package org.blitmatthew;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Variables
        //Primitives
        byte n1 = 8;
        short n2 = 16;
        int n3 = 32;
        long n4 = 64;
        float n5 = 32;
        double n6 = 64;
        char c1 = 'g';
        char c2 = 'e';
        char c3 = 't';
        char c4 = 234;
        System.out.println(c4);
        boolean b1 = true;
        //All of these store on the Stack Memory which is the RAM
        // Based on LIFO(Last-in-first-out)
        //Reference
        //Store on the heap
        String s1 = "Hello, Class";
        Byte n7 = n1;
        Short n8 = n2;
        Integer n9 = n3;
        Long n10 = n4;
        Float n11 = n5;
        Double n12 = n6;

        int[] arr1 =  {1, 2, 3, 4};

        //TypeCasting
        //Float tc1 = n9.floatValue();
        Float tc1 = (float) n9;
        double tc2 = n3;

    }
}