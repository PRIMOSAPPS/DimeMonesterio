package com.dime.monesterio.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.modulos.libreria.dimepoblacioneslibreria.dao.impl.SitiosDataSource;
import com.modulos.libreria.utilidadeslibreria.almacenamiento.ItfAlmacenamiento;
import com.modulos.libreria.utilidadeslibreria.permisos.Permisos;
import com.modulos.libreria.utilidadeslibreria.preferencias.Preferencias;

/**
 * Created by h on 6/07/16.
 */
public class MonesterioActualizadorContenidoBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = "MonesterioActualizadorContenidoBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences ratePrefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = ratePrefs.edit();
        edit.putBoolean(Preferencias.PRIMER_ARRANQUE, true);
        edit.commit();

        vaciarSitios(context);
    }

    private void vaciarSitios(Context context) {
        SitiosDataSource dataSource = null;

        try {
            dataSource = new SitiosDataSource(context);
            dataSource.open();

            dataSource.deleteAll();
            dataSource.close();
        } finally {
            dataSource.close();
        }
    }
}
