package com.example.smarttrashcanmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Test extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    String sTCPLat;
    Double sTCPrimeLat;
    String sTCPrimeLong;

    private TextView retrievetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);







        firebaseDatabase=firebaseDatabase.getInstance();

        databaseReference=firebaseDatabase.getReference("STC_ID/STC_Prime/GPS_Coordinates/Latitude");

        retrievetxt=findViewById(R.id.tV3);
        getData();

    }

    private void getData() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                sTCPLat = snapshot.getValue(String.class);
                sTCPrimeLat=Double.parseDouble(sTCPLat);

                retrievetxt.setText(sTCPLat);


                // after getting the value we are setting
                // our value to our text view in below line.
                //retriveTV.setText(sTCPrimeLat);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(Test.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}