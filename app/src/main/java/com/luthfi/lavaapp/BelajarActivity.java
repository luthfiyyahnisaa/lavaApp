package com.luthfi.lavaapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.luthfi.lavaapp.data.MateriBinatang;

public class BelajarActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNama, tvMakanan, tvJenis, tvKarakteristik, tvDeskripsi;
    ImageView imgGambar;
    ImageButton btnBack, btnPrev, btnNext;
    MediaPlayer mediaPlayer, suaraHewan;
    Button btnSuara;
    int arr;
    int x;
    MateriBinatang materiBinatang = new MateriBinatang();
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);
        setupAnimation();
        initComponents();
        setMateri();
        clickListeners();
    }

    private void initComponents() {
        tvNama = findViewById(R.id.tv_nama);
        tvMakanan = findViewById(R.id.tv_makanan);
        tvJenis = findViewById(R.id.tv_jenis);
        tvKarakteristik = findViewById(R.id.tv_karakteristik);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        imgGambar = findViewById(R.id.img_gambar);
        btnPrev = findViewById(R.id.btn_prev_materi);
        btnNext = findViewById(R.id.btn_next_materi);
        btnBack = findViewById(R.id.btn_back);
        btnSuara = findViewById(R.id.btn_soundPlay);
        nestedScrollView = findViewById(R.id.nestedScrollMateri);
        mediaPlayer = MediaPlayer.create(this, R.raw.btn_click);
        mediaPlayer.setLooping(false);
    }

    private void clickListeners() {
        btnBack.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnSuara.setOnClickListener(this);
    }

    private void setupAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    private void setMateri() {
        if (x == 0) {
            btnPrev.setVisibility(View.GONE);
        } else if (x >= 4) {
            btnNext.setVisibility(View.GONE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnPrev.setVisibility(View.VISIBLE);
        }
        arr = materiBinatang.nama.length;
        if (x >= arr) {
            Toast.makeText(this, "Ini terakhir!", Toast.LENGTH_SHORT).show();
        } else {
            nestedScrollView.smoothScrollTo(0, 0);
            imgGambar.setImageResource(materiBinatang.getGambar(x));
            tvNama.setText(materiBinatang.getNama(x));
            tvMakanan.setText(materiBinatang.getMakanan(x));
            tvJenis.setText(materiBinatang.getJenis(x));
            tvKarakteristik.setText(materiBinatang.getKarakteristik(x));
            tvDeskripsi.setText(materiBinatang.getDeskripsi(x));
            suaraHewan = MediaPlayer.create(this, materiBinatang.getSuara(x));
            suaraHewan.setLooping(false);
        }
    }

    @Override
    public void onClick(View view) {
        mediaPlayer.start();
        int id = view.getId();
        if (id == R.id.btn_back) {
            suaraHewan.stop();
            finish();
        } else if (id == R.id.btn_prev_materi) {
            x--;
            suaraHewan.stop();
            setMateri();
        } else if (id == R.id.btn_next_materi) {
            x++;
            suaraHewan.stop();
            setMateri();
        } else if (id == R.id.btn_soundPlay) {
            suaraHewan.start();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
