package org.blitmatthew;

import org.blitmatthew.test.Account;
import org.blitmatthew.test.Animal;
import org.blitmatthew.test.Bat;
import org.blitmatthew.test.Person;

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
    }
}