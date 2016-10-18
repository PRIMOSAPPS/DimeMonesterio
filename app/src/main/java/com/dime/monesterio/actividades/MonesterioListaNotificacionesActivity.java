package com.dime.monesterio.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.dime.monesterio.R;
import com.dime.monesterio.actividades.detalle.MonesterioDetalleNotificacionActivity;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.dime.monesterio.util.ControlActionBar;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.ListaNotificacionesActivity;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.PreferenciasActivity;
import com.modulos.libreria.dimepoblacioneslibreria.adaptadores.NotificacionAdaptador;
import com.modulos.libreria.dimepoblacioneslibreria.adaptadores.SitioAdaptador;
import com.modulos.libreria.dimepoblacioneslibreria.dto.NotificacionDTO;
import com.modulos.libreria.dimepoblacioneslibreria.dto.SitioDTO;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

public class MonesterioListaNotificacionesActivity extends ListaNotificacionesActivity {

    private ControlMenuLateral controlMenuLateral;
    private ControlActionBar controlActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(R.id.listaNotificacionesLinearLayoutMenuLateral, R.id.listaNotificacionesDrawerLayout, R.id.listMenuLateral);
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
        super.setContentView(R.layout.activity_monesterio_lista_notificaciones);
    }

    public void mostrarMenuLateral(View view) {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }


    public void mostrarDetalle(View view) {
        NotificacionAdaptador.ViewHolder viewHolder = (NotificacionAdaptador.ViewHolder)view.getTag();
        NotificacionDTO notificacion = viewHolder.getNotificacion();

        Intent intent = new Intent(this, MonesterioDetalleNotificacionActivity.class);
        intent.putExtra(MonesterioDetalleNotificacionActivity.ID_NOTIFICACION, notificacion.getId());
        startActivity(intent);
    }
}
