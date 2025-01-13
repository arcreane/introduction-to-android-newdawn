package com.rigidathlete.network;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("wod.json")
    Call<List<String>> getWorkoutPlans();
}
