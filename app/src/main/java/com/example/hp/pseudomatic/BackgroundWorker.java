package com.example.hp.pseudomatic;

/**
 * Created by HP on 2/20/2017.
 */

// Following are all the imports used in Background Worker Class.

import android.app.AlertDialog;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundWorker extends AsyncTask<String,Void,String> {
    // To return the context of the code.
    Context context;
    // To alert if an error or an succesfull connection occurs.
    AlertDialog alertDialog;
    // Constructor of Context Type
    BackgroundWorker (Context ctx) {

        context = ctx;
    }
    @Override
    // This is the runnable method which is created with the use of AsyncTask class.
    protected String doInBackground(String... params) {
        // Setting Index
        String type = params[0];
        // Online Webhosting URL for PHP connections.
        String login_url = "http://pseudoattendance.pe.hu/login.php";
        String register_url = "http://pseudoattendance.pe.hu/register.php";
        String faculty_register_url = "http://pseudoattendance.pe.hu/registerFaculty.php";
        // if " login " called
        if(type.equals("login")) {
            try {
                // Setting Index
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                // HTTP GET and POST methods.
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                // Passing Parameters
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                // Stores the outcome of the connection call
                String result="";
                // To store the incomming Information
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("register"))
        {
            try {
                // Setting Indexes According to the Layout
                String fname = params[1];
                String lname = params[2];
                String rollno = params[3];
                String id = params[4];
                String emailid = params[5];
                String year = params[6];
                String semester = params[7];
                String stream = params[8];
                String phno = params[9];
                String password = params[10];

                // Register_url called from the above to do work for the register calls
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                // Passing Parameters
                String post_data = URLEncoder.encode("fname","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")+"&"
                        +URLEncoder.encode("lname","UTF-8")+"="+URLEncoder.encode(lname,"UTF-8")+"&"
                        +URLEncoder.encode("rollno","UTF-8")+"="+URLEncoder.encode(rollno,"UTF-8")+"&"
                        +URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")
                        +"&" +URLEncoder.encode("emailid","UTF-8")+"="+URLEncoder.encode(emailid,"UTF-8")
                        +"&" +URLEncoder.encode("year","UTF-8")+"="+URLEncoder.encode(year,"UTF-8")
                        +"&" +URLEncoder.encode("semester","UTF-8")+"="+URLEncoder.encode(semester,"UTF-8")
                        +"&" +URLEncoder.encode("stream","UTF-8")+"="+URLEncoder.encode(stream,"UTF-8")
                        +"&" +URLEncoder.encode("phno","UTF-8")+"="+URLEncoder.encode(phno,"UTF-8")
                        +"&" +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                // Stores Result
                String result="";
                // Stores Incomming Data
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("registerFaculty"))
        {
            // The syntax is same for all peice of the calls used
            try {
                // Indexing
                String fname = params[1];
                String lname = params[2];
                String id = params[3];
                String phone = params[4];
                String email = params[5];
                String password = params[6];

                URL url = new URL(faculty_register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                // Passing parameters
                String post_data = URLEncoder.encode("fname","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")+"&"
                        +URLEncoder.encode("lname","UTF-8")+"="+URLEncoder.encode(lname,"UTF-8")+"&"
                        +URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")
                        +"&" +URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")
                        +"&" +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")
                        +"&" +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {

        // Before the execution is done.
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        // Here, It ignores the string if it comes in he exact way from the php script else it Blocks the Oonnection.
        if(result!=null && result.equalsIgnoreCase("login success !!!!! Welcome user"))
        {
            // New Intent Starts if Connection Succesfull (Activity)
            Intent intent = new Intent(context, StudentActivity.class);
            context.startActivity(intent);
        }
        else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}