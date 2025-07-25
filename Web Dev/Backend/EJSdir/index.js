const express = require('express');
const app = express();
const path = require('path');
const port = 3000;

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, '/views'));

app.get('/ig/:username', (req, res) => {
  let { username } = req.params;
  const instaData = require("./data.json");
  let data = instaData[username];
  if (data) {
  res.render("instagram.ejs" , { data })
  } else{
    res.render("error.ejs", { message: "User not found" });
  }
});

app.get('/', (req, res) => {
  res.render("home.ejs");
});

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});