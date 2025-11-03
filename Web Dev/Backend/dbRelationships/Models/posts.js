const mongoose = require('mongoose');
const { Schema } = mongoose;


main().then(console.log('Connected to MongoDB')).catch(err => console.log(err));

async function main() {
    await mongoose.connect('mongodb://127.0.0.1:27017/relations');
}

const postSchema = new Schema({
    content: String,
    likes: Number,
    user: {
        type: Schema.Types.ObjectId,
        ref: 'User',
    },
});

const userSchema = new Schema({
    username: String,
    email: String,
});

// userSchema.pre('findOneAndDelete' , async()=>{
//     console.log('Pre middleware and user is');
// });

userSchema.post('findOneAndDelete' , async(user)=>{
    let res = await Post.deleteMany({user: user});
    console.log(res);
});

const User = mongoose.model('User', userSchema);
const Post = mongoose.model('Post',postSchema);

const addUser = async () => {
    await User.findOneAndDelete({username:'manishbaghel'});
    let result = await User.insertOne({
        username: 'manishbaghel',
        email: 'mbaghel@gmail.com',
    });
    console.log(result);
};

const addPost = async()=>{
    await Post.deleteMany({});
    let res = await Post.insertMany([
        {
            content:"Breaking Bad Story!",
            likes:75000,
            user:await User.findOne({username : "manishbaghel"}),
        },
        {
            content:"GOT Story!",
            likes:73000,
            user:await User.findOne({username : "manishbaghel"}),
        },
    ]);

    console.log(res);
};

addUser();
addPost();

// async function findPosts(){
//     let result = await Post.find({});
//     console.log(result);
// }

// findPosts();

const delUser = async ()=>{
    let res= await User.findByIdAndDelete('68ab2190bde05ca2c5dd8f8b'); //replace id accordingly.
    console.log(res);
};

delUser();