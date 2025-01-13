const Workout = require('../models/Workout');

const addWorkout = async (req, res) => {
    const { user, exercise, sets, reps, weight } = req.body;
    try {
        const workout = new Workout({ user, exercise, sets, reps, weight });
        await workout.save();
        res.status(201).json(workout);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

const getWorkouts = async (req, res) => {
    try {
        const workouts = await Workout.find();
        res.status(200).json(workouts);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

module.exports = { addWorkout, getWorkouts };
