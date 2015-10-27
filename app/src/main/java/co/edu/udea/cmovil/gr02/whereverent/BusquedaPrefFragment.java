package co.edu.udea.cmovil.gr02.whereverent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//FRagmento usado por BusquedaPref
public class BusquedaPrefFragment extends Fragment {
    private Spinner ciudades,tipo,area,modo;
    public BusquedaPrefFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Se crea la vista que nos permite comunicarnos con el layout de el fragment y debe ser retornado por el metodo
        View v=inflater.inflate(R.layout.fragment_busqueda_pref, container, false);
        ciudades=(Spinner)v.findViewById(R.id.ciudades_spinner);
        tipo=(Spinner)v.findViewById(R.id.tipo_spinner);
        area=(Spinner)v.findViewById(R.id.area_spinner);
        modo=(Spinner)v.findViewById(R.id.modo_spinner);
        //Se crea un adapter para cada spinner el cual se le debe asignar un array del archivo array.xml de los values el cual sera las opciones del spinner
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(v.getContext()
                , R.array.Ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudades.setAdapter(adapter);
        adapter=ArrayAdapter.createFromResource(v.getContext()
                ,R.array.tipo,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
        adapter=ArrayAdapter.createFromResource(v.getContext()
                ,R.array.area,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        area.setAdapter(adapter);
        adapter=ArrayAdapter.createFromResource(v.getContext()
                ,R.array.modo,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modo.setAdapter(adapter);
        return v;
    }
}
