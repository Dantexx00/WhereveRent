package co.edu.udea.cmovil.gr02.whereverent;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//Actividad para agregar un nuevo inmueble
public class AgregarInmuebleActivity extends SubActividadGps {
    private Spinner ciudad,tipo,area,modo;
    private Button guardar;
    private double latitud,longitud;
    private EditText precio, contacto,descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_inmueble);
        //Inicio la base de datos
        latitud=getIntent().getDoubleExtra("latitud", 0);
        longitud= getIntent().getDoubleExtra("longitud",0);
        DbHelper dbHelper=new DbHelper(this);
        final SQLiteDatabase db=dbHelper.getWritableDatabase();
        final ContentValues values=new ContentValues();
        //Spinners del formulario.
        ciudad=(Spinner)findViewById(R.id.ciudades_spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this
                , R.array.Ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudad.setAdapter(adapter);
        tipo=(Spinner)findViewById(R.id.tipo_spinner);
        adapter=ArrayAdapter.createFromResource(this
                , R.array.tipo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
        area=(Spinner)findViewById(R.id.area_spinner);
        adapter=ArrayAdapter.createFromResource(this
                , R.array.area, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        area.setAdapter(adapter);
        modo=(Spinner)findViewById(R.id.modo_spinner);
        adapter=ArrayAdapter.createFromResource(this
                , R.array.modo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modo.setAdapter(adapter);
        contacto=(EditText)findViewById(R.id.contacto);
        descripcion=(EditText)findViewById(R.id.descripcion);
        precio=(EditText)findViewById(R.id.precio_max_edit_text);
        //Boton para guardar los datos en la base datos.
        guardar=(Button)findViewById(R.id.button_guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.clear();
                values.put(PropertyContract.Column.ID, 1);
                values.put(PropertyContract.Column.CIUDAD, ciudad.getSelectedItem().toString());
                values.put(PropertyContract.Column.TIPO, tipo.getSelectedItem().toString());
                values.put(PropertyContract.Column.AREA, area.getSelectedItem().toString());
                values.put(PropertyContract.Column.MODO, modo.getSelectedItem().toString());
                values.put(PropertyContract.Column.CONTACTO, contacto.getText().toString());
                values.put(PropertyContract.Column.DESCRIPCION, descripcion.getText().toString());
                values.put(PropertyContract.Column.PRECIO, precio.getText().toString());
                values.put(PropertyContract.Column.LATITUD,latitud);
                values.put(PropertyContract.Column.LONGITUD,longitud);
                db.insertWithOnConflict(PropertyContract.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
                Toast.makeText(AgregarInmuebleActivity.this,"dio",Toast.LENGTH_LONG).show();
            }
        });
    }
}
