package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
    }
    public void startGame(View view) {
        // In startGame() method, create an Intent to launch StartGame Activity
        Intent intent = new Intent(MainActivity2_5.this, MainActivity3.class);
        startActivity(intent);
        // Finish MainActivity
        finish();
    }
}