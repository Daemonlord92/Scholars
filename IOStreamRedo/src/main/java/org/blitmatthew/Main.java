package org.blitmatthew;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try(FileWriter fr = new FileWriter("src/main/resources/example1.txt", true);
            BufferedWriter bw = new BufferedWriter(fr);
            Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please type a sentence in");
            String input = scanner.nextLine();
            bw.newLine();
            bw.append(input);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader fileReader = new FileReader("src/main/resources/example1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.lines().map(x -> x.split(",")).forEach(x -> {
                for (String ele : x) {
                    System.out.println(ele);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}