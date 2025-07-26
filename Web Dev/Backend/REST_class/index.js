const express = require('express');
const app = express();
const port = 3000;
const path = require('path');
const { v4: uuidv4 } = require('uuid');
const methodOverride= require("method-override");

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(methodOverride('_method'));

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(express.static(path.join(__dirname, 'public')));

let posts = [
    {
        id: uuidv4(),
        username: 'manish',
        content: 'This is my first post',
    },
    {
        id: uuidv4(),
        username: 'john',
        content: 'Hello everyone, this is John!',
    },
    {
        id: uuidv4(),
        username: 'jane',
        content: 'Good morning! Hope you all have a great day!',
    },
    {
        id: uuidv4(),
        username: 'doe',
        content: 'Just finished reading a great book!',
    },
    {
        id: uuidv4(),
        username: 'smith',
        content: "Can't wait for the weekend!",
    },
];

app.get('/posts', (req, res) => {
    res.render('index.ejs', { posts });
});

app.get('/posts/new', (req, res) => {
    res.render('new.ejs');
});

app.post('/posts', (req, res) => {
    const { username, content } = req.body; 
    let id = uuidv4();
    posts.push({ id, username, content });
    res.redirect('/posts');
});

app.get("/posts/:id", (req,res) =>{
    const { id } = req.params;
    // console.log(id);
    const post = posts.find(p => p.id === id);
    res.render("show.ejs", { post });
});

app.patch('/posts/:id', (req, res) => {
    const { id } = req.params;
    let content = req.body.content;
    let post = posts.find(p => p.id === id);
    post.content = content;
    res.redirect("/posts");
});

app.get('/posts/:id/edit', (req, res) => {
    let { id } = req.params;
    let post = posts.find(p => p.id === id);
    res.render("edit.ejs", { post });
});

app.delete('/posts/:id', (req, res) => {
    let { id } = req.params;
    posts = posts.filter(p => p.id != id);
    res.redirect("/posts");
});


app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});