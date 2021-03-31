package com.example.smarttrashcanmap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {
    EditText Email;
    EditText Pass;
    Button login;

    float v=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        Email = root.findViewById(R.id.email);
        Pass = root.findViewById(R.id.pass);
        login=root.findViewById(R.id.button);

        Email.setAlpha(v);
        Pass.setAlpha(v);
        login.setAlpha(v);

        Email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        Pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
    }
}
