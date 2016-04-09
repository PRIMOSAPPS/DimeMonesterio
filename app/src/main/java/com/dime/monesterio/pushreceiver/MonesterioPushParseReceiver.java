package com.dime.monesterio.pushreceiver;

import android.content.Context;
import android.content.Intent;

import com.dime.monesterio.actividades.detalle.MonesterioDetalleNotificacionActivity;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.detalle.DetalleNotificacionActivity;
import com.modulos.libreria.dimepoblacioneslibreria.pushreceiver.PushParseReceiver;

/**
 * Created by h on 6/04/16.
 */
public class MonesterioPushParseReceiver extends PushParseReceiver {

    @Override
    protected Intent createResultIntent(Context context) {
        Intent resultIntent = new Intent(context, MonesterioDetalleNotificacionActivity.class);
        return resultIntent;
    }
}
