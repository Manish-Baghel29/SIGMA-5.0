// let num = prompt("Enter number : ");
// if(num%10 == 0){
//     console.log("Good");
// }
// else{
//     console.log("Bad");
// }
// let name = prompt("Enter you name : ");
// let age = prompt("Enter you age : ");
// alert(`${name} is ${age} years old`);

let a=prompt("Enter first number : ");
let b=prompt("Enter second number : ");
let al=a%10;
let bl=b%10;
console.log(al,bl);
if(al===bl){
    console.log("Last digit of both numbers is same.");
}
else{
    console.log("Last digit of both numbers is different.");
}