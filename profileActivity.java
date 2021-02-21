package com.example.healthmonitor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class profileActivity extends AppCompatActivity {

    private Button Chatbot;
    private Context context;
    private TextView glucose, respiration, heartrate, bodytemp, bloodpressure, oxygensaturation;
    private Object UserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = this;
        Chatbot = findViewById(R.id.Chatbot);

        Chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,Chatbot.class);
                startActivity(intent);
            }
        });
    }
}
