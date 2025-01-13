package com.rigidathlete.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.rigidathlete.database.AppDatabase;
import com.rigidathlete.database.WorkoutDao;
import com.rigidathlete.models.Workout;
import com.rigidathlete.R;

public class AddWorkoutActivity extends AppCompatActivity {
    private EditText exerciseName, sets, reps, weight;
    private Button addButton;
    private WorkoutDao workoutDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        exerciseName = findViewById(R.id.exerciseName);
        sets = findViewById(R.id.sets);
        reps = findViewById(R.id.reps);
        weight = findViewById(R.id.weight);
        addButton = findViewById(R.id.addButton);

        workoutDao = AppDatabase.getDatabase(getApplicationContext()).workoutDao();

        addButton.setOnClickListener(v -> {
            Workout workout = new Workout(exerciseName.getText().toString(),
                    Integer.parseInt(sets.getText().toString()),
                    Integer.parseInt(reps.getText().toString()),
                    Double.parseDouble(weight.getText().toString()));
            workoutDao.insert(workout);
        });
    }
}
