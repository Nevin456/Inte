package com.example.smarttrashcanmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class DashboardActivity extends AppCompatActivity {

    private CardView cardM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);


        cardM = findViewById(R.id.cardMap);

        cardM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });


    }
    public void openMap(){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}