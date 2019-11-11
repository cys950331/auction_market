package com.kookmin.auction_market;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

public class BoardWrite extends AppCompatActivity {
    final int REQUEST_CODE = 0;
    TextView timeView;
    TextView dayView;
    TimePickerDialog.OnTimeSetListener callbackMethod;
    DatePickerDialog.OnDateSetListener callbackMethod2;
    Button btnTime;
    Button btnDay;
    Button btnRegister;
    Button btnPhoto;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write);
        Toast.makeText(getApplicationContext(), "BOARDWrite", Toast.LENGTH_LONG).show();
        dayView = findViewById(R.id.editDay);
        timeView = findViewById(R.id.editTime);
        btnTime = findViewById(R.id.btnTime);
        btnRegister = findViewById(R.id.btnRegister);
        btnPhoto = findViewById(R.id.btnPhoto);
        btnDay = findViewById(R.id.btnDay);
        image1 = findViewById(R.id.imageView4);
        image2 = findViewById(R.id.imageView5);
        image3 = findViewById(R.id.imageView6);
        image4  = findViewById(R.id.imageView7);
        image5  = findViewById(R.id.imageView8);
        image6  = findViewById(R.id.imageView9);
        image7  = findViewById(R.id.imageView10);
        this.InitializeView();
        this.InitializeListener();
        this.InitializeView2();
        this.InitializeListener2();
        btnDay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                OnDayHandler();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnTimeHandler();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainPage.class);
                startActivity(intent);
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), REQUEST_CODE);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                //기존 이미지 지우기
                image1.setImageResource(0);
                image2.setImageResource(0);
                image3.setImageResource(0);
                image4.setImageResource(0);
                image5.setImageResource(0);
                image6.setImageResource(0);
                image7.setImageResource(0);

                //ClipData 또는 Uri를 가져온다
                Uri uri = data.getData();
                ClipData clipData = data.getClipData();
                Toast.makeText(this,"사진업로드 성공", Toast.LENGTH_LONG).show();



                //이미지 URI 를 이용하여 이미지뷰에 순서대로 세팅.
                // 업로드 가능한 사진의 최대수는 7장으로 설정했음.
                if (clipData != null) {

                    for (int i = 0; i < 7; i++) {
                        if (i < clipData.getItemCount()) {
                            Uri urione = clipData.getItemAt(i).getUri();
                            switch (i) {
                                case 0:
                                    image1.setImageURI(urione);
                                    break;
                                case 1:
                                    image2.setImageURI(urione);
                                    break;
                                case 2:
                                    image3.setImageURI(urione);
                                    break;
                                case 3:
                                    image4.setImageURI(urione);
                                    break;
                                case 4:
                                    image5.setImageURI(urione);
                                    break;
                                case 5:
                                    image6.setImageURI(urione);
                                    break;
                                case 6:
                                    image7.setImageURI(urione);
                                    break;
                            }
                        }
                    }
                } else if (uri != null) {
                    image1.setImageURI(uri);
                }

            }
            //사진을 가져오는 것을 취소하는 경우
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this,"사진선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void InitializeView(){
        timeView = findViewById(R.id.editTime);
    }
    public void InitializeView2(){
        dayView = findViewById(R.id.editDay);
    }
    public void InitializeListener()
    {
        callbackMethod = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {

                    timeView.setText(hourOfDay + "시" + minute + "분");
            }
        };
    }
    public void InitializeListener2(){
        callbackMethod2 = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                dayView.setText(year + "년" +monthOfYear + "월" + dayOfMonth + " 일" );
            }
        };
    }
    public void OnDayHandler(){
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod2, 2019,11,11);
        dialog.show();
    }

    public void OnTimeHandler(){
        TimePickerDialog dialog = new TimePickerDialog(this, callbackMethod,0,00,true);
        dialog.show();

    }
}
