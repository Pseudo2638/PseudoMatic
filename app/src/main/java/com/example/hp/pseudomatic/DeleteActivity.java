package com.example.hp.pseudomatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeleteActivity extends AppCompatActivity {

    // Button Decleration
    Button ChooseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
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
}
