package com.example.smarttrashcanmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class TrashCanUI extends AppCompatActivity {
    TextView distance;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dref;
    String status;
    private int level;
    CircleProgress circle;
    private static final String TAG="TrashCanUI";
//in order to show the dialog box nevin needs to add the code to the tag on map
  /* ImageView img = (ImageView) findViewById(R.id.showdialog);
    showdialog.setOnClickListener(new OnClickListener() {
    @override
        public void onClick(View v) {
          showDialog();
        }
    });
    }
    void showDialog(){
    LayoutInflater inflater=LayoutInflater.from(this);
View view =inflater.inflate(R.layout.alert,null);
        Button detailsbtn=view.findViewById(R.id.details);
        Button cancelbtn=view.findViewById(R.id.cancel);
        detailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, .class);
                startActivity(intent);

            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"onClick:cancel")
            }
        })
        AlertDialog alertdialog=new AlertDialog.Builder(this)
                .setView(view)
                .create();
        alertdialog.show();
}


   https://youtu.be/0W1e-ZCYr8k

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        distance = (TextView) findViewById(R.id.distance);
        dref= FirebaseDatabase.getInstance().getReference("STC_ID/STC_Prime");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=dataSnapshot.child("STC_Level").getValue().toString();
                distance.setText(status);
                if(level==4.75){

                }
                // int color = circle.setFinishedColor(R.styleable.CircleProgress );
                else if(level<=9.5){

                }
                else if(level<=14.25){

                }
                else{

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}

//https://developer.android.com/codelabs/advanced-android-training-sensor-data#3
//https://create.arduino.cc/projecthub/Technovation/smart-garbage-monito