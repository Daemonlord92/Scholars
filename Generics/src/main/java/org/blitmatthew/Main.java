package org.blitmatthew;

import org.blitmatthew.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <T> void printArray(T[] array) {
        for (T ele : array) {
            System.out.println(ele);
        }
    }

    public static void main(String[] args) {
//        House<Human> humanHouse = new House<>(new Human("Alfonso"));
//
//        System.out.println(humanHouse.getData().toString());
//
//        House<Dog> dogHouse = new House<>(new Dog("Jake"));
//
//        System.out.println(dogHouse.getData());

        //humanHouse.setData(new Dog("Thomas"));


        Human[] humans = {
                new Human("Nick"),
            new Human("Charles"),
            new Human("Jehu")
        };

        printArray(humans);


        NumberArray<Double> doubleNumberArray = new NumberArray<>(new ArrayList<>());

        doubleNumberArray.getArray().add(65.00);
        doubleNumberArray.getArray().add(73.99);
        doubleNumberArray.getArray().add(89.00);

        System.out.println(doubleNumberArray.getArray());

        doubleNumberArray.add(45.69);
        System.out.println(doubleNumberArray.getArray());

        doubleNumberArray.removeFirst();
        System.out.println(doubleNumberArray.getArray());

        //doubleNumberArray.add(65);

        List<Number> numbers = new ArrayList<>();

        FloatArray.addFloatToList(numbers);

        System.out.println(numbers);
    }
}