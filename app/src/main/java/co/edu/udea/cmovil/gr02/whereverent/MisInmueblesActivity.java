package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//Actividad MisInmuebles
public class MisInmueblesActivity extends SubActivity {
    ListView misInmuebles;
    String inmuebles[];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se retorna la vista que conecta con el layout del fragment
        setContentView(R.layout.activity_mis_inmuebles);
        //Se inicializa el navigation drawer con le metodo de la clase subactivity
        initNavigation(R.id.drawer_layout_mis_inmuebles);
        //Se inicializa la lista se recogen los datos de la db y se utilizan con el adapter
        misInmuebles=(ListView)findViewById(R.id.lista_mis_inmuebles);
        misInmuebles();
        if(inmuebles!=null) {
            misInmuebles.setAdapter(new ArrayAdapter<String>(this, R.layout.item_citas, R.id.text1, inmuebles));
        }else{

        }
    }
    public void misInmuebles() {
        DbHelper dbHelper= new DbHelper(this);//Instancia de DbHelper
        inmuebles=dbHelper.getMyInmuebles();
    }
}
