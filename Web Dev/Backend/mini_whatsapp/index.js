const mongoose = require('mongoose');
const express = require('express');
const app= express();
const path = require('path');
const methodOverride= require('method-override');
let Chat = require('./models/chat');

app.set('view engine', 'ejs');
app.set("views", path.join(__dirname, '/views'));
app.use(express.urlencoded({ extended: true }));
app.use(methodOverride('_method'));

async function main() {
    await mongoose.connect('mongodb://127.0.0.1:27017/whatsapp');
}

main()
.then(() => {
    console.log("Connected to MongoDB successfully!");
})
.catch(err => console.log(err));

// Root route
app.get('/', (req, res) => {
    res.send("Welcome to the WhatsApp Clone!");
});

// Index route to display chats
app.get("/chats", async (req, res) => {
    let chats = await Chat.find({});
    res.render("index.ejs", { chats });
});

// New route to create a new chat
app.get("/chats/new", (req, res) => {
    res.render("new.ejs");
});

// Create route to save a new chat
app.post("/chats",(req, res) => {
    let { sender, receiver, message } = req.body;
    let chat = new Chat({ sender, receiver, message });
    chat.save()
    .then(() => {
        res.redirect("/chats");
    })
    .catch(err => console.log("Error creating chat:", err));
});

// edit route to show the edit form
app.get("/chats/:id/edit", (req, res) => {
    let { id } = req.params;
    Chat.findById(id)
    .then(chat => {
        res.render("edit.ejs", { chat });
    })
});

// update route to save the edited chat
app.patch("/chats/:id", async (req, res) => {
    let { id } = req.params;
    let { message: newMsg } = req.body;
    await Chat.findByIdAndUpdate(id, { createdAt: Date.now() });
    Chat.findByIdAndUpdate(id, { message: newMsg })  
    .then(() => {
        res.redirect("/chats");
    })
    .catch(err => console.log("Error updating chat:", err));
});

// Destroy route to delete a chat
app.delete("/chats/:id", (req, res) => {
    let { id } = req.params;
    Chat.findByIdAndDelete(id)
    .then(() => {
        res.redirect("/chats");
    })
    .catch(err => console.log("Error deleting chat:", err));
});

app.listen(8080, ()=>{
    console.log("Server is running on port 8080");
});