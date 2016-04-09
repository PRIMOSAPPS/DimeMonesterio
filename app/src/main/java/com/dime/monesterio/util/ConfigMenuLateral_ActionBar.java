package com.dime.monesterio.util;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dime.monesterio.R;
import com.dime.monesterio.menulateral.ConfigMenuLateral;
import com.modulos.libreria.utilidadeslibreria.menulateral.ConfigMenuLateralFactory;
import com.modulos.libreria.utilidadeslibreria.menulateral.ControlMenuLateral;
import com.modulos.libreria.utilidadeslibreria.menulateral.IConfigMenuLateral;

/**
 * Created by h on 3/04/16.
 */
public class ConfigMenuLateral_ActionBar {
    private AppCompatActivity actividad;


    private ControlMenuLateral controlMenuLateral;

    public ConfigMenuLateral_ActionBar(AppCompatActivity actividad) {
        this.actividad = actividad;
    }

    public void configurar(int idLinearLayoutMenuLateral, int idDrawerLayout, int idListView) {

        configurarMenuLateral(idLinearLayoutMenuLateral, idDrawerLayout, idListView);

        configurarActionBar();
    }

    private void configurarMenuLateral(int idLinearLayoutMenuLateral, int idDrawerLayout, int idListView) {

        IConfigMenuLateral cml = ConfigMenuLateralFactory.getInstance().getConfigMenuLateral();
        if(cml == null) {
            cml = new ConfigMenuLateral();
            cml.configurarMenuLateral(actividad, idListView, idDrawerLayout);
            ConfigMenuLateralFactory.getInstance().setConfigMenuLateral(cml);
        }

        controlMenuLateral = new ControlMenuLateral(actividad, idLinearLayoutMenuLateral,
                idDrawerLayout);

        ConfigMenuLateralFactory.getInstance().getConfigMenuLateral().configurarMenuLateral(actividad, idListView, idDrawerLayout);
    }

    private void configurarActionBar() {
        // Action bar
        ActionBar actionBar = actividad.getSupportActionBar();
        if(actionBar != null) {
            View customActionBarView = actividad.getLayoutInflater().inflate(com.modulos.libreria.dimepoblacioneslibreria.R.layout.action_bar_custom, null);
            actionBar.setCustomView(customActionBarView);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        }
    }

    public ControlMenuLateral getControlMenuLateral() {
        return controlMenuLateral;
    }
}
