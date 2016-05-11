package com.example.szamiri.kiosk3;

import android.content.Context;
import android.content.Intent;

/**
 * Created by szamiri on 5/10/2016.
 */
public class MyRunnable implements Runnable {
    private Context context;
    private Intent it;
    public MyRunnable(Context _context,Intent _it) {
        this.context = _context;
        this.it = _it;
    }

    public void run() {
        this.context.getApplicationContext().startActivity(this.it);
    }
}