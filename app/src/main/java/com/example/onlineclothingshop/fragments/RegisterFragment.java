package com.example.onlineclothingshop.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineclothingshop.Commons;
import com.example.onlineclothingshop.R;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;


public class RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText regUsername,regPassword;
    private Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register_fragment, container, false);

        regUsername = view.findViewById(R.id.regUsername);
        regPassword = view.findViewById(R.id.regPassword);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        return view;
    }

    private void registerUser(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",regUsername.getText().toString());
        editor.putString("password",regPassword.getText().toString());
        editor.commit();

        Commons.alert(getContext(),"You have been registered sucessfully! Login now.");

        regUsername.setText("");
        regPassword.setText("");
    }

    @Override
    public void onClick(View v) {

        if( regUsername.getText().toString().length() > 0 && regPassword.getText().toString().length() > 0 ){
            registerUser();
        }else{
            Commons.alert(getContext(),"Please enter username and password to register.");
        }
    }
}