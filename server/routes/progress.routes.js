const express = require('express');
const router = express.Router();
const { trackProgress, getAllProgress, deleteProgress } = require('../services/progress.service');

router.post('/', trackProgress);
router.get('/', getAllProgress);
router.delete('/:id', deleteProgress);

module.exports = router;
