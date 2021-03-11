package com.example.smarttrashcanmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.SignInButton;

public class Main extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.SignIn);
        Button button3=findViewById(R.id.SignUp);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(Main.this,MapsActivity.class));
                break;
            case R.id.SignIn:
                startActivity(new Intent(Main.this,LoginActivity.class));
                break;
            case R.id.SignUp:
                startActivity(new Intent(Main.this,SignUpActivity.class));
                break;

            default:
                break;
        }
    }
}