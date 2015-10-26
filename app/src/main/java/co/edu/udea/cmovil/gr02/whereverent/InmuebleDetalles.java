package co.edu.udea.cmovil.gr02.whereverent;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
//Actividad que muestra los detalles de un inmueble, se llega a el desde BusquedaGps al tocar el drawable del inmueble
public class InmuebleDetalles extends SubActividadGps{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se asigna el fragment
        if(savedInstanceState==null) {
            InmuebleDetallesFragment fragment = new InmuebleDetallesFragment();
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content,fragment
                            ,fragment.getClass().getSimpleName()).commit();
        }
    }
}
