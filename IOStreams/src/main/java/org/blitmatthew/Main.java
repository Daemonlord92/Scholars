package org.blitmatthew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/example.txt");
            myWriter.write("Thomas is jumping about\n");
            myWriter.write("Nick is sitting in the corner\n");
            myWriter.write("Charles is bouncing the ball on Alfonso\n");
            myWriter.write("Bhavani is typing the crazy stories\n");
            myWriter.write("Sam is Laughing at everyone\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try(FileReader fr = new FileReader("src/main/resources/example.txt");
            BufferedReader bufferedReader = new BufferedReader(fr)) {
//            for (int i = 0; i < 6; i++) {
//                System.out.println(bufferedReader.readLine());
//            }
//            System.out.println(bufferedReader.readLine());
//            while(bufferedReader.lines().) {
//                System.out.println(bufferedReader.readLine());
//            }
            bufferedReader.lines().forEach(x -> System.out.println(x));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}