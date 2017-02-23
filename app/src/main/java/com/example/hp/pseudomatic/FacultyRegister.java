package com.example.hp.pseudomatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FacultyRegister extends AppCompatActivity {
    // Decleration
    EditText fname,lname,id,email,phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_register);

        // Layout Linking
        fname = (EditText) findViewById(R.id.et_fname);
        lname = (EditText) findViewById(R.id.et_lname);
        id = (EditText) findViewById(R.id.et_id);
        email = (EditText) findViewById(R.id.et_email);
        phone = (EditText)findViewById(R.id.et_phone);
        password = (EditText) findViewById(R.id.et_password);

    }

    public void onRegisterFaculty (View view) {
        // To get the user input and converting it to string.

        String str_fname = fname.getText().toString();
        String str_lname = lname.getText().toString();
        String str_id = id.getText().toString();
        String str_email = email.getText().toString();
        String str_phone = phone.getText().toString();
        String str_password = password.getText().toString();
        // Type is mentioned LIKE register,login etc..
        String type = "registerFaculty";
        // Object of BackgroundWorker Class is created.
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        // Class is being executed and the parameters to be executed are passed within the braces.
        backgroundWorker.execute(type,str_fname,str_lname,str_id,str_email,str_phone,str_password);
    }
}
