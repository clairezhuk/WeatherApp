package com.example.weather.week;

import com.example.weather.week.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherWeekService {
    @GET("/data/2.5/forecast")
    Call<Example> getWeatherByCityName(@Query("q") String city, @Query("appid") String appID);
}
