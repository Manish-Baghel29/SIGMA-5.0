const mongoose = require('mongoose');
const { Schema } = mongoose;

main().then(console.log('Connected to MongoDB')).catch(err => console.log(err));

async function main() {
    await mongoose.connect('mongodb://127.0.0.1:27017/relations');

    // use `await mongoose.connect('mongodb://user:password@127.0.0.1:27017/test');` if your database has auth enabled
}

const userSchema = new Schema({
    username: String,
    addresses: [
        {
            _id: false,
            location: String,
            city: String
        }
    ]
});

let User = mongoose.model('User', userSchema);

const addUser = async () => {
    let user1 = new User({
        username: 'Tony Stark',
        addresses: [{
            location: 'Avergers Tower',
            city: 'New york'
        }],
    });
    user1.addresses.push({
        location:'k56 Bake street',
        city:'New Delhi'
    });

   let result = await user1.save();
   console.log(result);
};

addUser();