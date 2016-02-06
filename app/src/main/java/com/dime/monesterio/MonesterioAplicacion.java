package com.dime.monesterio;

import android.util.Log;

import com.modulos.libreria.dimepoblacioneslibreria.aplicacion.DimeApplication;
import com.modulos.libreria.dimepoblacioneslibreria.singleton.SingletonDimePoblaciones;

/**
 * Created by h on 29/10/15.
 */
public class MonesterioAplicacion extends DimeApplication {

    private final static String TAG = "[MonesterioAplicacion]";

    public MonesterioAplicacion() {
        super();
        Log.d(TAG, "onCreate()");
        SingletonDimePoblaciones.getInstance().setIdIconoNotificacion(R.drawable.ic_action_notificacion);
        SingletonDimePoblaciones.getInstance().setIdLogoPoblacion(R.drawable.escudo_monesterio_logo);
        SingletonDimePoblaciones.getInstance().setIdLogoPoblacion(R.drawable.escudo_monesterio_logo);
        SingletonDimePoblaciones.getInstance().setIdLogoPoblacion(R.drawable.escudo_monesterio_logo);
    }
}
