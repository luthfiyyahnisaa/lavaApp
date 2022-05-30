package com.luthfi.lavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.luthfi.lavaapp.dialog.AboutDialog;
import com.luthfi.lavaapp.dialog.ExitDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMain, btnBelajar, btnRangking;
    ImageButton btnExit, btnSound, btnMenu, btnAbout;
    ImageView imgTitle;
    EditText etNama;
    LinearLayout linearMenu;
    MediaPlayer mediaPlayer;
    Animation fromLeft;
    Boolean kondisiSound = true;
    Boolean kondisiMenu = true;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        clickListeners();
    }


    private void initComponents() {
        btnMain = findViewById(R.id.btn_permainan);
        btnBelajar = findViewById(R.id.btn_belajar);
        btnRangking = findViewById(R.id.btn_rangking);
        btnExit = findViewById(R.id.btn_exit);
        btnSound = findViewById(R.id.btn_sound);
        btnMenu = findViewById(R.id.btn_menu);
        btnAbout = findViewById(R.id.btn_about);
        etNama = findViewById(R.id.et_nama);
        linearMenu = findViewById(R.id.linear_menu);
        mediaPlayer = MediaPlayer.create(this, R.raw.btn_click);
        mediaPlayer.setLooping(false);
        SoundManager.SoundPlayer(this, R.raw.music_game, true);
    }

    private void clickListeners() {
        btnMain.setOnClickListener(this);
        btnBelajar.setOnClickListener(this);
        btnRangking.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnSound.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mediaPlayer.start();
        int id = view.getId();
        nama = etNama.getText().toString();
        if (id == R.id.btn_permainan) {
            if (nama == null || nama.matches("")) {
                Toast.makeText(this, "Silahkan masukkan dulu nama...", Toast.LENGTH_SHORT).show();
                etNama.requestFocus();
            } else {
                Intent game = new Intent(this, GameActivity.class);
                game.putExtra("NAMA", nama);
                this.startActivity(game);
            }
        } else if (id == R.id.btn_belajar) {
            Intent belajar = new Intent(this, BelajarActivity.class);
            this.startActivity(belajar);
        } else if (id == R.id.btn_rangking) {
            Intent rangking = new Intent(this, RiwayatSkorActivity.class);
            this.startActivity(rangking);
        } else if (id == R.id.btn_sound) {
            changeSound();
        } else if (id == R.id.btn_exit) {
            exitDialog();
        } else if (id == R.id.btn_menu) {
            showMenu();
        } else if (id == R.id.btn_about) {
            AboutDialog aboutDialog = new AboutDialog(this);
            aboutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            aboutDialog.show();
            Window window = aboutDialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onBackPressed() {
        exitDialog();
    }

    private void changeSound() {
        if (kondisiSound) {
            btnSound.setImageResource(R.drawable.sound_off);
            SoundManager.player.setVolume(0, 0);
            kondisiSound = false;
        } else {
            btnSound.setImageResource(R.drawable.sound);
            SoundManager.player.setVolume(1, 1);
            kondisiSound = true;
        }
    }

    private void showMenu() {
        if (kondisiMenu) {
            TransitionManager.beginDelayedTransition(linearMenu, new Slide(Gravity.END));
            btnMenu.setImageResource(R.drawable.btn_close2);
            linearMenu.setVisibility(View.VISIBLE);
            kondisiMenu = false;
        } else {
            TransitionManager.beginDelayedTransition(linearMenu, new Slide(Gravity.END));
            btnMenu.setImageResource(R.drawable.btn_menu);
            linearMenu.setVisibility(View.GONE);
            kondisiMenu = true;
        }
    }

    private void exitDialog() {
        ExitDialog exitDialog = new ExitDialog(this);
        exitDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        exitDialog.show();
        Window window = exitDialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (SoundManager.player.isPlaying()) {
            SoundManager.player.stop();
        }
    }
}