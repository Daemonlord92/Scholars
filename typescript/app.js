"use strict";
let tName = "Matthew";
const student = {
    name: "Sam",
    age: 33,
    isGamer: false,
    becomeGamer: function () {
        this.isGamer = true;
    }
};
console.table(student);
const dog = {
    name: "Buddy",
    race: "Canis",
    age: 6,
    dob: new Date("2018-08-21"),
    isOceanic: false,
    doesFly: false,
    makeSound: function () {
        console.log("Woof");
    },
    eat: function () {
        console.log("Crunch");
    }
};
console.table(dog);
dog.makeSound();
dog.eat();
