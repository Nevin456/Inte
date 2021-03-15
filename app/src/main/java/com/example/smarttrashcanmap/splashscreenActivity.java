package com.example.smarttrashcanmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class splashscreenActivity extends AppCompatActivity {

    ImageView logo,appName,splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-1600).setDuration(3000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(3000).setStartDelay(4000);
        appName.animate().translationY(2000).setDuration(3000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2000).setDuration(3000).setStartDelay(4000);
    }
}