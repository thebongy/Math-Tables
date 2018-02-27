package com.apps.thebongy.mathtables;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Log10 10-54");

        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        prevMenuItem = navigationView.getMenu().getItem(0).getSubMenu().getItem(0);
        prevMenuItem.setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        ImageView img=(ImageView) findViewById(R.id.imageView2);

        if (id == R.id.log10page1) {
            img.setImageResource(R.drawable.log10page1);
        } else if (id == R.id.log10page2) {
            img.setImageResource(R.drawable.log10page2);
        } else if (id == R.id.alogpage1) {
            img.setImageResource(R.drawable.alogpage1);
        } else if (id == R.id.alogpage2) {
            img.setImageResource(R.drawable.alogpage2);
        } else if (id == R.id.sin) {
            img.setImageResource(R.drawable.sin);
        } else if (id == R.id.cos) {
            img.setImageResource(R.drawable.cos);
        } else if (id == R.id.tan) {
            img.setImageResource(R.drawable.tan);
        } else if (id == R.id.cosec) {
            img.setImageResource(R.drawable.cosec);
        } else if (id == R.id.sec) {
            img.setImageResource(R.drawable.sec);
        } else if (id == R.id.cot){
            img.setImageResource(R.drawable.cot);
        }

        prevMenuItem.setChecked(false);
        item.setChecked(true);

        getSupportActionBar().setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        prevMenuItem = item;

        return true;
    }
}
