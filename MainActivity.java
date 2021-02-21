package com.example.healthmonitor;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;

import java.net.URL;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        signIn =( Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        editTextEmail =(EditText) findViewById(R.id.email);
        editTextPassword =(EditText) findViewById(R.id.password);

        progressBar =(ProgressBar) findViewById(R.id.progressBar);

        mAuth= FirebaseAuth.getInstance();


  }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                startActivity(new Intent(this, registerUser.class));
                break;
            case R.id.signIn:
                userLogin();
                break;


        }
    }

    private void userLogin(){
        String email= editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextEmail.setError("Email is requires!");
            editTextEmail.requestFocus();
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter valid email");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("Min should have 6 character");
            editTextPassword.requestFocus();
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email ,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    startActivity(new Intent(MainActivity.this,home.class));
                }else{
                    Toast.makeText(MainActivity.this,"Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}