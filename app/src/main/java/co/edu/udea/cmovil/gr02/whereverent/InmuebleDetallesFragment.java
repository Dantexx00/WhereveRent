package co.edu.udea.cmovil.gr02.whereverent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//Fragment de la actividad InmuebleDetalles
public class InmuebleDetallesFragment extends Fragment {

    public InmuebleDetallesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Se retorna la vista que conecta con el layout del fragment
       return inflater.inflate(R.layout.fragment_inmueble_detalles, container, false);
    }


}
