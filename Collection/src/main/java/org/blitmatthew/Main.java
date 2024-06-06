package org.blitmatthew;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> names = new ArrayList<>();
        names.add("Nick");
        names.add("Sam");
        names.add("Omer");
        names.add("Thomas");
        System.out.println(names);

        names.forEach(x -> System.out.println(x));
        System.out.println(names.contains("Bob"));
        System.out.println(names.get(2));
        names.remove(1);
        System.out.println(names);

//        names.sort(Comparator.reverseOrder());
//        System.out.println(names);
        names.add("Omer");
        System.out.println(names);
        Set<String> set = names.stream().collect(Collectors.toSet());
        System.out.println(set);
        System.out.println(set);
        set.add("Omer");
        System.out.println(set);
    }
}