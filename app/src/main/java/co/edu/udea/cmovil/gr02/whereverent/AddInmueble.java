package co.edu.udea.cmovil.gr02.whereverent;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
//Actividad para agregar un nuevo inmueble
public class AddInmueble extends SubActividadGps {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se asigna le fragment
        if(savedInstanceState==null) {
            AddInmuebleFragment fragment = new AddInmuebleFragment();
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content,fragment
                            ,fragment.getClass().getSimpleName()).commit();
        }
    }
}
