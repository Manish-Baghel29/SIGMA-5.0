let para1 = document.createElement('p');
para1.innerText = "Hey I'm Red!";
document.querySelector('body').appendChild(para1);
para1.classList.add('red');

let h3 = document.createElement('h3');
h3.innerText="I'm blue h3!";
document.querySelector('body').appendChild(h3);
h3.style.color = "blue";

let div=document.createElement("div");
document.querySelector('body').appendChild(div);
div.style.backgroundColor = 'pink';
let h1 = document.createElement('h1');
h1.innerText = "I'm in a div";
let para2 = document.createElement('p');
para2.innerText="Me too"
div.append(h1);
div.append(para2);