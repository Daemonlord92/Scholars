package org.blitmatthew.test;

import org.blitmatthew.Animal;

public class Test {
    private Animal animal;

    public Test(String name, String speak, int size, int weight) {
        this.animal = new Animal(name, size, weight,speak);
    }

    public void testAnimalSpeak() {
        this.animal.getSpeak();
    }
}
