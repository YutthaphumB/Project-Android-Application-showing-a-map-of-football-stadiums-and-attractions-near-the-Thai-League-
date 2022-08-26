package com.example.tpl;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

public class BgpuActivity3 extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;
    private View app;
    private ImageButton butNav1;
    private ImageButton butNav2;
    private ImageButton butNav3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgpu3);
        mapView = findViewById(R.id.mapView2);
        app = findViewById(R.id.app_bgpu);
        Drawable bg = app.getBackground();
        bg.setAlpha(200);

        butNav1 = (ImageButton) findViewById(R.id.btnNav1);
        butNav2 = (ImageButton) findViewById(R.id.btnNav2);
        butNav3 = (ImageButton) findViewById(R.id.btnNav3);

        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);

        butNav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 14.129835779147816, 100.72571969719704 (Label which you want)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        butNav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 13.994731097929316, 100.6755264125399 (Label which you want)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        butNav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 13.984376629031997, 100.77659218185067 (Label which you want)";
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
        LatLng team = new LatLng(14.00075946211086, 100.6793351971954);
        mMap.addMarker(new MarkerOptions().position(team).title("ลีโอ สเตเดี้ยม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bgpu)));


        LatLng a1 = new LatLng(14.129835779147816, 100.72571969719704);
        mMap.addMarker(new MarkerOptions().position(a1).title("วัดปัญญานันทาราม"));

        LatLng a2 = new LatLng(13.994731097929316, 100.6755264125399);
        mMap.addMarker(new MarkerOptions().position(a2).title("ดรีมเวิลด์ (Dream world)"));

        LatLng a3 = new LatLng(13.984376629031997, 100.77659218185067);
        mMap.addMarker(new MarkerOptions().position(a3).title("วัดดอนใหญ่ "));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(team, 10));
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