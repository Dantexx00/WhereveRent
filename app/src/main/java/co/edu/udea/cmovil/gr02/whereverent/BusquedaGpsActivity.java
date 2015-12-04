package co.edu.udea.cmovil.gr02.whereverent;


import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Actividad para implementar el GoogleMap.
public class BusquedaGpsActivity extends SubActivity {
    private static final String LATITUDE="lat";
    private static final String LONGITUDE="long";
    private GoogleMap googleMap;
    private MapView mapView;

    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
        markers();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        //mapView.onDestroy();
    }

    @Override
    public void onPause(){
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_busqueda_gps);
        //Metodo de la clase subactivity para inicializar el navigation drawer
        super.initNavigation(R.id.drawer_layout_gps);
        //Se busca el mapview para instanciar el google map y asiganrlo como OnMapLongClickListener

        mapView = (MapView)findViewById(R.id.mi_mapa);
        mapView.onCreate(savedInstanceState);
        googleMap = mapView.getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            //Metodo que dice que hacer si se presiona por un momento en el googlemap
            @Override
            public void onMapLongClick(LatLng latLng) {
                Geocoder gc = new Geocoder(BusquedaGpsActivity.this);
                List<Address> list = null;
                try {
                    list = gc.getFromLocation(latLng.latitude, latLng.longitude, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                Address add = list.get(0);

                //Se utiliza el metodo para agregar un nuevo inmueble
                if (!(add.getLocality() == null)) {
                    setMarker(add.getLocality(), add.getCountryName(), latLng.latitude, latLng.longitude);
                } else {
                    setMarker(add.getFeatureName(), add.getCountryName(), latLng.latitude, latLng.longitude);
                }
            }
        });
        //googlemap queda como OnMarkerListener y muestra los detalles de un inmueble cuando se presiona sobre este.
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Intent intent = new Intent(BusquedaGpsActivity.this, InmuebleDetalles.class);
                intent.putExtra("latitud", marker.getPosition().latitude);
                intent.putExtra("longitud", marker.getPosition().longitude);
                startActivity(intent);
                return false;
            }
        });
        //Se deja la posicion en la que se estaba o si se entra por primera vez queda en colombia.
        LatLng medellin = new LatLng(4.644564,-74.070977);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, 6));
        markers();
    }
    //metodo para agregar el marcador de la casa
    public void setMarker(String locality,String country,double lat,double lng){
        //Se crea el intent que llevara los datos necesarios para agregar correctamente la casa.
        Intent intent=new Intent(this,AgregarInmuebleActivity.class);
        intent.putExtra("latitud", lat);
        intent.putExtra("longitud", lng);
        intent.putExtra("ciudad", locality);
        intent.putExtra("pais", country);
        intent.putExtra("zoom",googleMap.getCameraPosition().zoom);
        //Se arranca la actividad para agregar la casa.
        startActivity(intent);
    }
    //Metodo para ubicar en el mapa los marcadores de la base de datos
    public void markers(){
        //Se instancia el dbhelper para obtener las propiedades de la base y asi poner los respectivos marcadores de estas.
        DbHelper dbHelper=new DbHelper(this);
        //Mediante el metodo del dbHelper se obtienen las propiedades que se necesitan.
        ArrayList<Property> propiedades= dbHelper.getAllProperties();
        //Se recorren las propiedades y las ubicamos en el mapa.
        if(!propiedades.isEmpty()){
            for(int i=0;i<propiedades.size();i++){
                marker(propiedades.get(i).getCiudad(),propiedades.get(i).getPais(),
                        propiedades.get(i).getLatitud(),propiedades.get(i).getLongitud());
            }
        }

    }
    //Metodo para ubicar las propiedades en el mapa
    public void marker(String locality,String country,double lat,double lng){
        MarkerOptions options=new MarkerOptions().title(locality).position(new LatLng(lat,lng))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house)).draggable(true);
        if(country.length()>0){
            options.snippet(country);
        }
        googleMap.addMarker(options);
    }

}
