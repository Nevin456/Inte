package com.example.smarttrashcanmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class  SignUpActivity extends AppCompatActivity {

    private Button button;
    private EditText mEmail,mPass,mCpass;
    private TextView haveac;


    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEmail=findViewById(R.id.editTextTextEmailAddress);
        mPass=findViewById(R.id.editTextTextPassword);
        mCpass=findViewById(R.id.confirm_Password);

        haveac=findViewById(R.id.haveAc);
        haveac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        mAuth=FirebaseAuth.getInstance();


        button=findViewById(R.id.buttonSignUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                //openActivity2();
            }
        });

        /*haveac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });*/



    }

    private void createUser(){
        String email=mEmail.getText().toString();
        String pass=mPass.getText().toString();
        String cPass=mCpass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && pass.equals(cPass)){
            if (!pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUpActivity.this, "Registered Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this , LoginActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG,"createUserWithEmail:failure",task.getException());
                        Toast.makeText(SignUpActivity.this, "Registration Error !!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                mPass.setError("Empty Fields Are not Allowed");
            }
        }else if(email.isEmpty()) {
            mEmail.setError("Empty Fields Are not Allowed");
        }else  if(!pass.equals(cPass))   {
            mCpass.setError("Given Password is not the same");
        }else{
            mEmail.setError("Please Enter a Correct Email Address");
        }
    }
    public void openActivity2(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}