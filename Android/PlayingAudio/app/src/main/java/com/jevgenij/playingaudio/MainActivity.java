package com.jevgenij.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.stuff);
        btn = findViewById(R.id.btn);
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