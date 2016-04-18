package com.dime.monesterio.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ToggleButton;

import com.dime.monesterio.R;
import com.dime.monesterio.util.ConfigMenuLateral_ActionBar;
import com.dime.monesterio.util.ControlActionBar;
import com.dime.monesterio.util.ControlSlider;
import com.modulos.libreria.dimepoblacioneslibreria.actividades.PreferenciasActivity;
import com.modulos.libreria.radiolibreria.StreamPlayerActivity;
import com.modulos.libreria.utilidadeslibreria.menulateral.ConfigMenuLateralFactory;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;

/**
 * Created by h on 18/03/16.
 */
public class MonesterioStreamPlayerActivity extends StreamPlayerActivity {

    private ControlMenuLateral controlMenuLateral;
    private ControlSlider controlSlider;
    private ControlActionBar controlActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

        ConfigMenuLateral_ActionBar cmlab = new ConfigMenuLateral_ActionBar(this);
        cmlab.configurar(R.id.radioLinearLayoutMenuLateral, R.id.radioDrawerLayout, R.id.listMenuLateral);
        controlMenuLateral = cmlab.getControlMenuLateral();

        controlSlider = new ControlSlider(this);
        controlSlider.initSlider();

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

    public void playPause(View view) {
        ToggleButton playPauseButton = (ToggleButton)this.findViewById(R.id.libRadioPlayPauseButton);
        if(playPauseButton.isChecked()) {
            this.pause(view);
        } else {
            this.play(view);
        }

    }

    @Override
    protected void initSeekBarrVolumen() {
    }

    @Override
    protected void updateProgressBar() {
    }

    private void mostrarOcultarMenuLateral() {
        controlMenuLateral.mostrarOcultarMenuLateral();
    }

    public void mostrarMenuLateral(View view) {
        mostrarOcultarMenuLateral();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.monesterio_activity_stream_player);
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
