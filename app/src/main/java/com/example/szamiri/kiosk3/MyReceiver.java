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
public class MyReceiver extends BroadcastReceiver {
    private Handler mHandler = new Handler();
    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "Receiver 1 -> Intent Detected.", Toast.LENGTH_LONG).show();
        Log.d("Sajjad",intent.toString());

        if (intent.getExtras().get("HANDSET_ON_HOOK").toString() == "false") {
            Log.e("Sajjad","Phone handset was picked up");
        } else {
            Log.e("Sajjad","Phone handset is on hook");

            // To start the app after hang up
            Intent it = new Intent("intent.my.action");
            it.setComponent(new ComponentName(context.getPackageName(), MainActivity.class.getName()));
            it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            mHandler.postDelayed(new MyRunnable(context,it), 500);
        }

        //dumpIntent (intent);

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

