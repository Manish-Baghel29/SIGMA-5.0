let max = prompt("Enter maximum number !!");
const random = Math.floor(Math.random() * max) + 1;
let guess = prompt("Guess the number!!");

while(true){
    if(guess=="quit"){
        console.log("Quitting game!!");
        break;
    }else if(guess==random){
        console.log("You are right! random number was ",random);
        break;
    }else if(guess < random){
        guess=prompt("Your guess was too small !! please try again or just quit!!");
    }else{
        guess=prompt("Your guess was too large !! please try again or just quit!!");
    }
}