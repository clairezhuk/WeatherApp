package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.weather.week.Example;
import com.example.weather.week.List;
import com.example.weather.week.MyRecyclerViewAdapter;
import com.example.weather.week.WeatherWeekService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity3 extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    private java.util.List<List> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle=getIntent().getExtras();
        EditText editText=findViewById(R.id.city);
        String city = getIntent().getExtras().get("Key").toString();
        editText.setText(city);
        Log.i("Jane MainActivity3",getIntent().getExtras().get("Key").toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")//базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create())//конвертер
                .build();
        RecyclerView recyclerView;
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        WeatherWeekService weatherWeekService;
        weatherWeekService=retrofit.create(WeatherWeekService.class);//создали объект, с его помощью будем отправлять запросы
        weatherWeekService.getWeatherByCityName(city,"3d822b9dce4e57f12b9b3400d480a358").
                enqueue(new Callback<Example>() {//aссинхронный вызов (для синхронного был бы метод execute() )
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.isSuccessful()) {
                            adapter = new MyRecyclerViewAdapter(getApplicationContext(),response.body().getList());
                            adapter.setClickListener(MainActivity3 .this::onItemClick);
                            recyclerView.setAdapter(adapter);

                            Log.i("Jane", "OK");


                        } else Log.i("Jane", "no reponse");
                    }
                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.i("Jane","Failure "+t);
                    }
                });

    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}