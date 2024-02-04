package com.jevgenij.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eraseImage(View view) {

        ImageView iv_anakin = findViewById(R.id.iv_anakin);
        ImageView iv_dartWader = findViewById(R.id.iv_dartWader);

        if(iv_anakin.getAlpha() == 0){
            iv_dartWader.animate().alpha(0).setDuration(2000);
            iv_anakin.animate().alpha(1).setDuration(2000);
        }else if(iv_dartWader.getAlpha() == 0){
            iv_dartWader.animate().alpha(1).setDuration(2000);
            iv_anakin.animate().alpha(0).setDuration(2000);
        }


    }
}