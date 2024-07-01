package org.blitmatthew.vehicle;

public class Car implements Vehicle{

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }


    @Override
    public void start() {
        engine.start();
    }
}
