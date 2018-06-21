package com.example.claytonandrade.lanchonetemodelo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class OndeEstamos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onde_estamos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng LanchoneteModelo = new LatLng(-28.7279572,-49.303419);
        mMap.addMarker(new MarkerOptions().position(LanchoneteModelo).title("Lanchonete Modelo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LanchoneteModelo,19));

        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(19),8000,null);

        CameraPosition position = new CameraPosition.Builder().target(LanchoneteModelo).zoom(17).bearing(90).tilt(30).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_entrada_esquerda, R.anim.slide_saida_direita);
                break;
            default:

                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
