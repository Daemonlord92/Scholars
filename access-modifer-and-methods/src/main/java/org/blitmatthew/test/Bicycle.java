package org.blitmatthew.test;

public interface Bicycle {
    void changeCadence(int newValue);
    void changeGear(int newValue);
    void speedUp(int newValue);
    void applyBrakes(int decrement);
    default void hardBrake() {
        System.out.println("The Bike stops hard");
    }
}
