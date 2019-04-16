package com.example.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CapitalActivity extends Activity {

    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);

        display=findViewById(R.id.display);

        Bundle bundle=getIntent().getExtras();

        if (bundle!=null){
            String country=bundle.getString("country");
            display.setText(country);
        }

        else
        {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }
    }
}
