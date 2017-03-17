package com.example.hp.pseudomatic;

/**
 * Created by HP on 2/20/2017.
 */

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


public class BackgroundWorkerFaculty extends AsyncTask<String,Void,String> {
    // Context for alert
    Context context;

    AlertDialog alertDialog;
    // Constructor
    BackgroundWorkerFaculty (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        // Setting Index
        String type = params[0];
        // Webhosting URL, It can also be an local host if mysql is used on the local computer for connection
        String login_url = "http://pseudoattendance.pe.hu/faculty.php";
        // If login called
        if(type.equals("login")) {
            try {
                // Index
                String user_name = params[1];
                String password = params[2];
                // Url calling
                URL url = new URL(login_url);
                // Http connection
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                // Passing parameters
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                // Decleration
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
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if(result!=null && result.equalsIgnoreCase("login success !!!!! Welcome user"))
        {
            Intent intent = new Intent(context, FacultyActivity.class);
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