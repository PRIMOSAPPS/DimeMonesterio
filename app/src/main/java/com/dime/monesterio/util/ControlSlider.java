package com.dime.monesterio.util;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

import com.dime.monesterio.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by h on 3/04/16.
 */
public class ControlSlider {

    private Activity actividad;

    private int[] gallery = {R.drawable.slide001, R.drawable.slide002, R.drawable.slide003, R.drawable.slide004, R.drawable.slide005, R.drawable.slide006, R.drawable.slide007};

    private ImageSwitcher imageSwitcher;

    private int position;

    private static final Integer DURATION = 5000;

    private Timer timer = null;

    public ControlSlider(Activity actividad) {
        this.actividad = actividad;
    }

    public void initSlider() {
        imageSwitcher = (ImageSwitcher) actividad.findViewById(com.modulos.libreria.dimepoblacioneslibreria.R.id.imageSlider);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(actividad);
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));
                return myView;
            }
        });
        /*
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                return new ImageView(actividad);
            }
        });
        */

        // Set animations
        // https://danielme.com/2013/08/18/diseno-android-transiciones-entre-activities/
        Animation fadeIn = AnimationUtils.loadAnimation(actividad, com.modulos.libreria.dimepoblacioneslibreria.R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(actividad, com.modulos.libreria.dimepoblacioneslibreria.R.anim.fade_out);
        imageSwitcher.setInAnimation(fadeIn);
        imageSwitcher.setOutAnimation(fadeOut);

        startSlider();
    }


    private void startSlider() {
        timer = new Timer("ControlSlider_" + actividad.getClass().getName());
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                // avoid exception:
                // "Only the original thread that created a view hierarchy can touch its views"
                actividad.runOnUiThread(new Runnable() {
                    public void run() {
                        imageSwitcher.setImageResource(gallery[position]);
                        position++;
                        if (position == gallery.length) {
                            position = 0;
                        }
                    }
                });
            }

        }, 0, DURATION);
    }

    // Stops the slider when the Activity is going into the background
    public void pause() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void resume() {
        if (timer == null) {
            startSlider();
        }

    }

}
