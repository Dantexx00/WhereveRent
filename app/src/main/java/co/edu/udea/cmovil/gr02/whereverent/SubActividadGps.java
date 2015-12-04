package co.edu.udea.cmovil.gr02.whereverent;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;

//Actividad creada para que extiendan las actividades generadas desde la BUsquedaGps
public class SubActividadGps extends Activity {
    private double latitud;
    private double longitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Permite mostrar la flecha para retornar a la actividad anterior
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //METODO PARA GESTIONAR LO ELEGIDO EN LA ACTIONBAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Intent que permite volver a la BusquedaGpsActivity
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
