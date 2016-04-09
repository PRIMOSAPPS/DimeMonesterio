package com.dime.monesterio.actividades.detalle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.dime.monesterio.R;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.detalle.DetalleNotificacionActivity;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

public class MonesterioDetalleNotificacionActivity extends DetalleNotificacionActivity {

    private ControlMenuLateral controlMenuLateral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(R.id.detalleNotificacionLinearLayoutMenuLateral, R.id.detalleNotificacionDrawerLayout, R.id.listMenuLateral);
        controlMenuLateral = cmlab.getControlMenuLateral();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_monesterio_detalle_notificacion);
    }

    public void mostrarMenuLateral(View view) {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }
}
