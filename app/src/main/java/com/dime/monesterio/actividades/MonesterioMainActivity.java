package com.dime.monesterio.actividades;

import android.os.Bundle;
import android.view.View;

import com.dime.monesterio.R;
import com.dime.monesterio.menulateral.ConfigMenuLateral;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.dime.monesterio.util.ControlSlider;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.MainActivity;
import com.modulos.libreria.utilidadeslibreria.menulateral.ConfigMenuLateralFactory;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

/**
 * Created by h on 18/03/16.
 */
public class MonesterioMainActivity extends MainActivity {
    private final static String TAG = "MonesterioMainActivity";

    private ControlMenuLateral controlMenuLateral;
    private ControlSlider controlSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configMenuLateral();
    }

    protected void configMenuLateral() {
        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(com.modulos.libreria.dimepoblacioneslibreria.R.id.linearLayoutMenuLateral,
                com.modulos.libreria.dimepoblacioneslibreria.R.id.drawer_layout,
                com.modulos.libreria.dimepoblacioneslibreria.R.id.listMenuLateral
        );
        controlMenuLateral = cmlab.getControlMenuLateral();

        controlSlider = new ControlSlider(this);
        controlSlider.initSlider();
    }

    public void mostrarMenuLateral(View view) {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }


    // Stops the slider when the Activity is going into the background
    @Override
    protected void onPause() {
        super.onPause();
        controlSlider.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        controlSlider.resume();
    }
}
