package com.jevgenij.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        count = findViewById(R.id.tv_count);
        priceTextView = findViewById(R.id.price);

        createSpinner();

        createMap();

    }

    void createSpinner() {
        spiner = findViewById(R.id.spinner);
        spiner.setOnItemSelectedListener(this);
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
    }
    void createMap(){
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
        priceTextView.setText("" + price * quantity);
    }

    public void minusCount(View view) {
        quantity = Integer.parseInt(String.valueOf(count.getText()));
        if (quantity > 0) {
            quantity--;
            count.setText("" + quantity);
        }
        priceTextView.setText("" + price * quantity);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spiner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);

        priceTextView.setText("" + price * quantity);

        ImageView goodsIV = findViewById(R.id.iv_goods);

        switch (goodsName) {
            case "guitar":
                goodsIV.setImageResource(R.drawable.baseline_music_note_24);
                break;
            case "drums":
                goodsIV.setImageResource(R.drawable.baseline_music_off_24);
                break;
            case "keyboard":
                goodsIV.setImageResource(R.drawable.baseline_music_video_24);
                break;
            default:
                goodsIV.setImageResource(R.drawable.baseline_do_not_disturb_alt_24);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCard(View view) {
        Order order = new Order();
        order.userName = "John";
        order.orderPrice = price;
        order.goodsName = goodsName;
        order.quantity = quantity;

//        Log.d("userName", order.userName);
//        Log.d("orderPrice", "" + order.orderPrice);
//        Log.d("goodsName", order.goodsName);
//        Log.d("quantity", "" + order.quantity);
    }
}
