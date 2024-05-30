package org.blitmatthew;

import org.blitmatthew.test.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    //Access Modifiers
    //public can be called outside the class directly
    //private cannot be called out of class it made in
    //protected cannot be called outside the package directly
    //static belong to the Class itself.

    private static final List<String> painList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Animal animal = new Animal();
        Bat bat = new Bat();
        bat.getId();
        Calculator calculator = new Calculator();

        System.out.println(Calculator.name);
        System.out.println(Calculator.add(33, 5));
        Calculator.name = "Bob";
        System.out.println(Calculator.name);

        Calculator.getTester();

        Account account = new Account.AccountBuilder(1, 123124l, 500.00).build();

        System.out.println(account.getBalance());

        Account account1 = new Account.AccountBuilder(2, 3423421l, 0.00).creditLimit(2500.00).build();

        System.out.println(account1.getCreditLimit());

        Person person = new Person("Matthew", 31, new Date(21338912747182L), "blue", 3);
        System.out.println(person.getDob().toLocaleString());
        person.dob.setYear(1992);
        System.out.println(person.getDob().toLocaleString());

        painList.add("First");
        System.out.println(person.toString());

        Bicycle bike1 = new BMXBike();
        Bicycle bike2 = new MountainBike();
        Bicycle bike3 = new Bicycle() {
            @Override
            public void changeCadence(int newValue) {

            }

            @Override
            public void changeGear(int newValue) {

            }

            @Override
            public void speedUp(int newValue) {

            }

            @Override
            public void applyBrakes(int decrement) {

            }
        };

        Plant plant = new Plant() {
            @Override
            public void grow() {

            }

            @Override
            public void die() {

            }
        };

        Plant aloeVera = new AloeVera("Aloe Vera", "Aloe", 25.00);

        System.out.println(aloeVera.getName());
    }
}