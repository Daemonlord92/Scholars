package org.blitmatthew;

import org.blitmatthew.counter.CounterRunnable;
import org.blitmatthew.thread.Counter;
import org.blitmatthew.thread.CounterThread;
import org.blitmatthew.thread.ResourceMiner;
import org.blitmatthew.vehicles.Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car(10);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("""
//                Welcome to the car travelled game
//                Goal is to get the car going and traveling.
//                1) Turn on car
//                2) Turn off car
//                3) Speed Up
//                4) Slow down
//                5) Exit game
//                """);
//        while (true) {
//            int input = scanner.nextInt();
//            switch (input) {
//                case 1:
//                    car.start();
//                    break;
//                case 2:
//                    car.stop();
//                    break;
//                case 3:
//                    car.speedUp();
//                    break;
//                case 4:
//                    car.brake();
//                    break;
//                case 5:
//                    System.exit(0);
//            }
//        }

//        Thread thread1 = new Thread(new CounterRunnable(), "Thread-1");
//        Thread thread2 = new Thread(new CounterRunnable(), "Thread-2");
//
//        thread1.start();
//        thread2.start();
//
//        ResourceMiner crystal = new ResourceMiner("Crystal");
//        ResourceMiner vesper = new ResourceMiner("Vesper");
//        try(Scanner scanner = new Scanner(System.in)) {
//            while (true){
//                String input = scanner.nextLine();
//                switch (input) {
//                    case "c":
//                        input = scanner.nextLine();
//                        switch (input) {
//                            case "mine":
//                                crystal.setMining(true);
//                                crystal.setInput(input);
//                                crystal.start();
//                                break;
//                            case "done":
//                                crystal.setMining(false);
//                                crystal.setInput(input);
//                                break;
//                            case "back":
//                                break;
//                        }
//                        break;
//                    case "v":
//                        input = scanner.nextLine();
//                        switch (input) {
//                            case "mine":
//                                vesper.setMining(true);
//                                vesper.setInput(input);
//                                vesper.start();
//                                break;
//                            case "done":
//                                vesper.setMining(false);
//                                vesper.setInput(input);
//                                break;
//                            case "back":
//                                break;
//                        }
//                        break;
//                    case "e":
//                        System.exit(0);
//                    default:
//                        System.out.println("please input c or v or e");
//                        break;
//                }
//            }
//        }

        Counter counter = new Counter();

        Thread thread = new CounterThread(counter);
        Thread thread1 = new CounterThread(counter);

        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}