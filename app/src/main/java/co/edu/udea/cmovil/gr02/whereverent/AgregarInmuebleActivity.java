package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//Actividad para agregar un nuevo inmueble
public class AgregarInmuebleActivity extends SubActividadGps {
    private Spinner ciudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_inmueble);

        ciudad=(Spinner)findViewById(R.id.ciudades_spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this
                , R.array.Ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudad.setAdapter(adapter);
    }
}
