const mongoose = require('mongoose');

const WorkoutSchema = new mongoose.Schema({
    user: { type: String, required: true },
    exercise: { type: String, required: true },
    sets: { type: Number, required: true },
    reps: { type: Number, required: true },
    weight: { type: Number, required: true },
    date: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Workout', WorkoutSchema);
