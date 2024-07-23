//Blocked scoped Varible that is resignable
let number = 10;

function add(a, b) {
    //Function Scoped variable, that is also resignable
    let number2 = a + b;
    return number2;
}


console.log(add(14, 5));
console.log(add.number2);

//Blocked Scoped Variable, but CANNOT BE RESIGNED
const DATABASE_URL = "jdbc:mysql://localhost:3306/car-show";

//DATABASE_URL = "http://aws.udbwiwcw.us:3306/dbsdjk/car-show"

const greet = function() {
    console.log("Hello");
}

const welcoming = () => {
    console.log("Welcome to our humble home!");
}

greet();
welcoming();


const person = {
    name: "Matthew",
    age: 32,
    greet: function() {
        console.log("Hi, my name is " + this.name + " and I'm " + this.age + " years old!")
    }
}

person.greet()

const { name, age } = person;

console.log(name)

let arr1 = [1, 2, 3];
let arr2 = [...arr1, 4, 5, 6]

console.table(arr2)


let dog = {
    name: "Buddy"
}

console.table(dog)

dog = {
    ...dog,
    race: "Pitbull",
    demeaner: "Cuddly Teddy Bear"
}

console.table(dog)

const rAMData = new Promise((resolve, reject) =>{
    async function fetchData() {
        const response = await fetch('https://rickandmortyapi.com/api/character/?count=5')
        const data = await response.json();
        console.table(data)
        return data
    }

    resolve(fetchData())
});

rAMData.then(result => console.table(result)).catch(error => console.error(error));