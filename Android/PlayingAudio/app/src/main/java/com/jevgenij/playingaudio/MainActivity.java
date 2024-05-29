package com.jevgenij.playingaudio;

import static com.jevgenij.playingaudio.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button btn;

    SeekBar volumeSeekBar;
    AudioManager audioManager;

    TextView tvVolume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, raw.stuff);
        btn = findViewById(id.btn);
        tvVolume = findViewById(R.id.tv_Volume);

        tvVolume.setText("0 %");

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar = findViewById(id.volumeSeekBar);
        volumeSeekBar.setMax(maxVolume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Progress volume change: ", "" + progress);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                tvVolume.setText("" + progress +" %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    pause();
                } else {
                    play();
                }
            }
        });
    }

    public void play() {
        mediaPlayer.start();
        btn.setText("Pause");
    }

    public void pause() {
        mediaPlayer.pause();
        btn.setText("Play");
    }
}