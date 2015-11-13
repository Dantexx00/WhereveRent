package co.edu.udea.cmovil.gr02.whereverent;


import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

//Actividad para implementar el GoogleMap.
public class BusquedaGpsActivity extends SubActivity {

    private GoogleMap googleMap;
    private MapView mapView;
    private Marker marker;
    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
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
        if(savedInstanceState==null) {
            mapView = (MapView)findViewById(R.id.mi_mapa);
            mapView.onCreate(savedInstanceState);
            googleMap = mapView.getMap();
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setMyLocationEnabled(true);
            googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener(){
                //Metodo que dice que hacer si se presiona por un momento en el googlemap
                @Override
                public void onMapLongClick(LatLng latLng){
                    Geocoder gc =new Geocoder(BusquedaGpsActivity.this);
                    List<Address> list=null;
                    try{
                        list=gc.getFromLocation(latLng.latitude,latLng.longitude,1);
                    }catch (IOException e){
                        e.printStackTrace();
                        return;
                    }
                    Address add=list.get(0);
                    setMarker(add.getLocality(), add.getCountryName(), latLng.latitude, latLng.longitude);
                }
            });
        }
    }
    //metodo para agregar el marcador
    public void setMarker(String locality,String country,double lat,double lng){
        MarkerOptions options=new MarkerOptions().title(locality).position(new LatLng(lat,lng))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.house)).draggable(true);
        if(country.length()>0){
            options.snippet(country);
        }
        //CReo que aqui esta la clave para que no se ponga la casita si no hemos guardado.
        marker=googleMap.addMarker(options);
        Intent intent=new Intent(this,AgregarInmuebleActivity.class);
        intent.putExtra("latitud", lat);
        intent.putExtra("longitud",lng);
        startActivity(intent);
    }
}
