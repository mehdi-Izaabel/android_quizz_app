package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity {

    Button logout;
    Button tryagain;
    TextView tvPoints, tvPersonalBest;

    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        logout=findViewById(R.id.logout);
        tryagain=findViewById(R.id.tryagain);



        int points = getIntent().getExtras().getInt("points");

        tvPoints = findViewById(R.id.tvPoints);
        tvPersonalBest = findViewById(R.id.tvPersonalBest);

        tvPoints.setText("" + points);

        sharedPreferences = getSharedPreferences("pref", 0);

        int pointsSP = sharedPreferences.getInt("pointsSP", 0);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(points > pointsSP){

            pointsSP = points;

            editor.putInt("pointsSP", pointsSP);

            editor.commit();
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity4.this,mainactivity1.class);
                startActivity(intent);
            }
        });
        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}