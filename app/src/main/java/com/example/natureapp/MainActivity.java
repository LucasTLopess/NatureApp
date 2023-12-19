package com.example.natureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonProfile = findViewById(R.id.button_profile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        SharedPreferences preferences = getSharedPreferences("profile", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "");

        if (name.isEmpty()) {
            TextView textViewHello = findViewById(R.id.text_view_hello);
            textViewHello.setText("Olá, como é seu nome?");
        } else {
            TextView textViewHello = findViewById(R.id.text_view_hello);
            textViewHello.setText("Olá, " + name);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("profile", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "");

        TextView textViewHello = findViewById(R.id.text_view_hello);
        if (name.isEmpty()) {
            textViewHello.setText("Olá, como é seu nome?");
        } else {
            textViewHello.setText("Olá, " + name);
        }
    }

}

