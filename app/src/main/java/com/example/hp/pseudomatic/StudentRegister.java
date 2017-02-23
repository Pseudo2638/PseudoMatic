package com.example.hp.pseudomatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StudentRegister extends AppCompatActivity {

    // Decleration

    EditText fname,lname,rollno,id,emailid,year,semester,stream,phno,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        // Layout Linking

        fname = (EditText) findViewById(R.id.et_fname);
        lname = (EditText) findViewById(R.id.et_lname);
        rollno = (EditText) findViewById(R.id.et_rollno);
        id = (EditText) findViewById(R.id.et_id);
        emailid = (EditText) findViewById(R.id.et_emailid);
        year = (EditText) findViewById(R.id.et_year);
        semester = (EditText) findViewById(R.id.et_semester);
        stream = (EditText) findViewById(R.id.et_stream);
        phno = (EditText)findViewById(R.id.et_phno);
        password = (EditText) findViewById(R.id.et_password);

    }

    // Onclick Method
    public void onRegister (View view) {
        // User Input
        String str_fname = fname.getText().toString();
        String str_lname = lname.getText().toString();
        String str_rollno = rollno.getText().toString();
        String str_id = id.getText().toString();
        String str_emailid = emailid.getText().toString();
        String str_year = year.getText().toString();
        String str_semester = semester.getText().toString();
        String str_stream = stream.getText().toString();
        String str_phno = phno.getText().toString();
        String str_password = password.getText().toString();
        // Setting type for BackgroundWorker class
        String type = "register";
        // Object Creation
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        // Execution of object by passing parameters involved
        backgroundWorker.execute(type,str_fname,str_lname,str_rollno,str_id,str_emailid,str_year,str_semester,str_stream,str_phno,str_password);
    }

}