package com.kookmin.auction_market;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_category);
        Toast.makeText(getApplicationContext(), "SelectCategory", Toast.LENGTH_LONG).show();
    }
}
