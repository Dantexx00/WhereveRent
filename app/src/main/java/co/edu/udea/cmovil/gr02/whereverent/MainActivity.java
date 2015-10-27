package co.edu.udea.cmovil.gr02.whereverent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


//Actividad principal de la app
public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] opciones;
    private ActionBarDrawerToggle drawerToggle;
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Es el layout principal y permite la navigation drawer
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        //Es la lista de opciones de la navigation drawer esta contenido en el
        //activity_main
        listView=(ListView)findViewById(R.id.drawer_list);
        //Optiene la lista de opciones del array_strings para llenar el listView
        opciones=getResources().getStringArray(R.array.opciones);
        //Se asigna le adapter de la listView y se hace OnItemClickListener
        listView.setAdapter(new ArrayAdapter<>(this
                ,android.R.layout.simple_list_item_1,opciones));
        listView.setOnItemClickListener(this);
        //Se crea el drawer toogle que contiene la imagen de la hamburguesa
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_drawerr
                ,R.string.drawer_open,R.string.drawer_close){
            /*
            Metodos para cuando se cierra o abre el navigationa drawer, aun no se para
            que usarlos pero pueden servir para algo si no se pueden quitar
             */
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        /*
        Se asigan como DRawerListener el drawer toogle y se permite que en la barra
        aparezcan iconos como el de la hamburguesa.
         */
        drawerLayout.setDrawerListener(drawerToggle);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    //No se que hace
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //Por si cambia la configuracion
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
    //Pone el menu de la hamburguesa
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //Se define que hcer cuando se elige una opcion del navigation drawer
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,opciones[position]+" was selected", Toast.LENGTH_LONG ).show();
        switch (position){
            case 0:
                startActivity(new Intent(this,BusquedaGps.class));
                break;
            case 1:
                startActivity(new Intent(this,BusquedaPref.class));
                break;
            case 2:
                startActivity(new Intent(this,MisInmuebles.class));
                break;
            default:
                break;
        }
        selectedItem(position);
        setTitle(opciones[position]);
    }
    public void selectedItem(int position){
        listView.setItemChecked(position, true);
    }
    public void setTitle(String title){
        getActionBar().setTitle(title);
    }
}

