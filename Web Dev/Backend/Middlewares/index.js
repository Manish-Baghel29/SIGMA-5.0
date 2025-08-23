const express = require('express');
const app = express();
const myError = require('./ExpressError');

const checkToken = (req,res,next)=>{
    let {token} = req.query;
    if(token ==='giveaccess'){
        next();
        return;
    }
    throw new myError(401 ,"Access denied!");
};

app.get('/api', checkToken , (req,res)=>{
    res.send("DATA INFO!!!")
})

app.get('/err' , (req,res)=>{
    abcd = abcd;
});

app.get('/admin', (req,res)=>{
    throw new myError(403,'Access to admin is forbidden')
});

app.use((err, req, res, next)=>{
    console.log('___Error___');
    let {status=500 , message = 'Some error occurred'} = err;
    res.status(status).send(message);
});


app.listen(8080 , ()=>{
    console.log("Server is listening at port 8080");
});