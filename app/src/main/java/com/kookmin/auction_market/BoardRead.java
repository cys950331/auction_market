package com.kookmin.auction_market;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BoardRead extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_read);
        Toast.makeText(getApplicationContext(), "BOARDREAD", Toast.LENGTH_LONG).show();
    }
}

