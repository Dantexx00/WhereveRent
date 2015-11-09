package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;

//Actividad que muestra los detalles de un inmueble, se llega a el desde BusquedaGpsActivity al tocar el drawable del inmueble
public class InmuebleDetalles extends SubActividadGps{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmueble_detalles);
    }
}
