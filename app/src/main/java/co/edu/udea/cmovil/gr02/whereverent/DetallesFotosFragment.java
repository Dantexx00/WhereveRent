package co.edu.udea.cmovil.gr02.whereverent;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//Fragment que mostrara las fotos del inmueble, sera llamado desde inmuebleDetalles
public class DetallesFotosFragment extends Fragment {


    public DetallesFotosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Se retorna la vista que conecta con el layout del fragment
        return inflater.inflate(R.layout.fragment_detalles_fotos,container,false);

    }


}
