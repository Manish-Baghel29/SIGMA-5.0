let todo=[];
let req=prompt("Enter your choice !! ");
while(req!="Quit"){
    if(req=="List"){
        let k=0;
        console.log("______________");
        for(i of todo){
            console.log(`${k}. `,i);
            k++;
        }
        console.log("______________");
    }else if(req=="Add"){
        let task=prompt("Enter your task !!");
        todo.push(task);
        console.log("Task Added.");
    }else if(req=="Remove"){
        let remove=prompt("Enter index of task to remove.");
        remove=parseInt(remove);
        todo.splice(remove,1);
        console.log("Task Removed.");
    }else{
        console.log("You have entered wrong choice please choose correct choice.");
    }
    req=prompt("Enter your choice !! ");
}
if(req=="Quit"){
    console.log("Quitting App.");
}