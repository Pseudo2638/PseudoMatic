package com.example.hp.pseudomatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    Button backbutton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        // Back Button is being Declared in the
        // below Steps and the linking with the xml
        // is done below.

        backbutton8 = (Button) findViewById(R.id.back8);

        backbutton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ChooseActivity.this, "Thank You.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ChooseActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


        // This Code Stub Is Under Construction. Please Over Look.
    }
}
