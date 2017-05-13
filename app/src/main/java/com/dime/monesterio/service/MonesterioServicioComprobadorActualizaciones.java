package com.dime.monesterio.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.dime.monesterio.actividades.detalle.MonesterioDetalleNotificacionActivity;
import com.modulos.libreria.dimepoblacioneslibreria.service.ServicioComprobadorActualizaciones;

/**
 * Created by h on 13/05/16.
 */
public class MonesterioServicioComprobadorActualizaciones extends ServicioComprobadorActualizaciones {

    private static final String TAG = "[MonServComprobActuali]";

    public MonesterioServicioComprobadorActualizaciones() {
        super();
    }

    @Override
    protected Class getClassNotificacion() {
        return MonesterioDetalleNotificacionActivity.class;
    }

    @Override
    public void onDestroy() {
        Log.d("[ConectorServidor]", "ConectorServidor ondestroy!");
        super.onDestroy();

        Log.d(TAG, "ondestroy!");
        Intent broadcastIntent = new Intent("com.dime.monesterio.service.RestartComprobador");
        sendBroadcast(broadcastIntent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        return Service.START_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d(TAG, "onTaskRemoved called");
        super.onTaskRemoved(rootIntent);
        //do something you want
        //stop service
        this.stopSelf();
    }

}
