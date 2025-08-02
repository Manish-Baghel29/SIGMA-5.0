const mongoose = require('mongoose');

let chatSchema = new mongoose.Schema({
    sender: {
        type: String,
    },
    receiver: {
        type: String,
        required: true,
    },
    message: {
        type: String,
        required: true,
    },
    createdAt: {
        type: Date,
        default: new Date(),
    }
});

let Chat = mongoose.model('Chat', chatSchema);

module.exports = Chat;