let inp=document.querySelector('input');
let div=document.querySelector('div');
let btn=document.querySelector("button");
inp.addEventListener('input' , function(){

    btn.addEventListener("click",function(){
        let para=document.createElement("p");
        para.innerText = inp.value;
        inp.value="";
        div.appendChild(para);
    });
});