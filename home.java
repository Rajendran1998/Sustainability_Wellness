package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class home extends AppCompatActivity {

    private TextView textView1, textView2,textView3,textView4,textView5,textView6;
    Button button_sent;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button_sent = findViewById(R.id.hsent);
        textView1 = findViewById(R.id.t1);
        textView2 = findViewById(R.id.t2);
        textView3 = findViewById(R.id.t3);
        textView4 = findViewById(R.id.t4);
        textView5 = findViewById(R.id.t5);
        textView6 = findViewById(R.id.t6);


        button_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest1();
                sendRequest2();
                sendRequest3();
                sendRequest4();
                sendRequest5();
                sendRequest6();

            }
        });


    }

    public void sendRequest1()
    {


        Toast.makeText(home.this,"sending",Toast.LENGTH_LONG).show();
        RequestQueue queue = Volley.newRequestQueue(home.this);
        String url = "https://healthmonitor2.herokuapp.com/api/g";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                textView1.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView1.setText("Something Wrong");
            }
        });
        queue.add(stringRequest);
    }
    public void sendRequest2()
    {



        RequestQueue queue = Volley.newRequestQueue(home.this);
        String url = "https://healthmonitor2.herokuapp.com/api/r";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                textView2.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView2.setText("Something Wrong");
            }
        });
        queue.add(stringRequest);
    }
    public void sendRequest3()
    {


        RequestQueue queue = Volley.newRequestQueue(home.this);
        String url = "https://healthmonitor2.herokuapp.com/api/hr";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                textView3.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView3.setText("Something Wrong");
            }
        });
        queue.add(stringRequest);
    }
    public void sendRequest4()
    {


        RequestQueue queue = Volley.newRequestQueue(home.this);
        String url = "https://healthmonitor2.herokuapp.com/api/bt";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                textView4.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView4.setText("Something Wrong");
            }
        });
        queue.add(stringRequest);
    }
    public void sendRequest5()
    {



        RequestQueue queue = Volley.newRequestQueue(home.this);
        String url = "https://healthmonitor2.herokuapp.com/api/bp";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                textView5.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView5.setText("Something Wrong");
            }
        });
        queue.add(stringRequest);
    }
    public void sendRequest6()
    {



        RequestQueue queue = Volley.newRequestQueue(home.this);
        String url = "https://healthmonitor2.herokuapp.com/api/os";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                textView6.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView6.setText("Something Wrong");
            }
        });
        queue.add(stringRequest);
    }



}
