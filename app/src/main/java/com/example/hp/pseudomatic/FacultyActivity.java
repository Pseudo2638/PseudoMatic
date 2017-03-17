package com.example.hp.pseudomatic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import android.app.ProgressDialog;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.android.volley.RequestQueue;
    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.StringRequest;
    import com.android.volley.toolbox.Volley;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    public class FacultyActivity extends AppCompatActivity implements View.OnClickListener {

        // Decleration
        private EditText editTextId;
        private Button buttonGet, deletebutton,timetablebutton, backbutton6;
        private TextView textViewResult;

        private ProgressDialog loading;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_faculty);

            // Linking To layouts
            editTextId = (EditText) findViewById(R.id.editTextId);
            buttonGet = (Button) findViewById(R.id.buttonGet);
            timetablebutton = (Button) findViewById(R.id.timetablebtn);
            deletebutton = (Button) findViewById(R.id.deletebtn);
            textViewResult = (TextView) findViewById(R.id.textViewResult);

            // Back Button is being Declared in the
            // below Steps and the linking with the xml
            // is done below.

            backbutton6 = (Button) findViewById(R.id.back6);

            backbutton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(FacultyActivity.this, "Thank You.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(FacultyActivity.this,MainActivity.class);
                    startActivity(i);
                }
            });

            // New Activity if Clicked.
            deletebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(FacultyActivity.this,DeleteActivity.class);
                    startActivity(myIntent);
                }
            });

            // New Acitivity Opened ifClicked
            timetablebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(FacultyActivity.this,TimeTableActivity.class);
                    startActivity(myIntent);
                }
            });

            buttonGet.setOnClickListener(this);
        }

        // This Takes the input from the user edit text and checks that it matches
        // in the database entries or not.
        private void getData() {
            // String Conversion
            String id = editTextId.getText().toString().trim();
            // Checking
            if (id.equals("")) {

                // This line of code makes a notification to display
                // When pressed on the button
                Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
                return;
            }
            loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

            // Checkin String Of the Database Storage URL
            String url = Config.DATA_URL+editTextId.getText().toString().trim();

            // If data matches
            StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    loading.dismiss();
                    showJSON(response);
                }
            },
                    // If not matches
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(FacultyActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }

        private void showJSON(String response){

            // This is used to get responce from the user entry to feed
            // in the database
            String fname="";
            String lname="";
            String rollno = "";
            String id = "";
            String emailid = "";
            String password = "";
            String phno = "";
            String year = "";
            String semester = "";
            String stream = "";


            try {

                // The Below Code Uses JSON to Fetch
                // Responce of the url we searched for and assigns
                // Index while fetching the inputs in the database
                JSONObject jsonObject = new JSONObject(response);
                JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
                JSONObject collegeData = result.getJSONObject(0);
                fname = collegeData.getString(Config.KEY_fname);
                lname = collegeData.getString(Config.KEY_lname);
                rollno = collegeData.getString(Config.KEY_rollno);
                id = collegeData.getString(Config.KEY_id);
                emailid = collegeData.getString(Config.KEY_emailid);
                password = collegeData.getString(Config.KEY_password);
                phno = collegeData.getString(Config.KEY_phno);
                year = collegeData.getString(Config.KEY_year);
                semester = collegeData.getString(Config.KEY_semester);
                stream = collegeData.getString(Config.KEY_stream);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            textViewResult.setText("First Name :\t"+fname+"\nLast Name :\t" +lname+ "\nRoll Number :\t"+ rollno+"\nSystem ID :\t"+id+"\nEmail ID :\t"+emailid+
                    "\nPassword :\t"+password+"\nPhone Number :\t"+phno+"\nYear :\t"+year+"\nSemester :\t"+semester+"\nStream :\t"+stream);
        }

        @Override
        public void onClick(View v) {
            getData();
        }


    }



