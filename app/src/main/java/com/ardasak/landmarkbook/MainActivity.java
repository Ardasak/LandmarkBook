package com.ardasak.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> landmarknames;
    ArrayList<String> countrynames;
    //static Bitmap selected_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        landmarknames=new ArrayList<>();
        landmarknames.add("Pisa");
        landmarknames.add("Eiffel");
        landmarknames.add("Colleseo");
        landmarknames.add("London Bridge");

        countrynames= new ArrayList<>();
        countrynames.add("Italy");
        countrynames.add("France");
        countrynames.add("Italy");
        countrynames.add("United Kingdom");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap colosseo = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colosseo);
        Bitmap london_bridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);
        ArrayList<Bitmap> landmarkimages=new ArrayList<>();
        landmarkimages.add(pisa);
        landmarkimages.add(eiffel);
        landmarkimages.add(colosseo);
        landmarkimages.add(london_bridge);
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmarknames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  System.out.println(landmarknames.get(position));
               // System.out.println(countrynames.get(position));
                //selected_image = landmarkimages.get(position);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",landmarknames.get(position));
                intent.putExtra("name1",countrynames.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkimages.get(position));
                startActivity(intent);
            }
        });

    }
}