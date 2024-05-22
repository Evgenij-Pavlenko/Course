package com.jevgenij.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mediaPlayer = MediaPlayer.create(this,R.raw.stuff);

    }

    public void play(View view) {
        Button btn = findViewById(R.id.btn);
        if(btn.getText().equals("Play")){
            mediaPlayer.start();
            btn.setText("Pause");
        } else{
            mediaPlayer.pause();
            btn.setText("Play");
        }

    }
}