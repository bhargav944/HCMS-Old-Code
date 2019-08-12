package com.bhargav.hcms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bhargav.hcms.Vitamins.VitaminA;
import com.bhargav.hcms.Vitamins.VitaminB1;
import com.bhargav.hcms.Vitamins.VitaminB12;
import com.bhargav.hcms.Vitamins.VitaminB2;
import com.bhargav.hcms.Vitamins.VitaminB3;
import com.bhargav.hcms.Vitamins.VitaminB5;
import com.bhargav.hcms.Vitamins.VitaminB6;
import com.bhargav.hcms.Vitamins.VitaminB7;
import com.bhargav.hcms.Vitamins.VitaminB9;
import com.bhargav.hcms.Vitamins.VitaminC;
import com.bhargav.hcms.Vitamins.VitaminD;
import com.bhargav.hcms.Vitamins.VitaminE;
import com.bhargav.hcms.Vitamins.VitaminK;
import com.google.firebase.auth.FirebaseAuth;

public class Vitamin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin);

        if(!isConnected(Vitamin.this)) buildDialog(Vitamin.this).show();
        else {
            Toast.makeText(Vitamin.this, R.string.vitamins, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_vitamin);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Vitamins");
        getSupportActionBar().setIcon(getDrawable(R.drawable.vitamins));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public android.support.v7.app.AlertDialog.Builder buildDialog(Context c) {

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(c);
        builder.setTitle(R.string.no_internet);
        builder.setMessage(R.string.no_internet_msg);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

    public void a(View view) {
        Intent i = new Intent(this,VitaminA.class);
        startActivity(i);
    }
    public void b1(View view) {
        Intent i = new Intent(this,VitaminB1.class);
        startActivity(i);
    }
    public void b2(View view) {
        Intent i = new Intent(this,VitaminB2.class);
        startActivity(i);
    }
    public void b3(View view) {
        Intent i = new Intent(this,VitaminB3.class);
        startActivity(i);
    }
    public void b5(View view) {
        Intent i = new Intent(this,VitaminB5.class);
        startActivity(i);
    }
    public void b6(View view) {
        Intent i = new Intent(this,VitaminB6.class);
        startActivity(i);
    }
    public void b7(View view) {
        Intent i = new Intent(this,VitaminB7.class);
        startActivity(i);
    }
    public void b9(View view) {
        Intent i = new Intent(this,VitaminB9.class);
        startActivity(i);
    }
    public void b12(View view) {
        Intent i = new Intent(this,VitaminB12.class);
        startActivity(i);
    }
    public void c(View view) {
        Intent i = new Intent(this,VitaminC.class);
        startActivity(i);
    }
    public void d(View view) {
        Intent i = new Intent(this,VitaminD.class);
        startActivity(i);
    }
    public void e(View view) {
        Intent i = new Intent(this,VitaminE.class);
        startActivity(i);
    }
    public void k(View view) {
        Intent i = new Intent(this,VitaminK.class);
        startActivity(i);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.portal_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Intent i = new Intent(Vitamin.this,Settings.class);
            startActivity(i);
        }
        if (id == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Vitamin.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_livechat) {
            Intent i = new Intent(Vitamin.this,PortalPage.class);
            startActivity(i);
        } else if (id == R.id.nav_doctor) {
            Intent i = new Intent(Vitamin.this,Doctor.class);
            startActivity(i);
        } else if (id == R.id.nav_googlemap) {
            Intent i = new Intent(Vitamin.this,GoogleMap.class);
            startActivity(i);
        } else if (id == R.id.nav_tophospital) {
            Intent i = new Intent(Vitamin.this,TopHsp.class);
            startActivity(i);
        } else if (id == R.id.nav_hospital) {
            Intent i = new Intent(Vitamin.this,Hospital.class);
            startActivity(i);
        } else if (id == R.id.nav_donateblood) {
            Intent i = new Intent(Vitamin.this,DonateBld.class);
            startActivity(i);
        } else if (id == R.id.nav_message) {
            Intent i = new Intent(Vitamin.this,Msg.class);
            startActivity(i);
        } else if (id == R.id.nav_call) {
            Intent i = new Intent(Vitamin.this,Calls.class);
            startActivity(i);
        } else if (id == R.id.nav_vitamins) {
            Intent i = new Intent(Vitamin.this,Vitamin.class);
            startActivity(i);
        } else if (id == R.id.nav_totalhealth) {
            Intent i = new Intent(Vitamin.this,TotalHlth.class);
            startActivity(i);
        } else if (id == R.id.nav_alarm) {
            Intent i = new Intent(Vitamin.this,Alrm.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(Vitamin.this,Settings.class);
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Vitamin.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
