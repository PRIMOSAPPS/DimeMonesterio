package com.dime.monesterio.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dime.monesterio.actividades.detalle.MonesterioDetalleNotificacionActivity;
import com.dime.monesterio.service.MonesterioServicioComprobadorActualizaciones;
import com.modulos.libreria.dimepoblacioneslibreria.service.ComprobadorActualizacionNotificaciones;

/**
 * Created by h on 13/05/16.
 */
public class ConexionComprobadorBroadcastReceiver extends BroadcastReceiver {
    public ConexionComprobadorBroadcastReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        final Context conexto = context;
        Log.d("PRUEBA", "Se ha recibido un mensaje.");
        Thread thComprobador = new Thread("ComprobacionBroadcastReceiver") {
            @Override
            public void run() {
                ComprobadorActualizacionNotificaciones comprobador = new ComprobadorActualizacionNotificaciones(conexto, MonesterioDetalleNotificacionActivity.class);
                comprobador.comprobar();
            }
        };
        thComprobador.start();
    }
}
