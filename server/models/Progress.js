const mongoose = require('mongoose');

const ProgressSchema = new mongoose.Schema({
    user: { type: String, required: true },
    photoUrl: { type: String },
    date: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Progress', ProgressSchema);
