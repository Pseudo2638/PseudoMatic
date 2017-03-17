package com.example.hp.pseudomatic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

    // Back Button is being Declared in the
    // below Steps and the linking with the xml
    // is done below.
    Button backbutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        // Linking
        backbutton3 = (Button) findViewById(R.id.back3);

        // Setting on click Listener to open new Intent on Clicking

        backbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(StudentActivity.this, "Thank You.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StudentActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        // This Code Stub Is Under Construction. Please Over Look.
    }
}
