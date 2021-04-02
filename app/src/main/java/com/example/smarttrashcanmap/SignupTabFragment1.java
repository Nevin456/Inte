package com.example.smarttrashcanmap;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupTabFragment1 extends Fragment {
    private Button button;
    private EditText mEmail,mPass,mCpass;
    private TextView haveac;
    View v;

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        button=v.findViewById(R.id.btnCA);

        mEmail=v.findViewById(R.id.txtEmail);
        mPass=v.findViewById(R.id.txtPass);
        mCpass=v.findViewById(R.id.txtConpass);

        mAuth=FirebaseAuth.getInstance();

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });*/





        return v;


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
                                Toast.makeText(getActivity(), "Registered Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getActivity() , LoginTabFragment1.class));
                                //finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG,"createUserWithEmail:failure",task.getException());
                        Toast.makeText(getActivity(), "Registration Error !!" + e.getMessage(), Toast.LENGTH_SHORT).show();
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


}
