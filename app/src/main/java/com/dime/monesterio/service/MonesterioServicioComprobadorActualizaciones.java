package com.dime.monesterio.service;

import com.dime.monesterio.actividades.detalle.MonesterioDetalleNotificacionActivity;
import com.modulos.libreria.dimepoblacioneslibreria.service.ServicioComprobadorActualizaciones;

/**
 * Created by h on 13/05/16.
 */
public class MonesterioServicioComprobadorActualizaciones extends ServicioComprobadorActualizaciones {

    public MonesterioServicioComprobadorActualizaciones() {
        super();
    }

    @Override
    protected Class getClassNotificacion() {
        return MonesterioDetalleNotificacionActivity.class;
    }
}
