package org.blitmatthew;

public class Calculator {
    public static String name = "Calculator";

    public static String getName() {
        return name;
    }

    public static int add(int a, int b) {
        return a+b;
    }

    public static int add(int a, int b, int c) {
        return a+b+c;
    }

    public static double add(double a, double b) {
        return a+b;
    }

    public static void getTester() {
        InnerClass.tester();
    }

    private static class InnerClass {
        public static void tester() {
            System.out.println("Public Method in Private class");
        }
    }
}
