package com.example.tpl;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyHome;
    private View app_home;

    String sTeam[], sStadium[];
    int images[] = {R.drawable.bgpu, R.drawable.brutd, R.drawable.bufc, R.drawable.chon, R.drawable.cmutd, R.drawable.crutd, R.drawable.kkutd, R.drawable.mtutd, R.drawable.npfc,
            R.drawable.nrmfc, R.drawable.polfc, R.drawable.ptprach, R.drawable.rbmfc, R.drawable.spc, R.drawable.spfc, R.drawable.tpfc};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyHome = findViewById(R.id.recyclerHome);
        app_home = findViewById(R.id.homeapp);
        Drawable bg = app_home.getBackground();
        bg.setAlpha(200);

        sTeam = getResources().getStringArray(R.array.teamT1);
        sStadium = getResources().getStringArray(R.array.stadium);

        MyAdapter myAdap = new MyAdapter(this, sTeam, sStadium, images);
        recyHome.setAdapter(myAdap);
        recyHome.setLayoutManager(new LinearLayoutManager(this));


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                finish();
                return true;
            case R.id.menu2:
                this.finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}