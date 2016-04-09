package com.dime.monesterio.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.dime.monesterio.R;
import com.dime.monesterio.actividades.detalle.MonesterioDetalleNotificacionActivity;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.ListaNotificacionesActivity;
import com.modulos.libreria.dimepoblacioneslibreria.dto.NotificacionDTO;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

public class MonesterioListaNotificacionesActivity extends ListaNotificacionesActivity {

    private ControlMenuLateral controlMenuLateral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(R.id.listaNotificacionesLinearLayoutMenuLateral, R.id.listaNotificacionesDrawerLayout, R.id.listMenuLateral);
        controlMenuLateral = cmlab.getControlMenuLateral();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_monesterio_lista_notificaciones);
    }

    public void mostrarMenuLateral(View view) {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }


    public void mostrarDetalle(View view) {
        NotificacionDTO notificacion = (NotificacionDTO)view.getTag();

        Intent intent = new Intent(this, MonesterioDetalleNotificacionActivity.class);
        intent.putExtra(MonesterioDetalleNotificacionActivity.ID_NOTIFICACION, notificacion.getId());
        startActivity(intent);
    }
}
