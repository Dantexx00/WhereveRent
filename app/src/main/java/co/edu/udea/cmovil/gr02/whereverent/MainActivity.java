package co.edu.udea.cmovil.gr02.whereverent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
//Actividad principal de la app
public class MainActivity extends Activity implements View.OnClickListener{
    private Button mButton1,mButton2,mButton3;
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1=(Button)findViewById(R.id.button_gps);
        mButton2=(Button)findViewById(R.id.button_pref);
        mButton3=(Button)findViewById(R.id.button_mis_inmuebles);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_gps:
                startActivity(new Intent(this,BusquedaGps.class));
                break;
            case R.id.button_pref:
                startActivity(new Intent(this, BusquedaPref.class));
                break;
            case R.id.button_mis_inmuebles:
                startActivity(new Intent(this,AddInmueble.class));
                break;
            default:
                break;
        }
    }
}

