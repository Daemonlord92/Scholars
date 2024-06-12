package org.blitmatthew;

import org.blitmatthew.classes.Human;
import org.blitmatthew.interfaces.SingleMathOperation;
import org.blitmatthew.interfaces.TriFunction;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        SingleMathOperation<Integer> addOperation = (x) -> x+x;
        SingleMathOperation<Integer> multiplyOperation = (x) -> x*x;

        System.out.println(addOperation.operation(7));
        System.out.println(multiplyOperation.operation(4));
        // Takes in information but return nothing
        Consumer<String> printMessage = System.out::println;//Static Method Reference Comes from the class
        //Instance Method Reference comes from the Object
        printMessage.accept("Functional interfaces ROCK!");

        Human omer = new Human("Omer");
        printMessage.accept(omer.getName());
        // Take in a type and Returns
        Function<Integer, Boolean> isEven = (x) -> x%2==0;
        BiFunction<Integer, Integer, Integer> multiply = (x,y) -> {
            return x * y;
        };
        TriFunction<Integer, Integer, Integer, Integer> add = (x,y,z) -> x+y+z;

        System.out.println(isEven.apply(7));
        System.out.println(isEven.apply(4));

        System.out.println(multiply.apply(5, 9));
        System.out.println(add.apply(4, 10, 50));
        // Will supply data but will not take in data
        Supplier<Human> alfonso = () -> new Human("Alfonso");

        System.out.println(alfonso.get().getName());
        //Will take in a type and return a boolean on that type
        Predicate<Integer> isOdd = x -> x%2!=0;

        System.out.println(isOdd.test(5));
    }
}