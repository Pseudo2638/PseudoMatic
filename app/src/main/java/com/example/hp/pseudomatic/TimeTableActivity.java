package com.example.hp.pseudomatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TimeTableActivity extends AppCompatActivity {

    // Decleration
    Button backbutton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        // Back Button is being Declared in the
        // below Steps and the linking with the xml
        // is done below.

        backbutton1 = (Button) findViewById(R.id.back1);

        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TimeTableActivity.this, "Thank You.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(TimeTableActivity.this,MainActivity.class);
                startActivity(i);
            }
        });



        // This Code Stub Is Under Construction. Please Over Look.

    }
}
