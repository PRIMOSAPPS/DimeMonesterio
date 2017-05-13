package com.dime.monesterio.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dime.monesterio.service.MonesterioServicioComprobadorActualizaciones;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by h on 6/03/16.
 */
public class MonesterioComprobadorActualizacionesBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = "[MonesComprActBR]";

    public MonesterioComprobadorActualizacionesBroadcastReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "MonesterioComprobadorActualizacionesBroadcastReceiver.onReceive()");
        Intent startServiceIntent = new Intent(context, MonesterioServicioComprobadorActualizaciones.class);
        context.startService(startServiceIntent);
    }
}
