package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mainactivity1 extends AppCompatActivity {
    // declare objects
    EditText email;
    EditText password;
    Button signin;
    TextView toregister;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if user is signed in (non-null) and update UI accordingly.
    /*   FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }*/

        //récuperer les elements


        /*signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("message", email.getText().toString());
                if (email.getText().equals("izaabelmehdi@gmail.com") && password.getText().equals("mehdi")) {
                    Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG);
                }
            }

        });*/
       /* signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //authenticateUser();
            }}*/
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        signin = findViewById(R.id.button);
        toregister = findViewById(R.id.register);


        signin.setOnClickListener((view -> {

            Log.i("message", email.getText().toString());
            Log.i("message1",password.getText().toString());

            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(mainactivity1.this, MainActivity2_5.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(mainactivity1.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }));


        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mainactivity1.this, MainActivity2.class);
                startActivity(intent);
            }


        });
    }

  /*  private void authenticateUser() {

        String Email = email.getText().toString();
        String Password = password.getText().toString();

        if (Email.isEmpty() || Password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(mainactivity1.this,MainActivity3.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(mainactivity1.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }*/
}
