const { faker } = require('@faker-js/faker');
const mysql = require('mysql2');
const express = require('express');
const app = express();
const path = require('path');
const methodOverride = require('method-override');
const { v4: uuidv4 } = require('uuid');

app.use(express.urlencoded({ extended: true }));
app.use(methodOverride('_method')); // For PUT and DELETE requests

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, '/views'));

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  database: 'delta_app',
  password: 'Manish@123#',
});

let getRandomUser = () => {
  return [
    faker.string.uuid(),
    faker.internet.username(), // before version 9.1.0, use userName()
    faker.internet.email(),
    faker.internet.password()
  ];
}

let data = [];
for (let i = 0; i < 525; i++) {
  data.push(getRandomUser());
}

{ // Insert data into the database
  // let q = `INSERT INTO users (id, username, email, password) VALUES ?`;
  // try {
  //   connection.query(q, [data], (err, result) => {
  //     if (err) {
  //       throw err;
  //     }
  //     console.log("Data inserted successfully!");
  //   });
  
  // }catch (error) {
  // console.error("Error inserting data into the database:", error);
  // }
}

// Root route
app.get('/', (req, res) => {
  let q = `Select count(*) from users`;
  try{
    connection.query(q ,(err, result) => {
      if (err) {
        throw err;
      }
      let count = result[0]['count(*)'];
      res.render("home.ejs", { count });
    });
  }catch (error) {
    res.send("Some error occured in MySQL!!");
  }
});

// Show route
app.get("/users", (req, res) => {
  let q = `Select * from users`;
  try{
    connection.query(q , (err, users) => {
      if (err) {
        throw err;
      }
      res.render("showUsers.ejs", { users });
    });
  }catch (error) {
    res.send("Some error occured in MySQL!!");
  }
});

// Edit route
app.get("/users/:id/edit", (req , res) => {
  let { id } = req.params;
  let q= `Select * from users where id='${id}'`;
  try{
    connection.query(q , (err, result) => {
      if (err) {
        throw err;
      }
      let user = result[0];
      res.render("edit.ejs" , { user });
    });
  }catch (error) {
    res.send("Some error occured in MySQL!!");
  }
});

// Update route
app.patch("/users/:id", (req, res) => {
  let { id } = req.params;    
  let { username : newUsername, password : formPass } = req.body;
  let q= `Select * from users where id='${id}'`;
  try{
    connection.query(q , (err, result) => {
      if (err) {
        throw err;
      }
      let user = result[0];
      if (user.password !== formPass) {
        res.send("Password is incorrect!!");
        return;
      }
      let q = `UPDATE users SET username='${newUsername}' WHERE email='${user.email}'`;
      try{
        connection.query(q , (err, result) => {
        if (err) {
        throw err;
        }
        res.redirect("/users");
        });
      }catch (error) {
        res.send("Some error occured in MySQL!!");
      }
    });
  }catch (error) {
    res.send("Some error occured in MySQL!!");
  }
});

// add account
app.get("/users/create", (req,res)=>{
  res.render("create.ejs");
});

// Create route
app.post("/users" , (req,res) =>{
  let {email , username , password , repassword} = req.body;
  if(password !== repassword){
    res.send("Both passwords :( doesn't match so try again!");
    return
  }
  let id=uuidv4();
  let newRow = [id , username , password ,email];
  let q = `INSERT INTO users (id , username , password , email) VALUES (?,?,?,?)`;
  try{
    connection.query(q , (newRow) , (err , result)=>{
      if(err){
      throw err;
    }
      res.redirect("/users");
    });

  }catch(err){
    res.send("Some error occured in DB :(");
  }
});

// delete account
app.get("/users/:id/delete" , (req,res) => {
  let { id } = req.params;
  res.render("delete.ejs" , { id });
})

// Destroy route
app.delete("/users/:id", (req, res) => {
  let { id } = req.params;
  // Assuming you want to delete the user by id
  let { email : formEmail , password : formPass } = req.body;
  let q = `SELECT * FROM users WHERE id='${id}'`;
  try{
    connection.query(q , (err , result) =>{
      if (err) {
        throw err;
      }
      let user = result[0];
      if (user.email !== formEmail || user.password !== formPass) {
        res.send("Email or Password is incorrect!!");
        return;
      }
      let q2 = `DELETE FROM users WHERE id='${id}'`;
      try{
        connection.query(q2, (err, result) => {
          if (err) {
            throw err;
          }
          res.redirect("/users");
        });
      }catch(err){
        res.send("Some error occured in MySQL!!");
      }
    })
  }catch(err){
    res.send("Some error occured in DB!!");
  }
});

app.listen(8080, () => {
  console.log('Server is running on port 8080');
});


