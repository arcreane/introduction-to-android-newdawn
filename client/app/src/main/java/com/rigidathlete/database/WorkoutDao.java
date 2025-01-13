package com.rigidathlete.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.rigidathlete.models.Workout;
import java.util.List;

@Dao
public interface WorkoutDao {
    @Insert
    void insert(Workout workout);

    @Query("SELECT * FROM workouts")
    List<Workout> getAllWorkouts();
}
