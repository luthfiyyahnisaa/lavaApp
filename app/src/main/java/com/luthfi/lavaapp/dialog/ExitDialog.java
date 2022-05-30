package com.luthfi.lavaapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.luthfi.lavaapp.R;

public class ExitDialog extends Dialog implements View.OnClickListener{
    public Activity c;
    public Dialog d;
    public ImageButton btnOk, btnClose;
    MediaPlayer mediaPlayer;

    public ExitDialog(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_exit);
        btnOk = findViewById(R.id.btn_ok);
        btnClose = findViewById(R.id.btn_close);
        btnOk.setOnClickListener(this);
        btnClose.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mediaPlayer = MediaPlayer.create(c, R.raw.btn_click);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
        switch (v.getId()) {
            case R.id.btn_ok:
                c.finish();
                break;
            case R.id.btn_close:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
