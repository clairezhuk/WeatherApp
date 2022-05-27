package com.example.weather.Activity1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageAPI {
    @GET("https://api.openweathermap.org/data/2.5/weather?q=London&appid=3d822b9dce4e57f12b9b3400d480a358")
    Call<String> message();

}
