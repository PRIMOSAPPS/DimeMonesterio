package com.dime.monesterio.actividades.detalle;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.dime.monesterio.R;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.detalle.DetalleSitioActivity;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

public class MonesterioDetalleSitioActivity extends DetalleSitioActivity {

    private ControlMenuLateral controlMenuLateral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(R.id.detalleSitioLinearLayoutMenuLateral, R.id.detalleSitioDrawerLayout, R.id.listMenuLateral);
        controlMenuLateral = cmlab.getControlMenuLateral();

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_monesterio_detalle_sitio);
    }

    public void mostrarMenuLateral(View view) {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }
}
