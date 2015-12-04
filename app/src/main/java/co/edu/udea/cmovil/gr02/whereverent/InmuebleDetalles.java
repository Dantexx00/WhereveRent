package co.edu.udea.cmovil.gr02.whereverent;

import android.os.Bundle;
import android.widget.TextView;


//Actividad que muestra los detalles de un inmueble, se llega a el desde BusquedaGpsActivity al tocar el drawable del inmueble
public class InmuebleDetalles extends SubActividadGps{
    TextView ciudad,tipo,precio,area,modo,descripcion,contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmueble_detalles);
        //Se inicializan los objetos de la vista
        setLatitud(getIntent().getDoubleExtra("latitud", 0));
        setLongitud(getIntent().getDoubleExtra("longitud", 0));
        ciudad=(TextView)findViewById(R.id.ciudad);
        tipo=(TextView)findViewById(R.id.tipo);
        precio=(TextView)findViewById(R.id.precio);
        area=(TextView)findViewById(R.id.area);
        modo=(TextView)findViewById(R.id.modo);
        descripcion=(TextView)findViewById(R.id.descripcion);
        contacto=(TextView)findViewById(R.id.contacto);
        cargarDetalles();
    }
    //Metodo que carga de la base de datos los detalles del inmueble en cuestion
    public void cargarDetalles(){
        DbHelper dbHelper=new DbHelper(this);
        Property property=dbHelper.findPropertyByLocation(getLatitud(),getLongitud());
        ciudad.setText(property.getCiudad());
        tipo.setText(property.getTipo());
        precio.setText(property.getPrecio());
        area.setText(property.getArea());
        modo.setText(property.getModo());
        descripcion.setText(property.getDescripcion());
        contacto.setText(property.getContacto());
    }
}
