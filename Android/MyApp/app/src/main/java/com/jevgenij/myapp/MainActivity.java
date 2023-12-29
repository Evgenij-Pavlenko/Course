package com.jevgenij.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView count;
    TextView priceTextView;
    int quantity;
    String text = "Hello Java!";

    Spinner spiner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinerAdapter;

    HashMap goodsMap;

    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spiner = findViewById(R.id.spinner);
        spiner.setOnItemSelectedListener(this);
        count = findViewById(R.id.tv_count);
        priceTextView = findViewById(R.id.price);

        spinnerArrayList = new ArrayList<String>();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        //first Variante
        spinerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);

        //Second Variante
//        spinerAdapter = ArrayAdapter.createFromResource(
//                this,
//                R.array.planets_array,
//                android.R.layout.simple_spinner_item
//        );

        spinerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(spinerAdapter);
        goodsMap = new HashMap<String, Double>();
        goodsMap.put("guitar", 500.00);
        goodsMap.put("drums", 1500.00);
        goodsMap.put("keyboard", 1000.00);


    }

    public void setHelloJavaText(View view) {
        TextView textView = findViewById(R.id.tv_hello);
        if (textView.getText().toString().contains("World")) {
            textView.setText(text);
            textView.setBackgroundColor(Color.CYAN);
            textView.setTextSize(24);
        } else {
            textView.setText("Hello World!");
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            textView.setTextSize(12);
        }
    }

    public void addCount(View view) {
        quantity = Integer.parseInt(String.valueOf(count.getText()));
        quantity++;
        count.setText("" + quantity);
        priceTextView.setText("" + price*quantity );
    }

    public void minusCount(View view) {
        quantity = Integer.parseInt(String.valueOf(count.getText()));
        if (quantity > 0) {
            quantity--;
            count.setText("" + quantity);
        }
        priceTextView.setText("" + price*quantity );

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spiner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);

        priceTextView.setText("" + price*quantity );
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
