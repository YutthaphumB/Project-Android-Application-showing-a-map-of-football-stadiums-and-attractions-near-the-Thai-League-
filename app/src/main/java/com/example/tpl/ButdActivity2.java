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

public class ButdActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;
    private View app;
    private ImageButton butNav1;
    private ImageButton butNav2;
    private ImageButton butNav3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butd2);
        mapView = findViewById(R.id.mapView2);
        app = findViewById(R.id.app_butd2);


        butNav1 = (ImageButton) findViewById(R.id.btnNav1);
        butNav2 = (ImageButton) findViewById(R.id.btnNav2);
        butNav3 = (ImageButton) findViewById(R.id.btnNav3);

        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);

        butNav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 14.114863413243482, 100.54000383936614 (Label which you want)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        butNav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 13.994741508311314, 100.67550495470826 (Label which you want)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        butNav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "http://maps.google.com/maps?q=loc: 13.960770016744819, 100.72096059703601 (Label which you want)";
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
        LatLng team = new LatLng(14.068227724092042, 100.59889153936543);
        mMap.addMarker(new MarkerOptions().position(team).title("สนาม ทรู สเตเดียม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_butd)));


        LatLng a1 = new LatLng(14.114863413243482, 100.54000383936614);
        mMap.addMarker(new MarkerOptions().position(a1).title("วัดโบสถ์"));

        LatLng a2 = new LatLng(13.994741508311314, 100.67550495470826);
        mMap.addMarker(new MarkerOptions().position(a2).title("ดรีมเวิลด์ (Dream world)"));

        LatLng a3 = new LatLng(13.960770016744819, 100.72096059703601);
        mMap.addMarker(new MarkerOptions().position(a3).title("สกายวอล์ค ลำลูกกา"));

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