package co.edu.udea.cmovil.gr02.whereverent;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
//Actividad creada para que las 3 actividades principales BusquedaGps,BusquedaPref y MisInmuebles extiendan de el ya que este implementa la flecha de retorno en la actionbar
public class SubActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Metodo el cual permite que la flecha de retroceso de la actionbar sea mostrada
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //Metodo que gestiona las opciones seleccionadas en la actionbar, usado en esta clase para volver a la main activity desde las 3 actividades principales
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Intent que permite volver a la MainActivity
                startActivity(new Intent(this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
