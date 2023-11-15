package com.jevgenij.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    String text = "Hello Java!";
    public void setHelloJavaText(View view) {
        TextView textView = findViewById(R.id.tv_hello);
        if (textView.getText().toString().contains("World")){
            textView.setText(text);
            textView.setBackgroundColor(Color.CYAN);
            textView.setTextSize(24);
        } else {
            textView.setText("Hello World!");
            textView.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
            textView.setTextSize(12);
        }
    }
}