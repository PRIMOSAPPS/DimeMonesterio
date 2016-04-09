package com.dime.monesterio.actividades;

import android.content.Intent;

import com.modulos.libreria.dimepoblacioneslibreria.actividades.InicioActivity;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.MainActivity;

/**
 * Created by h on 18/03/16.
 */
public class MonesterioInicioActivity extends InicioActivity {

    @Override
    protected void finInicioActivity() {
        Intent intent = new Intent(this, MonesterioMainActivity.class);
        startActivity(intent);
        finish();
    }
}
