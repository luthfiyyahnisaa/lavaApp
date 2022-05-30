package com.luthfi.lavaapp;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {
    public static MediaPlayer player;

    public static void SoundPlayer(Context ctx, int raw_id, Boolean kondisi) {
        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);

        //player.release();
        if (kondisi) {
            player.start();
        } else {
            player.stop();
        }
    }
}
