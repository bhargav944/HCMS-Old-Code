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

import com.bhargav.hcms.TotalHealthTips.BackPain;
import com.bhargav.hcms.TotalHealthTips.Cough;
import com.bhargav.hcms.TotalHealthTips.Dandruff;
import com.bhargav.hcms.TotalHealthTips.DietPlan;
import com.bhargav.hcms.TotalHealthTips.Exercise;
import com.bhargav.hcms.TotalHealthTips.FaceCare;
import com.bhargav.hcms.TotalHealthTips.HairGrowth;
import com.bhargav.hcms.TotalHealthTips.HairLoss;
import com.bhargav.hcms.TotalHealthTips.HeadAche;
import com.bhargav.hcms.TotalHealthTips.JointPain;
import com.bhargav.hcms.TotalHealthTips.Pimples;
import com.bhargav.hcms.TotalHealthTips.RoutineMaker;
import com.bhargav.hcms.TotalHealthTips.Scars;
import com.bhargav.hcms.TotalHealthTips.StomachAche;
import com.bhargav.hcms.TotalHealthTips.SunBurn;
import com.bhargav.hcms.TotalHealthTips.WorkoutManagement;
import com.google.firebase.auth.FirebaseAuth;

public class TotalHlth extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_hlth);

        if(!isConnected(TotalHlth.this)) buildDialog(TotalHlth.this).show();
        else {
            Toast.makeText(TotalHlth.this, R.string.totalhealth, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_total_hlth);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Total Health Tips");
        getSupportActionBar().setIcon(getDrawable(R.drawable.totalhealth));

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

    public void dietplan(View view) {
        Intent i = new Intent(TotalHlth.this,DietPlan.class);
        startActivity(i);
    }
    public void exercise(View view) {
        Intent i = new Intent(TotalHlth.this,Exercise.class);
        startActivity(i);
    }
    public void routinemaker(View view) {
        Intent i = new Intent(TotalHlth.this,RoutineMaker.class);
        startActivity(i);
    }
    public void workoutmanagement(View view){
        Intent i = new Intent(TotalHlth.this,WorkoutManagement.class);
        startActivity(i);
    }
    public void pimples(View view) {
        Intent i = new Intent(TotalHlth.this,Pimples.class);
        startActivity(i);
    }
    public void scars(View view) {
        Intent i = new Intent(TotalHlth.this,Scars.class);
        startActivity(i);
    }
    public void facecare(View view) {
        Intent i = new Intent(TotalHlth.this,FaceCare.class);
        startActivity(i);
    }
    public void hairloss(View view) {
        Intent i = new Intent(TotalHlth.this,HairLoss.class);
        startActivity(i);
    }
    public void dandruff(View view) {
        Intent i = new Intent(TotalHlth.this,Dandruff.class);
        startActivity(i);
    }
    public void hairgrowth(View view) {
        Intent i = new Intent(TotalHlth.this,HairGrowth.class);
        startActivity(i);
    }
    public void cough(View view) {
        Intent i = new Intent(TotalHlth.this,Cough.class);
        startActivity(i);
    }
    public void stomachache(View view) {
        Intent i = new Intent(TotalHlth.this,StomachAche.class);
        startActivity(i);
    }
    public void headache(View view) {
        Intent i = new Intent(TotalHlth.this,HeadAche.class);
        startActivity(i);
    }
    public void backpain(View view) {
        Intent i = new Intent(TotalHlth.this,BackPain.class);
        startActivity(i);
    }
    public void jointpain(View view) {
        Intent i = new Intent(TotalHlth.this,JointPain.class);
        startActivity(i);
    }
    public void sunburn(View view) {
        Intent i = new Intent(TotalHlth.this,SunBurn.class);
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
            Intent i = new Intent(TotalHlth.this,Settings.class);
            startActivity(i);
        }
        if (id == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(TotalHlth.this, LoginActivity.class);
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
            Intent i = new Intent(TotalHlth.this,PortalPage.class);
            startActivity(i);
        } else if (id == R.id.nav_doctor) {
            Intent i = new Intent(TotalHlth.this,Doctor.class);
            startActivity(i);
        } else if (id == R.id.nav_googlemap) {
            Intent i = new Intent(TotalHlth.this,GoogleMap.class);
            startActivity(i);
        } else if (id == R.id.nav_tophospital) {
            Intent i = new Intent(TotalHlth.this,TopHsp.class);
            startActivity(i);
        } else if (id == R.id.nav_hospital) {
            Intent i = new Intent(TotalHlth.this,Hospital.class);
            startActivity(i);
        } else if (id == R.id.nav_donateblood) {
            Intent i = new Intent(TotalHlth.this,DonateBld.class);
            startActivity(i);
        } else if (id == R.id.nav_message) {
            Intent i = new Intent(TotalHlth.this,Msg.class);
            startActivity(i);
        } else if (id == R.id.nav_call) {
            Intent i = new Intent(TotalHlth.this,Calls.class);
            startActivity(i);
        } else if (id == R.id.nav_vitamins) {
            Intent i = new Intent(TotalHlth.this,Vitamin.class);
            startActivity(i);
        } else if (id == R.id.nav_totalhealth) {
            Intent i = new Intent(TotalHlth.this,TotalHlth.class);
            startActivity(i);
        } else if (id == R.id.nav_alarm) {
            Intent i = new Intent(TotalHlth.this,Alrm.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(TotalHlth.this,Settings.class);
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(TotalHlth.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
