package com.example.smarttrashcanmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.SignInButton;

public class Main extends AppCompatActivity {

    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        /*button2=findViewById(R.id.SignIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
*/

    }

    public void openMap(){
        Intent intent1=new Intent(this,MapsActivity.class);
        startActivity(intent1);
    }

    public void openLogin()
        {
            Intent intent2 = new Intent(this, LoginActivity.class);
            startActivity(intent2);
        }
}