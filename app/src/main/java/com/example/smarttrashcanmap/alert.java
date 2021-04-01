package com.example.smarttrashcanmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class alert extends AppCompatActivity {
    TextView distance,level_status;
    DatabaseReference dref;
    String status;
    private int level,circleFinishedColor;
    Button cancel;
    CircleProgress circle;

    private static final String TAG="activity_alert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        distance = (TextView) findViewById(R.id.distance);
        level_status = (TextView) findViewById(R.id.status);
        dref= FirebaseDatabase.getInstance().getReference();
        Button cancel=(Button) findViewById(R.id.cancel2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                // startActivity(intent);

            }
        });
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=dataSnapshot.child("distance").getValue().toString();
                distance.setText(status);
                circle=findViewById(R.id.donut);
                if(level<=4.75){
                    circle.setFinishedColor(getResources().getColor(R.color.teal_700));
                    level_status.setText("Level is Below 25%. Attention not Needed!");

                }
                else if(level<=9.5){
                    circle.setFinishedColor(getResources().getColor(R.color.purple_700));
                    level_status.setText("Level is below 50%. Attention not Needed!");
                }
                else if(level<=14.25){
                    circle.setFinishedColor(getResources().getColor(R.color.yellow));
                    level_status.setText("Level is Below 75%. Attention not Needed!");
                }
                else{

                    level_status.setText("Level is Above 75%. Attention Needed!");
                    level_status.setTextColor(getResources().getColor(R.color.red));
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}

//https://developer.android.com/codelabs/advanced-android-training-sensor-data#3
//https://create.arduino.cc/projecthub/Technovation/smart-garbage-monitoring-system-us