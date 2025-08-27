package com.danthedev22.service;

import com.danthedev22.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;

public interface WeatherApiService {

        @GET("forecast.json")
        Call<WeatherResponse> getForecast(@Query("key") String apiKey,
                                          @Query("q") String location,
                                          @Query("days") int days);
}
