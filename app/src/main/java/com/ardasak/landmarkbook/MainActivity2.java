package com.ardasak.landmarkbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {
    ImageView imageView;
    TextView landmark;
    TextView country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.imageView);
        landmark=findViewById(R.id.textView2);
        country=findViewById(R.id.textView);

        Intent intent = getIntent();
        String yazi = intent.getStringExtra("name");
        String yazi1 = intent.getStringExtra("name1");
        landmark.setText(yazi);
        country.setText(yazi1);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
       //imageView.setImageBitmap(MainActivity.selected_image);
    }
}