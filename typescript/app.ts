let tName:string = "Matthew";

//tName = 10

interface Person {
    name: string;
    age: number;
    isGamer: boolean;
    becomeGamer: () => void;
  }
  
  const student: Person = {
    name: "Sam",
    age: 33,
    isGamer: false,
    becomeGamer: function (): void {
      this.isGamer = true;
    }
  };

console.table(student);


interface Animal {
    name: string,
    race: string,
    age: number,
    dob: Date,
    isOceanic: boolean,
    doesFly: boolean,
    makeSound:() => void,
    eat:() => void
}

const dog:Animal = {
    name: "Buddy",
    race: "Canis",
    age: 6,
    dob: new Date("2018-08-21"),
    isOceanic: false,
    doesFly: false,
    makeSound: function (): void {
        console.log("Woof")
    },
    eat: function (): void {
        console.log("Crunch")
    }
}

console.table(dog)

dog.makeSound()
dog.eat()