package com.dime.monesterio.actividades;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.dime.monesterio.R;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.dime.monesterio.util.ControlActionBar;
import com.modulos.libreria.buzonciudadanolibreria.BuzonCiudadanoActivity;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

public class MonesterioBuzonCiudadanoActivity extends BuzonCiudadanoActivity {

    private ControlMenuLateral controlMenuLateral;
    private ControlActionBar controlActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(R.id.buzonCiudadanoLinearLayoutMenuLateral, R.id.buzonCiudadanoDrawerLayout, R.id.listMenuLateral);
        controlMenuLateral = cmlab.getControlMenuLateral();

        controlActionBar = new ControlActionBar();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return controlActionBar.onOptionsItemSelected(this, item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_monesterio_buzon_ciudadano);
    }

    public void mostrarMenuLateral(View view) {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }

}
