package com.example.szamiri.kiosk3;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.content.Context;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();

        Log.d("Sajjad",action);

        if (Intent.ACTION_SEND.equals(action)) {

            }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
            return true;
    }*/

    @Override
    public void onBackPressed() {    // call my backbutton pressed method when boolean==true
        //sds
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.d("Sajjad", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // This is where we need to know which activity is current
        /*
        Log.d("Sajjad", "Pause");
        Context context = getApplicationContext();
        Intent it = new Intent("GO_TO_PERCIPIA");
        it.setComponent(new ComponentName(context.getPackageName(), MainActivity.class.getName()));
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(it);
        */
    }
    /*
    @Override
    protected void onDestroy(){
        super.onDestroy();
        // This is where we need to know which activity is current
        Log.d("Sajjad", "Distroying");
        Context context = getApplicationContext();
        Intent it = new Intent("GO_TO_PERCIPIA");
        it.setComponent(new ComponentName(context.getPackageName(), MainActivity.class.getName()));
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(it);
    }
    */

}
