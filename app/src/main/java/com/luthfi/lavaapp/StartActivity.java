package com.luthfi.lavaapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnStart;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setupAnimation();
        btnStart = findViewById(R.id.btn_start);
        mediaPlayer = MediaPlayer.create(this, R.raw.btn_click);
        mediaPlayer.setLooping(false);

        btnStart.setOnClickListener(this);
    }

    private void setupAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onClick(View view) {
        mediaPlayer.start();
        int id = view.getId();
        if (id == R.id.btn_start) {
            Intent start = new Intent(StartActivity.this, MainActivity.class);
            startActivity(start);
            finish();
        }
    }
}
