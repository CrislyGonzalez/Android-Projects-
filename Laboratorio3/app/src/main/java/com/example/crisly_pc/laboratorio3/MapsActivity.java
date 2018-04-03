package com.example.crisly_pc.laboratorio3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener ,
        GoogleMap.OnMarkerDragListener , GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private static final int LOCATION_REQUEST_CODE = 101;
    private Marker markerGeneral;
    private Marker markerQuesadaCity;
    private Marker markerToscana;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.MenuOpcion1:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.MenuOpcion2:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.MenuOpcion3:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;

            case R.id.MenuOpcion4:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    protected void requestPermission(String permissionType ,
                                     int requestCode) {
        ActivityCompat.requestPermissions(this ,
                new String[]{permissionType}, requestCode
        ) ;
    }

    @Override
    public void onRequestPermissionsResult( int requestCode ,
                                            String permissions[], int []
                                                    grantResults) {
        switch (requestCode) {
            case LOCATION_REQUEST_CODE: {

                if (grantResults.length == 0
                        || grantResults [0] !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this ,
                            " Unable to show location - permission required ",
                            Toast.LENGTH_LONG).show();
                } else {
                    SupportMapFragment mapFragment =
                            (SupportMapFragment) getSupportFragmentManager()
                                    .findFragmentById(R.id.map);
                    mapFragment.getMapAsync( this ) ;
                }
            }
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        /*
        if (mMap != null ) {
            int permission = ContextCompat.checkSelfPermission(this ,
                    Manifest.permission.ACCESS_FINE_LOCATION);
            if (permission == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled( true ) ;
            } else {
                requestPermission(
                        Manifest.permission.ACCESS_FINE_LOCATION ,
                        LOCATION_REQUEST_CODE);
            }
        }

        */

        // Add a marker in Sydney and move the camera
        LatLng tecSantaClara = new LatLng(10.3652,-84.512);
        markerGeneral = googleMap.addMarker(new MarkerOptions().position(tecSantaClara).title("Tec-Santa Clara"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tecSantaClara));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tecSantaClara));
        googleMap.setOnInfoWindowClickListener( this ) ;


        LatLng toscana = new LatLng(10.362,-84.4785);
        markerToscana = googleMap.addMarker(new MarkerOptions().position(toscana).title("Cafetería Toscana").icon(BitmapDescriptorFactory.fromResource(R.drawable.coffee)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toscana));


        LatLng quesadaCity = new LatLng( 10.3271, -84.4357);
        markerQuesadaCity = googleMap.addMarker(new MarkerOptions().position(quesadaCity).title("Ciudad Quesada").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quesadaCity));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(quesadaCity));
        googleMap.setOnInfoWindowClickListener( this ) ;
        googleMap.setOnMarkerDragListener( this ) ;

        Polyline line = mMap . addPolyline ( new PolylineOptions()
                . add (quesadaCity  , tecSantaClara)
                . width (25)
                . color ( Color. BLUE )
                . geodesic ( false ));


        UiSettings mapSettings;
        mapSettings = mMap.getUiSettings();
        mapSettings.setZoomControlsEnabled( true ) ; // Set Zoom Controls
        mapSettings.setAllGesturesEnabled( true ); // Set All Gestures
        mapSettings.setScrollGesturesEnabled( true ) ; // Set Scroll
        mapSettings.setTiltGesturesEnabled( true ) ; // Set Tilt
        mapSettings.setRotateGesturesEnabled( true ) ; // Set Rotate

    }


    @Override
    public void onInfoWindowClick(Marker marker) {

        //Toast.makeText(getApplicationContext(),"xx", Toast.LENGTH_SHORT).show();
        if (marker.equals(markerGeneral)) {
            TecDialogFragment.newInstance(marker.getTitle(),
                    getString(R.string.tec_santa_clara_full_snippet))
                    .show(getSupportFragmentManager(), null ) ;
        }

        if (marker.equals(markerToscana)) {
            TecDialogFragment.newInstance(marker.getTitle(),
                    getString(R.string.toscanaText))
                    .show(getSupportFragmentManager(), null ) ;
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(markerQuesadaCity)) {
            Toast.makeText(this , " START ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        Toast.makeText(getApplicationContext(),"in", Toast.LENGTH_SHORT).show();
        if (marker.equals(markerQuesadaCity)) {
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng),
                    marker.getPosition().latitude ,
                    marker.getPosition().longitude);
            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.equals(markerQuesadaCity)) {
            Toast.makeText(this , " END ", Toast.LENGTH_SHORT).show();
        }
    }
}
