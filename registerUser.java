
package com.example.healthmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthmonitor.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class registerUser extends AppCompatActivity implements View.OnClickListener{
    private TextView banner, registerUser;
    private EditText editTextFullName,editTextAge , editTextEmail,editTextPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();



        registerUser=(Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextFullName=(EditText)findViewById(R.id.fullName);
        editTextAge=(EditText) findViewById(R.id.age);
        editTextEmail=(EditText) findViewById(R.id.email);
        editTextPassword=(EditText) findViewById(R.id.password);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.registerUser:
                registerUser();
                break;
        }

    }

    private void registerUser() {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();
        String fullName=editTextFullName.getText().toString().trim();
        String age=editTextAge.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextFullName.setError("Full name is required");
            editTextFullName.requestFocus();
            return;
        }
        if(age.isEmpty()){
            editTextAge.setError("Age is required");
            editTextAge.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email");
            return;

        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextPassword.setError("greater then 6 character");
            editTextPassword.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            user user = new user(fullName ,age, email);

                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(registerUser.this, "User has been Registered successfully", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.VISIBLE);

                                        //redirect to login layout!
                                    } else {
                                        Toast.makeText(registerUser.this, "Failed to register! Try again!",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(registerUser.this, "Failed to register! ",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });
    }


}
