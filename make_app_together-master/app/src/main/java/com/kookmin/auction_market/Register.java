package com.kookmin.auction_market;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Toast.makeText(getApplicationContext(), "Register", Toast.LENGTH_LONG).show();
    }
}
