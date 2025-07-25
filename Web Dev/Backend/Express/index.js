const express = require("express");
const app = express();

let port = 8080;

app.listen(port , () =>{
    console.log("We are listening at port number ", port);
})

app.use((req , res) =>{
    console.log("we are receiving new request");
});