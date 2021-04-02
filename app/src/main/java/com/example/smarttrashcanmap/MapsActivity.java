package com.example.smarttrashcanmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.widget.Toast;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;

import com.google.android.gms.location.LocationListener;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback
         {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    LatLng sTCPrimeLat;
    String sTCPLat;
    String sTCPrimeLong;
    Double Latitude;
    Double Longitude;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        getData();

    }

    private void getData() {



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {



        mMap = googleMap;
        firebaseDatabase=firebaseDatabase.getInstance();

        databaseReference=firebaseDatabase.getReference("STC_ID/STC_Prime/GPS_Coordinates");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                HashMap<String, Double> data = (HashMap<String, Double>) dataSnapshot.getValue();
                double latitude = data.get("Latitude");
                double longitude = data.get("Longitude");
                LatLng STCPrime=new LatLng(latitude,longitude);
                mMap.addMarker(new MarkerOptions().position(STCPrime).title("STC_Prime").icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.ic_baseline_restore_from_trash_high)));
                //sTCPLat = snapshot.getValue(String.class);


                // after getting the value we are setting
                // our value to our text view in below line.
                //retriveTV.setText(sTCPrimeLat);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(MapsActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));

            if (!success) {
                Log.e("MapActivity", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapActivity", "Can't find style. Error: ", e);
        }
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng Colombo = new LatLng(6.9271, 79.8612);
        LatLng Maharagama = new LatLng(6.8511, 79.9212);
        LatLng UnityPlaza = new LatLng(6.8937, 79.8553);
        LatLng MajesticCity = new LatLng(6.8940, 79.8547);
        LatLng Crescat = new LatLng(6.9171, 79.8485);
        LatLng Savoy3D = new LatLng(6.8792, 79.8596);
        //LatLng STCPrime= new LatLng(latitude,45.456);
//        LatLng CurrentLoc = new LatLng;
        mMap.addMarker(new MarkerOptions().position(Colombo).title("Marker in Colombo").icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.ic_baseline_restore_from_trash_good)));
        mMap.addMarker(new MarkerOptions().position(Maharagama).title("Marker in Maharagama").icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.ic_baseline_restore_from_trash_high)));
        mMap.addMarker(new MarkerOptions().position(UnityPlaza).title("Marker in UnityPlaza").icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.ic_baseline_restore_from_trash_good)));
        mMap.addMarker(new MarkerOptions().position(MajesticCity).title("Marker in MajesticCity").icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.ic_baseline_restore_from_trash_high)));
        mMap.addMarker(new MarkerOptions().position(Crescat).title("Marker in Crescat").icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.ic_baseline_restore_from_trash_good)));
        mMap.addMarker(new MarkerOptions().position(Savoy3D).title("Marker in Savoy3D").icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.ic_baseline_restore_from_trash_high)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Colombo, 13f));

       /* if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }*/
    }

     /*   protected synchronized void buildGoogleApiClient()
        {
            googleApiClient=new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
*/



    private BitmapDescriptor bitmapDescriptorFromVector(Context context,int vectorResId)
    {
        Drawable vectorDrawable= ContextCompat.getDrawable(context,vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap= Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
/*
    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest=new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,locationRequest,this);
        }





    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }*/
}