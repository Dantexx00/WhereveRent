package co.edu.udea.cmovil.gr02.whereverent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//Fragment de la actividad AddInmueble
public class AddInmuebleFragment extends Fragment {
    private Spinner ciudad;
    public AddInmuebleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Se retorna la vista que conecta con el layout del fragment
        View v = inflater.inflate(R.layout.fragment_add_inmueble, container, false);
        ciudad=(Spinner)v.findViewById(R.id.ciudades_spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(v.getContext()
                , R.array.Ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudad.setAdapter(adapter);
        return v;
    }
}
