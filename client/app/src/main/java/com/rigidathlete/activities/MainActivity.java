package com.rigidathlete.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.rigidathlete.R;

public class MainActivity extends AppCompatActivity {
    private Button addWorkoutButton, photoProgressButton, apiIntegrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addWorkoutButton = findViewById(R.id.addWorkoutButton);
        photoProgressButton = findViewById(R.id.photoProgressButton);
        apiIntegrationButton = findViewById(R.id.apiIntegrationButton);

        addWorkoutButton.setOnClickListener(v -> startActivity(new Intent(this, AddWorkoutActivity.class)));
        photoProgressButton.setOnClickListener(v -> startActivity(new Intent(this, PhotoProgressActivity.class)));
        apiIntegrationButton.setOnClickListener(v -> startActivity(new Intent(this, ApiIntegrationActivity.class)));
    }
}
