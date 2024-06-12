package org.blitmatthew;

import org.blitmatthew.classes.Car;
import org.blitmatthew.classes.Computer;
import org.blitmatthew.linkedlist.LList;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void generateSubsets(int[] arr, int n){
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.println(arr[j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*System.out.println("Hello world!");

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
        System.out.println(set);*/

//        List<Integer> numList = new ArrayList<>();
//        numList.add(1); // 0
//        numList.add(26);// 1
//        numList.add(625);// 2
//        numList.add(786);// 3
//        numList.add(26);// 4
////        numList.add(null);//5
////        numList.add(null);//6
//        System.out.println(numList);
//        System.out.println(numList.get(3));
//        numList.remove(1);
//        System.out.println(numList);
//        System.out.println(numList.get(1));
//        System.out.println(numList.contains(65));
//        Set<Integer> numSet = new HashSet<>();
//        numSet.add(1);
//        numSet.add(26);
//        numSet.add(625);
//        System.out.println(numSet);
//        numSet.add(26);
//        System.out.println(numSet);
////        numSet.add(null);
//        System.out.println(numSet);
//        /*
//        * Constant: O(1)
//        * Linear time: O(n)
//        * Logarithmic time: O(n log n)
//        * Quadratic time: O(n^2)
//        * Exponential time: O(2^n)
//        * Factorial time: O(n!)
//        * */
//
//        /*for (int i = 0; i < 5; i++) {
//            System.out.println(i + "i");
//            for (int j = 0; j < 6; j++) {
//                System.out.println(j + "j");
//            }
//        }*/
//
//        int[] arr = { 3, 5, 1, 7, 9, 10, 15};
//        generateSubsets(arr, arr.length);
//
//        //Bits Position
//        // 01
//        // 11101 = 29
//        // <<
//        // 01110 = 14
//        // >>
//        // 11100 = 28
//        // 00011 = 3
//        // 00100
//        // 1000001
//
//

        //Dynamically sized
        //0 index based list
        //ordered
        //You can perform full CRUD operation
        //CREATE
        //READ
        //UPDATE
        //DELETE
//        List<String> troubleMakers = new ArrayList<>();
//        troubleMakers.add("Thomas");
//        System.out.println(troubleMakers);
//        troubleMakers.addAll(List.of("Omer", "Charles", "Alfonso"));
//        System.out.println(troubleMakers);
//        troubleMakers.add(3, "Nick");
//        System.out.println(troubleMakers);
//        troubleMakers.remove(4);
//        System.out.println(troubleMakers);
//        troubleMakers.set(0, "Jehu");
//        System.out.println(troubleMakers);
//        for (int i = 0; i < troubleMakers.size(); i++) {
//            System.out.println(troubleMakers.get(i));
//        }
//
//        if(troubleMakers.isEmpty()) {
//            troubleMakers.add("Omer");
//        }
//        System.out.println(troubleMakers);
//        troubleMakers.add("Sam");
//        System.out.println(troubleMakers);
//        if(troubleMakers.contains("Sam")) {
//            System.out.println("In if statement");
//            troubleMakers.remove("Sam");
//        }
//        System.out.println(troubleMakers);
//
//        List<String> clonedList = new ArrayList<>(troubleMakers);
//
//        /*try{
//            clonedList.set(5, "Bhavani");
//        } catch (IndexOutOfBoundsException e) {
//            throw new IndexOutOfBoundsException(e.getMessage());
//        } finally {
//            System.out.println(clonedList);
//        }*/
//        for (String troubleMaker : troubleMakers) {
//            System.out.println(troubleMaker);
//        }
//
//        String[] names = {"Sam", "Nick", "Alfonso"};
//        for (String name : names) {
//            System.out.println(name);
//        }
//
//        System.out.println(names[0]);
//        System.out.println(names.length);
//
//        int[] rand = new int[10];
//        System.out.println(Arrays.toString(rand));
//        for (int i = 0; i < rand.length; i++) {
//            rand[i] = new Random().nextInt();
//        }
//        System.out.println(Arrays.toString(rand));
//        List intList = new ArrayList<>();
//        intList.add(3);
//        intList.add(5);
//        intList.add(9);
//        intList.add("Jake");
//        System.out.println(intList.get(0));
        // ArrayList  || Arrays
        // References Type|| Primative and References
        // Dynamic Sized || Fixed
        // Has Operations Methods|| No Operation Methods
        // Uses Generics || No Generic Use
//        List<String> games = new LinkedList<>();
//
//        games.add("Doom The Dark Ages");
//        games.add("Palworld");
//        games.add("Age Of Empires 4");
//        games.add("Call of Duty");
//
//        System.out.println(games);
//        System.out.println(games.get(1));

        // ["Doom"]-["Palworld"]-["Age"]-["CoD"]

        // LinkedList || ArrayList
        // node to node setup|| Dynamic Array Setup
        // List, Queue, and Deque || List
        // To access you have iterate the elements in the list|| Can randomly access elements by using indexes
//        LList root = new LList(3, null, null);
//
//        System.out.println(root);
//        root.setNext(new LList(4, root, null));
//        root.getNext().setNext(new LList(10, root.getNext(), null));
//        root.getNext().getNext().setNext(new LList(16, root.getNext().getNext(), null));
//        LList prev;
//        while (root.getNext() != null) {
//            System.out.println(root.getValue());
//            prev = root;
//            root = root.getNext();
//            root.setPrev(prev);
//            System.out.println(root.getValue());
//            System.out.println();
//        }

        /*Stack<Boolean> booleanStack = new Stack<>();
        booleanStack.push(false);
        booleanStack.push(true);
        booleanStack.push(false);
        booleanStack.push(false);
        booleanStack.push(true);
        System.out.println(booleanStack);
        while (!booleanStack.isEmpty()) {
            if(booleanStack.peek()) {
                System.out.println("Charles is smacking Omer");
            } else {
                System.out.println("Alfonso is being messed with");
            }
            booleanStack.pop();
        }*/

//        Stack<String> exercises = new Stack<>();
//
//        exercises.push("Triceps Push down 100Lbs");
//        exercises.push("Bench Press 100Lbs");
//        exercises.push("Leg Press 260Lbs");
//        exercises.push("Bicep Curls 50Lbs");
//        exercises.push("Lat Pull Down 100Lbs");
//
//        System.out.println(exercises);
//        int position = exercises.search("Lat Pull Down 100Lbs");
//        System.out.println(position);
//        exercises.remove(4);
//        exercises.pop();
//        System.out.println(exercises);
//
//        position = exercises.search("Bench Press 100Lbs");
//        System.out.println("Position of Exercise: " + position);
//        position = exercises.search("Leg Press 260Lbs");
//        System.out.println("Position of Exercise: " + position);
//        position = exercises.search("Bicep Curls 50Lbs");
//        System.out.println(position);
//
//        System.out.println(exercises.empty());
//        exercises.clear();

//        Set<String> uniqueNames = new HashSet<>();
//        uniqueNames.add("Sam");
//        uniqueNames.add("Bhavani");
//        uniqueNames.add("Jehu");
//        uniqueNames.add("Thomas");
//        System.out.println(uniqueNames);
//        uniqueNames.add("Sam");
//        uniqueNames.add("Thomas");
//        System.out.println(uniqueNames);
//
//        Set<String> names = new HashSet<>();
//
//        names.add("Sam");
//        names.add("Nick");
//        names.add("Thomas");
//        names.add("Omer");
//
//        names.addAll(uniqueNames);
//        System.out.println(names);
//
//        Set<String> common = new HashSet<>(uniqueNames);
//        common.retainAll(names);
//        System.out.println(common);
//
//        Set<String> difference = new HashSet<>(uniqueNames);
//        difference.removeAll(names);
//        System.out.println(difference);
//
//        Set<String> sortedSet = new TreeSet<>(uniqueNames);
//        System.out.println(sortedSet);
//
//        Set<String> linkedHashSet = new LinkedHashSet<>();

//        Queue<String> peopleInLine = new LinkedList<>();
//
//        try {
//            peopleInLine.remove();
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//        }
//
//        peopleInLine.add("Alfonso");
//        peopleInLine.add("Jehu");
//        peopleInLine.add("Sayeed");
//
//        System.out.println(peopleInLine);

//        peopleInLine.remove();
//
//        System.out.println(peopleInLine);
//
//        peopleInLine.poll();
//
//        peopleInLine.poll();
//        peopleInLine.poll();
//        System.out.println(peopleInLine);
        //Singly Linked List



        //Doubly Linked List
//        Queue<Integer> numberQueue = new PriorityQueue<>(Collections.reverseOrder());
//
//        numberQueue.add(3);
//        numberQueue.add(2);
//        numberQueue.add(6);
//        numberQueue.add(9);
//
//        System.out.println(numberQueue);
//        System.out.println(numberQueue.peek());
//        System.out.println(numberQueue.element());
 Map<String, Object> map = new HashMap<>();

    map.put("MSI Raider", new Computer(
            "MSI",
            "Raider",
            2023,
            16,
            32,
            "SSD",
            1024));
    map.put("Toyota Rav4", new Car(
            "Toyota",
            "Rav4",
            "Purple",
            7
    ));
    map.put("Computer Array", List.of(new Computer("MSI",
            "Raider",
            2023,
            16,
            32,
            "SSD",
            1024),
            new Computer("MSI",
                    "Raider",
                    2023,
                    16,
                    32,
                    "SSD",
                    1024)));
        map.put("Toyota Rav4", new Car(
                "Toyota",
                "Rav4",
                "Black",
                7
        ));

        System.out.println(map);

        map.remove("MSI Raider");
        System.out.println(map);

        System.out.println(map.containsKey("Toyota Rav4"));

        System.out.println(map.containsValue(new Car(
                "Toyota",
                "Rav4",
                "Black",
                7
        )));

        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}