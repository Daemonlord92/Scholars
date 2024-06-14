package org.blitmatthew;

import org.blitmatthew.classes.RnMCharacters;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello world!");

        Optional<Integer> integerOptional = Optional.of(7);

        if(integerOptional.isEmpty()){
            throw new RuntimeException("Optional is empty");
        }

        Integer integer = integerOptional.get();
        System.out.println(integer);

        List<RnMCharacters> rnMCharactersList = List.of(
                new RnMCharacters(1, "Morty", "Alive?", "Morty", "Main", "Male"),
                new RnMCharacters(2, "Rick", "Alive", "Human", "Main", "Male"),
                new RnMCharacters(3, "Summer", "Alive", "Human", "Main", "Female")
        );

        //Since there is no Jerry in the list it will return with an Optional.empty()
        //Optional<RnMCharacters> jerry = rnMCharactersList.stream().filter(x -> x.getName().equals("Jerry")).findFirst();
        //Because Morty is in the list it will return with Optional[RnMCharacters{id=1, name='Morty', status='Alive?', species='Morty', type='Main', gender='Male'}]
        Optional<RnMCharacters> jerry = rnMCharactersList.stream().filter(x -> x.getName().equals("Morty")).findFirst();

        System.out.println(jerry);

        //So we use the Optional Class when we don't know if we are going be getting the data from the location
        // and if don't get it we can control the exceptions
        // but if we do get it we can remove it out of the Optional container so it can be used and changed.

        List<String> rnMNames = rnMCharactersList.stream().map(RnMCharacters::getName).toList();

        rnMNames.forEach(System.out::println);

        for (int i = 0; i < rnMCharactersList.size(); i++) {
            System.out.println(rnMCharactersList.get(i).getName());
        }

        System.out.println(rnMNames.stream().sorted().toList());

        Map<String, String> goofyTime = new HashMap<>();
        goofyTime.put("12:00", "Clown Pie Time");
        goofyTime.put("4:00", "Rowshambo");
        goofyTime.put("3:00", "Throwing Omer to Lions");
        goofyTime.put("2:45", "EAT THE BABY");

        String clown = goofyTime.values().stream().filter(x -> x.equals("Clown Pie Time")).map(String::toUpperCase).findAny().orElseThrow();
        System.out.println(clown);

        Stream<Integer> stream = Stream.generate(() -> new Random().nextInt(100));
        System.out.println(stream.findAny().get());

        stream = Stream.iterate(0, n-> n++);


        List<Integer> bills = new ArrayList<>();

        bills.add(45);
        bills.add(73);
        bills.add(90);
        bills.add(55);

        System.out.println(bills.stream().mapToInt(Integer::intValue).average());
        System.out.println(bills.stream().mapToInt(Integer::intValue).sum());
        System.out.println(bills.stream().mapToInt(Integer::intValue).summaryStatistics());
    }
}