package com.luthfi.lavaapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;

import com.luthfi.lavaapp.R;

public class AboutDialog extends Dialog {
    public Activity c;
    public Dialog d;
    public ImageButton btnhide;
    MediaPlayer mediaPlayer;

    public AboutDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_about);
        mediaPlayer = MediaPlayer.create(c, R.raw.btn_click);
        mediaPlayer.setLooping(false);
        btnhide = findViewById(R.id.btn_hide);
        btnhide.setOnClickListener(view -> {
            mediaPlayer.start();
            dismiss();
        });

    }
}
