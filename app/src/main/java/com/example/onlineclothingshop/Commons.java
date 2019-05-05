package com.example.onlineclothingshop;

import android.content.Context;
import android.widget.Toast;

public class Commons {

    public static boolean loggedIn = false;

    public static void alert(Context c, String message){
        Toast.makeText(c,message,Toast.LENGTH_LONG).show();
    }

    public static void logout(){
        loggedIn = false;
    }

}