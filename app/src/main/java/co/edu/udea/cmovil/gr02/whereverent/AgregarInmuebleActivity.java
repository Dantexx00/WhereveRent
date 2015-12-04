package co.edu.udea.cmovil.gr02.whereverent;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.model.CameraPosition;

import java.util.ArrayList;

//Actividad para agregar un nuevo inmueble
public class AgregarInmuebleActivity extends SubActividadGps {
    private Spinner tipo,area,modo;
    private Button guardar;
    private String ciudad,pais;
    private int id;
    CameraPosition positionActual;
    private EditText precio, contacto,descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_inmueble);
        //Se inicializan los datos que se mandaron en el intent.
        setLatitud(getIntent().getDoubleExtra("latitud",0));
        setLongitud(getIntent().getDoubleExtra("longitud",0));
        ciudad=getIntent().getStringExtra("ciudad");
        pais=getIntent().getStringExtra("pais");
        //Se conectan los objetos del layout y se asignan adapters a los spinner
        tipo=(Spinner)findViewById(R.id.tipo_spinner_add);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this
                , R.array.tipo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
        area=(Spinner)findViewById(R.id.area_spinner_add);
        adapter=ArrayAdapter.createFromResource(this
                , R.array.area, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        area.setAdapter(adapter);
        modo=(Spinner)findViewById(R.id.modo_spinner_add);
        adapter=ArrayAdapter.createFromResource(this
                , R.array.modo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modo.setAdapter(adapter);
        contacto=(EditText)findViewById(R.id.contacto_add);
        descripcion=(EditText)findViewById(R.id.descripcion_add);
        precio=(EditText)findViewById(R.id.precio_max_add);
        //Boton para guardar los datos en la base datos y se asigna como onClickListener.
        guardar=(Button)findViewById(R.id.button_guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se crea el dbHelper, se obtiene la base de datos con permisos de escritura y el content value.
                if(!precio.getText().toString().equals("")) {
                    if(!contacto.getText().toString().equals("")) {
                        DbHelper dbHelper = new DbHelper(AgregarInmuebleActivity.this);
                        //Se usa el metodo para guardar en la sqlite.
                        dbHelper.saveProperty(dbHelper.getLastIdProperty() + 1, ciudad, tipo.getSelectedItem().toString(), area.getSelectedItem().toString(),
                                modo.getSelectedItem().toString(), contacto.getText().toString(), descripcion.getText().toString(),
                                precio.getText().toString(), getLatitud(), getLongitud(), pais);
                        Toast.makeText(AgregarInmuebleActivity.this,"Propiedad guardada satisfactoriamente.",Toast.LENGTH_SHORT).show();
                        //Se mandan los datos necesarios para tener la posicion deseada en el mapa
                        Intent intent=new Intent(AgregarInmuebleActivity.this, BusquedaGpsActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("latitud", getLatitud());
                        intent.putExtra("longitud", getLongitud());
                        startActivity(intent);
                    }else{
                        Toast.makeText(AgregarInmuebleActivity.this,"Ingrese el contacto por favor.",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AgregarInmuebleActivity.this,"Ingrese el precio del inmueble",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
