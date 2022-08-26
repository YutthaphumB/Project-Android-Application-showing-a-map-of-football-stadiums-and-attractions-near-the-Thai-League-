package com.example.tpl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RbmfcActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;
    private View app;
    private ImageButton butNav1;
    private ImageButton butNav2;
    private ImageButton butNav3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbmfc2);
        mapView = findViewById(R.id.mapView2);
        app = findViewById(R.id.app_rbmfc2);


        butNav1 = (ImageButton) findViewById(R.id.btnNav1);
        butNav2 = (ImageButton) findViewById(R.id.btnNav2);
        butNav3 = (ImageButton) findViewById(R.id.btnNav3);

        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);

        butNav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 13.700603856908254, 99.75652043841168 (Label which you want)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        butNav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 13.640919431000755, 99.90002453089113 (Label which you want)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        butNav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 13.569691943886657, 99.77533842579126 (Label which you want)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng team = new LatLng(13.522183160615702, 99.76979608465817);
        mMap.addMarker(new MarkerOptions().position(team).title("สนาม มิตรผล สเตเดี้ยม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_rbmfc)));

        LatLng a1 = new LatLng(13.700603856908254, 99.75652043841168 );
        mMap.addMarker(new MarkerOptions().position(a1).title("วัดถ้ำน้ำ"));

        LatLng a2 = new LatLng(13.640919431000755, 99.90002453089113  );
        mMap.addMarker(new MarkerOptions().position(a2).title("Secret Space"));

        LatLng a3 = new LatLng(13.569691943886657, 99.77533842579126 );
        mMap.addMarker(new MarkerOptions().position(a3).title("อุทยานหินเขางู"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(team, 9));
    }


    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}