package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.Activity1.MessageAPI;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        MessageAPI messageAPI=retrofit.create(MessageAPI.class);

        editText = findViewById(R.id.editText);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Jane","Activity2");
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Key",editText.getText().toString());
                startActivity(intent);

            }

        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Jane","Activity3");
                Intent intent=new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra("Key",editText.getText().toString());
                startActivity(intent);

            }

        });
        //ImageView imageView=findViewById(R.id.image1);
        //new ImageDownloader(imageView).execute("https://i.ebayimg.com/images/g/fkwAAMXQya1Q7h1o/s-l400.jpg ");

        /*
        Call<String> message=messageAPI.message();
        message.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Sveta",""+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Sveta","Failure"+t);
            }
        });
         */

    }

}