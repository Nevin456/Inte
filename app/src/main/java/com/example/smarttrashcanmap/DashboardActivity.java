package com.example.smarttrashcanmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


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






        cardM.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    cardM.setCardBackgroundColor(cardM.getResources().getColor(R.color.green));
                openMap();}

                else if(event.getAction()==MotionEvent.ACTION_UP){
                    cardM.setCardBackgroundColor(cardM.getResources().getColor(R.color.white));
                }

                return true;
            }
        });


    }
    public void openMap(){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}