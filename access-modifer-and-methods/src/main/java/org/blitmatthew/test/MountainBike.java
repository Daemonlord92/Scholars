package org.blitmatthew.test;

public class MountainBike implements Bicycle {
    private int cadence = 0;
    private int speed = 0;
    private int gears = 1;

    @Override
    public void changeCadence(int newValue) {
        this.cadence += newValue;
    }

    @Override
    public void changeGear(int newValue) {
        this.gears = newValue;
    }

    @Override
    public void speedUp(int newValue) {
        this.speed += newValue;
    }

    @Override
    public void applyBrakes(int decrement) {
        this.speed -= decrement;
    }
}
