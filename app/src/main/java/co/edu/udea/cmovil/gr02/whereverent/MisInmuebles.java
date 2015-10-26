package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;
import android.app.Activity;
//Actividad la cual mostrara los inmuebles ingresados por el usuario, debe extender de la SubActivity
public class MisInmuebles extends SubActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se asigna el fragment
        if(savedInstanceState==null) {
            MisInmueblesFragment fragment = new MisInmueblesFragment();
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content,fragment
                            ,fragment.getClass().getSimpleName()).commit();
        }
    }

}
