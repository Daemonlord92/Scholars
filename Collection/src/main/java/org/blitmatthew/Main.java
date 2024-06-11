package org.blitmatthew;

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

        List<Integer> numList = new ArrayList<>();
        numList.add(1); // 0
        numList.add(26);// 1
        numList.add(625);// 2
        numList.add(786);// 3
        numList.add(26);// 4
//        numList.add(null);//5
//        numList.add(null);//6
        System.out.println(numList);
        System.out.println(numList.get(3));
        numList.remove(1);
        System.out.println(numList);
        System.out.println(numList.get(1));
        System.out.println(numList.contains(65));
        Set<Integer> numSet = new HashSet<>();
        numSet.add(1);
        numSet.add(26);
        numSet.add(625);
        System.out.println(numSet);
        numSet.add(26);
        System.out.println(numSet);
//        numSet.add(null);
        System.out.println(numSet);
        /*
        * Constant: O(1)
        * Linear time: O(n)
        * Logarithmic time: O(n log n)
        * Quadratic time: O(n^2)
        * Exponential time: O(2^n)
        * Factorial time: O(n!)
        * */

        /*for (int i = 0; i < 5; i++) {
            System.out.println(i + "i");
            for (int j = 0; j < 6; j++) {
                System.out.println(j + "j");
            }
        }*/

        int[] arr = { 3, 5, 1, 7, 9, 10, 15};
        generateSubsets(arr, arr.length);

        //Bits Position
        // 01
        // 11101 = 29
        // <<
        // 01110 = 14
        // >>
        // 11100 = 28
        // 00011 = 3
        // 00100
        // 1000001
    }
}