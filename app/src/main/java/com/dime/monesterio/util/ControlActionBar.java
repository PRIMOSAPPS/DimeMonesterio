package com.dime.monesterio.util;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.modulos.libreria.dimepoblacioneslibreria.actividades.PreferenciasActivity;

/**
 * Created by h on 11/04/16.
 */
public class ControlActionBar {
    public boolean onOptionsItemSelected(Activity actividad, MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.modulos.libreria.dimepoblacioneslibreria.R.id.action_settings) {
            Intent i = new Intent(actividad, PreferenciasActivity.class);
            actividad.startActivity(i);
        }
        return true;
    }
}
