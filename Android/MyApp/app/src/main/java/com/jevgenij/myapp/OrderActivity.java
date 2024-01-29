package com.jevgenij.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    String[] addresses = {"evgenij.pavlenko@gmail.com"};
    String subject = "My Orders Test";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //this!!
        this.setTitle("Order");

        Intent recOrderIntent = getIntent();
        String userName = recOrderIntent.getStringExtra("userName");
        double orderPrice = recOrderIntent.getDoubleExtra("orderPrice", 0.0);
        String goodsName = recOrderIntent.getStringExtra("goodsName");
        int quantity = recOrderIntent.getIntExtra("quantity", 0);
        TextView orderTV = findViewById(R.id.orderTV);
        emailText = userName + "\n" + orderPrice + "\n" + goodsName + "\n" + quantity;
        orderTV.setText(emailText);

    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}