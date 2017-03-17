package com.example.hp.pseudomatic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    // Decleration
    Button facultySignup, studentSignup,aboutButton, backbutton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Layout Linking

        facultySignup = (Button) findViewById(R.id.facultybtn);
        studentSignup = (Button) findViewById(R.id.studentbtn);
        backbutton4 = (Button) findViewById(R.id.back4);

        // Back Button is being Declared in the
        // below Steps and the linking with the xml
        // is done below.

        backbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Register.this, "Thank You.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });
        aboutButton = (Button)findViewById(R.id.aboutbtn);



        // New Activity Opened if Button Clicked
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Register.this,AboutActivity.class);
                startActivity(myIntent);

            }
        });

        // New Activty Opened If Button Clicked
        facultySignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Register.this,FacultyRegister.class);
                startActivity(myIntent);


            }
        });

        studentSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Register.this,StudentRegister.class);
                startActivity(myIntent);

            }
        });
    }
}
