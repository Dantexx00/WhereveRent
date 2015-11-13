package co.edu.udea.cmovil.gr02.whereverent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Actividad principal de la app
public class MainActivity extends SubActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3;
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se inicializa el navigation drawer con este metodo de la clase subactivity
        super.initNavigation(R.id.drawer_layout_main);
        //SE conectan los botones y se asignan como onClickListener
        btn1=(Button)findViewById(R.id.home_btn1);
        btn2=(Button)findViewById(R.id.home_btn2);
        btn3=(Button)findViewById(R.id.home_btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
    //Se elige la accion de cada boton
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_btn1:
                startActivity(new Intent(this, BusquedaGpsActivity.class));
                break;
            case R.id.home_btn2:
                startActivity(new Intent(this, BusquedaPrefActivity.class));
                break;
            case R.id.home_btn3:
                startActivity(new Intent(this, AgregarInmuebleActivity.class));
                break;
            default:
                break;
        }
    }
}

