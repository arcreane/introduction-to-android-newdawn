const Progress = require('../models/Progress');

const trackProgress = async (req, res) => {
    const { user, photoUrl } = req.body;

    try {
        const newProgress = new Progress({ user, photoUrl });
        await newProgress.save();
        res.status(201).json(newProgress);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

const getAllProgress = async (req, res) => {
    try {
        const progress = await Progress.find();
        res.status(200).json(progress);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

const deleteProgress = async (req, res) => {
    try {
        await Progress.findByIdAndDelete(req.params.id);
        res.status(200).json({ message: "Progress deleted successfully" });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

module.exports = { trackProgress, getAllProgress, deleteProgress };
