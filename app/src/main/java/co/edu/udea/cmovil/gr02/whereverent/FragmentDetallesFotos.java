package co.edu.udea.cmovil.gr02.whereverent;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//Fragment que mostrara las fotos del inmueble, sera llamado desde inmuebleDetalles
public class FragmentDetallesFotos extends Fragment {


    public FragmentDetallesFotos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Se retorna la vista que conecta con el layout del fragment
        return inflater.inflate(R.layout.fragment_detalles_fotos,container,false);

    }


}
