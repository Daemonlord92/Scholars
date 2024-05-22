let noOfBooks = 4;
let booksPrice = 5.99;

//noOfBooks = "six books";

const errorMessage = "An error has occurred!";

// errorMessage = "Happy fun time";

console.log(errorMessage);

console.log("Addition")
console.log(noOfBooks + booksPrice)
console.log("Subtraction")
console.log(noOfBooks - booksPrice)
console.log("Multiply")
console.log(noOfBooks * booksPrice)
console.log("Division Part 1")
console.log(noOfBooks / booksPrice)
console.log("Division Part 2")
console.log(noOfBooks % booksPrice)

console.log(0=="0")
console.log(0===0)
console.log(4=="5")
const exampleFunction = () => {
    return 100;
}

function fizzBuzz() {
    for (let noOfTimes = 0; noOfTimes < exampleFunction(); noOfTimes++) {
        if(noOfTimes % 5 === 0 && noOfTimes % 3 === 0 ) {// ||
            console.log("FizzBuzz")
        }
        else if ( noOfTimes % 5 === 0 && !noOfTimes % 3 === 0) {
            console.log("Fizz")
        }
        else if( noOfTimes % 3 === 0) {
            console.log("Buzz")
        }
        else {
            console.log(noOfTimes)
        }
    }
}

//fizzBuzz()
const handleSubmit = () => {
    const name = document.getElementById("name")
    const password = document.getElementById("password")
    const race = document.getElementById("race")
    const dob = document.getElementById("dob")

    alert(JSON.stringify({
        "name": name.value,
        "password": password.value,
        "race": race.value,
        "dob": dob.value
    }))
    return false
}