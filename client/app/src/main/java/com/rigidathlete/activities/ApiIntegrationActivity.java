package com.rigidathlete.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rigidathlete.R;
import com.rigidathlete.adapters.WorkoutAdapter;
import com.rigidathlete.network.ApiService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiIntegrationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button refreshButton;
    private WorkoutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_integration);

        recyclerView = findViewById(R.id.recyclerView);
        refreshButton = findViewById(R.id.refreshButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        refreshButton.setOnClickListener(v -> fetchWorkoutPlans());
    }

    private void fetchWorkoutPlans() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.wodgenerator.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getWorkoutPlans().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    adapter = new WorkoutAdapter(response.body());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(ApiIntegrationActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(ApiIntegrationActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
