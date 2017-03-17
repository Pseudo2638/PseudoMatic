package com.example.hp.pseudomatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    // Button Decleration
    Button ChooseButton, backbutton7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        // Back Button is being Declared in the
        // below Steps and the linking with the xml
        // is done below.

        backbutton7 = (Button) findViewById(R.id.back7);

        backbutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DeleteActivity.this, "Thank You.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DeleteActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        // Button Linking to the Layout
        ChooseButton = (Button) findViewById(R.id.choosebtn);

        // Opening new activity if clicked.
        ChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DeleteActivity.this,ChooseActivity.class);
                startActivity(myIntent);
            }
        });

    }
    // This code stub is Under Construction: Please Overlook
}
