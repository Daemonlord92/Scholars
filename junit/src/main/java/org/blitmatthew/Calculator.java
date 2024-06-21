package org.blitmatthew;

public class Calculator {

    private static int calCount = 0;

    public Calculator() {
        calCount++;
    }

    public static int getCalCount() {
        return calCount;
    }

    public static void setCalCount(int calCount) {
        Calculator.calCount = calCount;
    }

    public void resetCount() {
        calCount = 0;
    }

    public int add(int i, int i1) {
        return i + i1;
    }

    public int subtract(int i, int i1) {
        return i - i1;
    }

    public int divide(int i, int j) {
        if(j== 0) throw new ArithmeticException("Cannot divide by zero!");
        return i/j;
    }
}
