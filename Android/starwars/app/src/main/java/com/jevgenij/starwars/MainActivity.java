package com.jevgenij.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isAnakinVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_anakin = findViewById(R.id.iv_anakin);
        iv_anakin.setScaleX(0);
        iv_anakin.setScaleY(0);

        iv_anakin.animate().scaleX(1).scaleY(1).rotation(360).setDuration(2000);
    }

    public void eraseImage(View view) {

        ImageView iv_anakin = findViewById(R.id.iv_anakin);
        ImageView iv_dartWader = findViewById(R.id.iv_dartWader);

        if(isAnakinVisible){
            iv_dartWader.animate().alpha(1).setDuration(2000);
            iv_anakin.animate().alpha(0).setDuration(2000);
            isAnakinVisible = false;

        }else{
            iv_dartWader.animate().alpha(0).setDuration(2000);
            iv_anakin.animate().alpha(1).setDuration(2000);
            isAnakinVisible = true;
        }
    }
}