package com.example.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countires[] = {
            "Nepal", "kathmandu",
            "India", "New Delhi",
            "China", "Beijing",
            "Canada", "ottawa"
    };


    private Map<String, String> dictionary;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        dictionary = new HashMap<>();
        for (int i = 0; i < countires.length; i += 2) {
            dictionary.put(countires[i], countires[i + 1]);
        }
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
}


