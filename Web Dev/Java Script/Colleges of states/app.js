let url = "http://universities.hipolabs.com/search?name=india";

let btn = document.querySelector("button");
let inp = document.querySelector("input");
let list = document.querySelector("ul");

btn.addEventListener("click" , async () => {
    // console.log(inp.value);
    let colArr = await getCol();
    // console.log(colArr);
    showCol(colArr);
} )

function showCol(colArr){
    list.innerText="";
    let state = inp.value;
    for(col of colArr){
        if(col["state-province"] === state){
            let li = document.createElement("li");
            li.innerText=col.name;
            list.appendChild(li);
        }
    }
}

async function getCol() {
    try{
        let res = await axios.get(url);
        return res.data;
    }
    catch(e){
        return [];
    }
}