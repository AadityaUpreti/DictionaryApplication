package com.example.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button opendictionary,openaddcountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        openaddcountry=findViewById(R.id.openaddcountry);
        opendictionary=findViewById(R.id.opendictionary);


        openaddcountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,AddCountry.class);
                startActivity(intent);
            }
        });

        opendictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Dashboard.this,MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
