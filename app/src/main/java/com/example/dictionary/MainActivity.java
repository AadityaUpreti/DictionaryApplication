package com.example.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, String> dictionary;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        dictionary = new HashMap<>();

        readFromFile();
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country=parent.getItemAtPosition(position).toString();
                String capital=dictionary.get(country);
//                Toast.makeText(getApplicationContext(), capital.toString(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,CapitalActivity.class);
                intent.putExtra("country",capital);
                startActivity(intent);
            }
        });


    }
   public void readFromFile(){
        FileInputStream fos=null;
       try {
           fos=openFileInput("words.txt");
           InputStreamReader isr=new InputStreamReader(fos);
           BufferedReader br=new BufferedReader(isr);
           String line="";
           while ((line=br.readLine())!=null) {
           String[] parts=line.split("->");
           dictionary.put(parts[0],parts[1]);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }


   }
   }



