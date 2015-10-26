package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;
//Actividad que usa ver el formulario de preferencias para busqueda, debe extender de la SubActivity
public class BusquedaPref extends SubActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Aqui se asigna el fragment para la actividad
        if(savedInstanceState==null) {
            BusquedaPrefFragment fragment = new BusquedaPrefFragment();
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content,fragment
                            ,fragment.getClass().getSimpleName()).commit();
        }
    }

}
