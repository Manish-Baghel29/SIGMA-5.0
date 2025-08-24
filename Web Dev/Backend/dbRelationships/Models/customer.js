const mongoose = require('mongoose');
const { Schema } = mongoose;

main().then(console.log('Connected to MongoDB')).catch(err => console.log(err));

async function main() {
    await mongoose.connect('mongodb://127.0.0.1:27017/relations');
}

const orderSchema = new Schema({
    item: String,
    price: Number,
});

const customerSchema = new Schema({
    name: String,
    orders:[
        {
            type: Schema.Types.ObjectId, 
            ref: 'Order',
        }
    ],
});

const Order = mongoose.model("Order", orderSchema);
const Customer = mongoose.model("Customer", customerSchema);

const findCustomers = async ()=>{
    let result = await Customer.find({}).populate('orders');
    console.log(result[0]);
};

findCustomers();

// const addCustomer = async ()=>{
//     let customer1 = new Customer({
//         name:"Harsh roy"
//     });
//     customer1.orders.push(await Order.findOne({item:'Milk'}));
//     customer1.orders.push(await Order.findOne({item:'fruits'}));

//     let result = await customer1.save();
//     console.log(result);
// };

// addCustomer();

// const addOrders = async () => {
//     let result = await Order.insertMany([
//         {
//             item: 'Cake',
//             price: 500,
//         },
//         {
//             item: 'Milk',
//             price: 75,
//         },
//         {
//             item: 'fruits',
//             price: 90,
//         },
//     ]);
//     console.log(result);
// };

// addOrders();