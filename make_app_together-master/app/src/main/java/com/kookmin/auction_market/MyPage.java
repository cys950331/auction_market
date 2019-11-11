package com.kookmin.auction_market;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_page);
        Toast.makeText(getApplicationContext(), "MyPage", Toast.LENGTH_LONG).show();
    }
}
