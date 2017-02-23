package com.example.hp.pseudomatic;

// NOTE : IN ORDER TO MAKE THIS APP RUN, IN THE ANDROID MANIFEST FILE YOU HAVE TO PASS USER INTERNET ACCESS PERMISSION



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;



    public class MainActivity extends ActionBarActivity {

        // Decleration
        EditText UsernameEt, PasswordEt;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // Layout Linking
            UsernameEt = (EditText)findViewById(R.id.etUserName);
            PasswordEt = (EditText)findViewById(R.id.etPassword);
        }

        // Button with Onlogin method on clicking
        public void OnLogin(View view) {
            // User Input
            String username = UsernameEt.getText().toString();
            String password = PasswordEt.getText().toString();
            // Seting type for Background Worker
            String type = "login";
            // Objec Creation
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            // Object Execution
            backgroundWorker.execute(type, username, password);



        }
        // Onclick Method
        public void OnLoginFaculty(View view) {
            String username = UsernameEt.getText().toString();
            String password = PasswordEt.getText().toString();
            String type = "login";
            BackgroundWorkerFaculty backgroundWorker = new BackgroundWorkerFaculty(this);
            backgroundWorker.execute(type, username, password);
        }

        // Onclick Method
            public void openSignup (View view)
        {
            Intent myIntent = new Intent(MainActivity.this,Register.class);
            startActivity(myIntent);
        }



        }

