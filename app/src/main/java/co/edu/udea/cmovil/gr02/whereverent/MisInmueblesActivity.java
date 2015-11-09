package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;

//Actividad MisInmuebles
public class MisInmueblesActivity extends SubActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se retorna la vista que conecta con el layout del fragment
        setContentView(R.layout.activity_mis_inmuebles);
        //Se inicializa el navigation drawer con le metodo de la clase subactivity
        initNavigation(R.id.drawer_layout_mis_inmuebles);
    }
}
