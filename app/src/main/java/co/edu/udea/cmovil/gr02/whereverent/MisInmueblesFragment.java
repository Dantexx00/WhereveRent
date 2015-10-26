package co.edu.udea.cmovil.gr02.whereverent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//Fragment de la actividad MisInmuebles
public class MisInmueblesFragment extends Fragment {

    public MisInmueblesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Se retorna la vista que conecta con el layout del fragment
        return inflater.inflate(R.layout.fragment_mis_inmuebles, container, false);
    }
}
