package com.dime.monesterio.actividades;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.dime.monesterio.push.MonesterioFirebaseInstanceIDService;
import com.dime.monesterio.push.MonesterioFirebaseMessagingService;
import com.dime.monesterio.service.MonesterioServicioComprobadorActualizaciones;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.InicioActivity;

/**
 * Created by h on 18/03/16.
 */
public class MonesterioInicioActivity extends InicioActivity {

    private Intent mFirebaseInstanceIdIntent;
    private Intent mFirebaseMessagingIntent;

    private Intent mcomprobadorActualizacionesIntent;

    private Context ctx;

    public Context getCtx() {
        return ctx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;

        //mFirebaseInstanceIdIntent = new Intent(getCtx(), firebaseInstanceIDService.getClass());
        //mFirebaseMessagingIntent = new Intent(getCtx(), firebaseMessagingService.getClass());


        mcomprobadorActualizacionesIntent = new Intent(getCtx(), MonesterioServicioComprobadorActualizaciones.class);

        //monestStartService(firebaseInstanceIDService, mFirebaseInstanceIdIntent);
        //monestStartService(firebaseMessagingService, mFirebaseMessagingIntent);

        monestStartService(MonesterioServicioComprobadorActualizaciones.class, mcomprobadorActualizacionesIntent);
    }

    @Override
    protected void finInicioActivity() {
        //FirebaseMessaging.getInstance().subscribeToTopic("allDevices");
        Intent intent = new Intent(this, MonesterioMainActivity.class);
        startActivity(intent);
        finish();
    }

    private void monestStartService(Class<?> clazz, Intent intent) {
        if (!isMyServiceRunning(clazz)) {
            startService(intent);
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.e("isMyServiceRunning?", true + "");
                return true;
            }
        }
        Log.e("isMyServiceRunning?", false + "");
        return false;
    }

    @Override
    protected void onDestroy() {
        //stopService(mFirebaseInstanceIdIntent);
        //stopService(mFirebaseMessagingIntent);

        stopService(mcomprobadorActualizacionesIntent);
        Log.e("MAINACT", "onDestroy!");
        super.onDestroy();

    }

}
