const mongoose = require('mongoose');
let Chat = require('./models/chat');
async function main() {
    await mongoose.connect('mongodb://127.0.0.1:27017/whatsapp');
}
main()
.then(() => {
    console.log("Connected to MongoDB successfully!");
})
.catch(err => console.log(err));

let chats = [{
    sender: "Robb",
    receiver: "Snow",
    message: "Farewell snow!",
    createdAt: new Date()
}, {
    sender: "Snow",
    receiver: "Robb",
    message: "Goodbye Stark!, see me at castle black ",
    createdAt: new Date()
},{
    sender: "tyrion",
    receiver: "snow",
    message: "Bastard of winterfell!",
    createdAt: new Date()
}, {
    sender: "snow",
    receiver: "tyrion",
    message: "Dwarf of casterly rock!",
    createdAt: new Date()
},{
    sender: "Sansa",
    receiver: "Council",
    message: "Winterfell is the capital of the North!",
    createdAt: new Date()
},
];

Chat.insertMany(chats)
.then((res) => {
    console.log("Chats inserted successfully:", res);
})
.catch(err => console.log("Error inserting chats:", err));