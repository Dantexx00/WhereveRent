package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//Actividad busqueda por preferencias
public class BusquedaPrefActivity extends SubActivity {
    private Spinner ciudades,tipo,area,modo;
    public BusquedaPrefActivity() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //Se crea la vista que nos permite comunicarnos con el layout de el fragment y debe ser retornado por el metodo
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_busqueda_pref);
        //Metodo para inicializar el navigation drawer
        super.initNavigation(R.id.drawer_layout_pref);
        ciudades=(Spinner)findViewById(R.id.ciudades_spinner);
        tipo=(Spinner)findViewById(R.id.tipo_spinner);
        area=(Spinner)findViewById(R.id.area_spinner);
        modo=(Spinner)findViewById(R.id.modo_spinner);
        //Se crea un adapter para cada spinner el cual se le debe asignar un array del archivo array.xml de los values el cual sera las opciones del spinner
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudades.setAdapter(adapter);
        adapter=ArrayAdapter.createFromResource(this,R.array.tipo,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
        adapter=ArrayAdapter.createFromResource(this,R.array.area,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        area.setAdapter(adapter);
        adapter=ArrayAdapter.createFromResource(this,R.array.modo,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modo.setAdapter(adapter);
    }
}
