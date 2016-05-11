package com.example.szamiri.kiosk3;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by szamiri on 5/10/2016.
 */
public class MyReceiver2 extends BroadcastReceiver {
    private Handler mHandler = new Handler();

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "Receiver 2 -> Intent Detected.", Toast.LENGTH_LONG).show();
        Log.d("Sajjad", intent.toString());
        String phone_state = intent.getExtras().get("state").toString();
        Log.d("Sajjad",phone_state);

        if (phone_state.contains("IDLE")) {
            Log.e("Sajjad", "Phone is IDLE");
            // To start the app after hang up
            Intent it = new Intent("GO_TO_PERCIPIA");
            it.setComponent(new ComponentName(context.getPackageName(), MainActivity.class.getName()));
            it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            mHandler.postDelayed(new MyRunnable(context,it), 10000);
        }
        dumpIntent (intent);
    }

    public static void dumpIntent(Intent i){
        Bundle bundle = i.getExtras();
        if (bundle != null) {
            Set<String> keys = bundle.keySet();
            Iterator<String> it = keys.iterator();
            Log.e("Sajjad","Dumping Intent start");
            while (it.hasNext()) {
                String key = it.next();
                Log.e("Sajjad","[" + key + "=" + bundle.get(key)+"]");
            }
            Log.e("Sajjad","Dumping Intent end");
        }
    }
}