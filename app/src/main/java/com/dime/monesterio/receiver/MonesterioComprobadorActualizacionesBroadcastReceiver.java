package com.dime.monesterio.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dime.monesterio.service.MonesterioServicioComprobadorActualizaciones;

/**
 * Created by h on 6/03/16.
 */
public class MonesterioComprobadorActualizacionesBroadcastReceiver extends BroadcastReceiver {

    public MonesterioComprobadorActualizacionesBroadcastReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context, MonesterioServicioComprobadorActualizaciones.class);
        context.startService(startServiceIntent);
    }
}
