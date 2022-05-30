package com.luthfi.lavaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    ImageView imgSplash;
    TextView tvNameDev;
    Animation fromBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgSplash = findViewById(R.id.splashImage);
        tvNameDev = findViewById(R.id.nameDev);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        imgSplash.setAnimation(fromBottom);
        tvNameDev.setAnimation(fromBottom);



        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
