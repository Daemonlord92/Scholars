package org.blitmatthew;


import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(new Date());
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDate birthday = LocalDate.parse("1992-07-21");
        System.out.println(birthday);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = birthday.format(formatter);
        System.out.println(formattedDate);

        LocalDate newDate = localDate.plusDays(7);
        System.out.println(newDate);
    }
}