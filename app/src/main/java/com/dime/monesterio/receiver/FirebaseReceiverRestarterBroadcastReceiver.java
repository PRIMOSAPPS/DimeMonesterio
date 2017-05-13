package com.dime.monesterio.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dime.monesterio.push.MonesterioFirebaseInstanceIDService;
import com.dime.monesterio.push.MonesterioFirebaseMessagingService;
import com.dime.monesterio.service.MonesterioServicioComprobadorActualizaciones;

/**
 * Created by h on 28/12/16.
 */
public class FirebaseReceiverRestarterBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = "[FirebaseReceivRestart]";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "FirebaseReceiverRestarterBroadcastReceiver.onReceive()");
        //context.startService(new Intent(context, MonesterioFirebaseMessagingService.class));
        //context.startService(new Intent(context, MonesterioFirebaseInstanceIDService.class));;
    }
}
