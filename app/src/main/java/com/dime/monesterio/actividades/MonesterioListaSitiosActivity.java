package com.dime.monesterio.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.dime.monesterio.R;
import com.dime.monesterio.actividades.detalle.MonesterioDetalleSitioActivity;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.dime.monesterio.util.ControlActionBar;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.ListaSitiosActivity;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.PreferenciasActivity;
import com.modulos.libreria.dimepoblacioneslibreria.dto.SitioDTO;
import com.modulos.libreria.utilidadeslibreria.menulateral.ConfigMenuLateralFactory;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

public class MonesterioListaSitiosActivity extends ListaSitiosActivity {

    private ControlMenuLateral controlMenuLateral;
    private ControlActionBar controlActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(R.id.listaSitiosLinearLayoutMenuLateral, R.id.listaSitiosDrawerLayout, R.id.listMenuLateral);
        controlMenuLateral = cmlab.getControlMenuLateral();

        controlActionBar = new ControlActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return controlActionBar.onOptionsItemSelected(this, item);
    }

    public void irPreferencias(MenuItem item) {
        Intent i = new Intent(this, PreferenciasActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_monesterio_lista_sitios);
    }

    public void mostrarMenuLateral(View view) {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }

    public void mostrarDetalle(View view) {
        SitioDTO sitio = (SitioDTO)view.getTag();
        Intent intent = new Intent(this, MonesterioDetalleSitioActivity.class);
        intent.putExtra("idSitio", sitio.getId());
        this.startActivity(intent);
    }

}
