const express = require('express');
const router = express.Router();
const { addWorkout, getWorkouts } = require('../services/workout.service');

router.post('/', addWorkout);
router.get('/', getWorkouts);

module.exports = router;
