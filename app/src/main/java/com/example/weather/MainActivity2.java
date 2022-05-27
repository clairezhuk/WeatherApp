package com.example.weather;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.Activity2.WeatherOneDayApi;
import com.example.weather.components.Example;
import com.example.weather.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        EditText editText=findViewById(R.id.city);
        String city = getIntent().getExtras().get("Key").toString();
        editText.setText(city);
        Log.i("Jane MainActivity2",getIntent().getExtras().get("Key").toString());


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")//базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create())//конвертер
                .build();
        WeatherOneDayApi weatherOneDayApi;
        weatherOneDayApi=retrofit.create(WeatherOneDayApi.class);//создали объект, с его помощью будем отправлять запросы
        weatherOneDayApi.getWeatherByCityName(city,"3d822b9dce4e57f12b9b3400d480a358").
                enqueue(new Callback<Example>() {//aссинхронный вызов (для синхронного был бы метод execute() )
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.isSuccessful()) {
                            String wind_responce = response.body().getWind().getSpeed().toString()+"m/s";
                            Log.i("Jane", wind_responce);
                            Log.i("Jane", "OK");
                            EditText wind = findViewById(R.id.wind);
                            wind.setText(wind_responce);
                            String temp_response = response.body().getMain().getTemp().toString()+"K";
                            EditText temp = findViewById(R.id.temp);
                            temp.setText(temp_response);
                        } else Log.i("Jane", "no reponse");
                    }
                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.i("Jane","Failure "+t);
                    }
                });

    }
}