package com.dime.monesterio.pushreceiver;

import com.dime.monesterio.actividades.detalle.MonesterioDetalleNotificacionActivity;
import com.modulos.libreria.dimepoblacioneslibreria.pushreceiver.PushParseReceiver;

/**
 * Created by h on 6/04/16.
 */
public class MonesterioPushParseReceiver extends PushParseReceiver {

    @Override
    protected Class getClassNotificacion() {
        return MonesterioDetalleNotificacionActivity.class;
    }
}
