package co.edu.udea.cmovil.gr02.whereverent;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//Actividad de la que van a extender las actividades que usaran el navigation drawer
public class SubActivity extends Activity implements AdapterView.OnItemClickListener {
    //Este es el widget que llevan todos los layout que necesita usar el navigation drawer
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] opciones;
    //Este objeto permite que este el menu de la hamburguesa y que salga de el el menu
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    //Metodo que iniciara el navigation drawer recibe el id del navigation drawer que contiene el layout completo
    public void initNavigation(int id){
        //Es el layout principal y permite la navigation drawer
        drawerLayout=(DrawerLayout)findViewById(id);
        //Es la lista de opciones de la navigation drawer esta contenido en el la cual debe ser incluida en los layout que la usaran
        listView=(ListView)findViewById(R.id.drawer_list);
        //Obtiene la lista de opciones del array_strings para llenar el listView
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
        Se asigna como DrawerListener el drawer toogle y se permite que en la barra
        aparezcan iconos como el de la hamburguesa.
         */
        drawerLayout.setDrawerListener(drawerToggle);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
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
    //Asigna el menu de que ira en la actionbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //Se define que hacer cuando se elige una opcion del navigation drawer
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        changeFragment(position);
    }
    //Metodo que se encarga de cambiar el frament contenido en el framelayout container, que se encuentra en la actividad principal
    public void changeFragment(int position){
        Toast.makeText(this, opciones[position] + " was selected", Toast.LENGTH_LONG).show();
        switch (position){
            case 0:
                startActivity(new Intent(this,MainActivity.class));
                drawerLayout.closeDrawer(listView);
                break;
            case 1:
                startActivity(new Intent(this, BusquedaGpsActivity.class));
                drawerLayout.closeDrawer(listView);
                break;
            case 2:
                startActivity(new Intent(this,BusquedaPrefActivity.class));
                drawerLayout.closeDrawer(listView);
                break;
            case 3:
                startActivity(new Intent(this,MisInmueblesActivity.class));
                drawerLayout.closeDrawer(listView);
                break;
            default:
                break;
        }
    }
}
