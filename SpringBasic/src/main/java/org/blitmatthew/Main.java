package org.blitmatthew;

import org.blitmatthew.vehicle.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Engine engine = new V6Engine();
        Engine engine1 = new V8Engine();
//Simple comment
        //Vehicle car = new Car((Engine) applicationContext.getBean("v6Engine"));
        Vehicle car = applicationContext.getBean("carV6", Car.class);

//        Vehicle car1 = new Car(engine1);

        Vehicle car1 = applicationContext.getBean("car", Car.class);

        car.start();

        car1.start();
    }
}