let inp=document.querySelector("input");
let btn=document.querySelector("button");
let ul=document.querySelector("ul");

btn.addEventListener("click" , function(){
    let item = document.createElement('li');
    item.innerText = inp.value;

    let delBtn = document.createElement("button");
    delBtn.innerText = "delete";
    delBtn.classList.add("delete");

    item.appendChild(delBtn);
    ul.appendChild(item);
    inp.value="";
});


// here we use eventbubbling for deletion of tasks because eventListener doesn't work on new elements.
ul.addEventListener("click", function(event){
    if(event.target.nodeName == 'BUTTON'){
        let lt = event.target.parentElement;
        lt.remove();
    }
});