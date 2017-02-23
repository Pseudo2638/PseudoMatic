package com.example.hp.pseudomatic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {
    // Decleration
    Button facultySignup, studentSignup,aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Layout Linking

        facultySignup = (Button) findViewById(R.id.facultybtn);
        studentSignup = (Button) findViewById(R.id.studentbtn);
        aboutButton = (Button)findViewById(R.id.aboutbtn);

        // New Activity Opened if Button Clicked
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Register.this,AboutActivity.class);
                startActivity(myIntent);

            }
        });

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
