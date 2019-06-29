package com.bhargav.hcms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Calls extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab_call,fab_plus;
    Animation FabOpen,FabClose,FabRClockwise,FabRanticlockwise;
    boolean isOpen = false;

    String phone = "949-251-5352";

    Button btnCall;
    EditText numTxt;
    String sNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls);

        if(!isConnected(Calls.this)) buildDialog(Calls.this).show();
        else {
            Toast.makeText(Calls.this,R.string.title_activity_calls, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_calls);
        }

        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_call = (FloatingActionButton) findViewById(R.id.fab_call);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        FloatingActionButton mCallButton = (FloatingActionButton) findViewById(R.id.fab_call);
        FloatingActionButton mSmsButton = (FloatingActionButton) findViewById(R.id.fab_message);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isOpen)
                {
                    fab_call.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_call.setClickable(false);
                    isOpen = false;
                }
                else
                {
                    fab_call.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);
                    fab_call.setClickable(true);
                    isOpen = true;
                }
            }


        });

        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_DIAL);
                mIntent.setData(Uri.parse("tel:" + phone));
                if(mIntent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(mIntent);
                }else {
                    Toast.makeText(Calls.this, R.string.call_msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCall = (Button) findViewById(R.id.idbtnCall);
        numTxt = (EditText) findViewById(R.id.idNumtxt);

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

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

    public void btnCall(View v){
        Intent i = new Intent(Intent.ACTION_DIAL);
        sNum = numTxt.getText().toString();
        if(sNum.trim().isEmpty()){
            i.setData(Uri.parse("tel:9492515352"));
        }
        else{
            i.setData(Uri.parse("tel:"+sNum));
        }
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
            Intent i = new Intent(Calls.this,Settings.class);
            startActivity(i);
        }
        if (id == R.id.feedback) {
            Intent i = new Intent(Calls.this,Feedback.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_livechat) {
            Intent i = new Intent(Calls.this,PortalPage.class);
            startActivity(i);
        } else if (id == R.id.nav_doctor) {
            Intent i = new Intent(Calls.this,Doctor.class);
            startActivity(i);
        } else if (id == R.id.nav_googlemap) {
            Intent i = new Intent(Calls.this,GoogleMap.class);
            startActivity(i);
        } else if (id == R.id.nav_tophospital) {
            Intent i = new Intent(Calls.this,TopHsp.class);
            startActivity(i);
        } else if (id == R.id.nav_hospital) {
            Intent i = new Intent(Calls.this,Hospital.class);
            startActivity(i);
        } else if (id == R.id.nav_donateblood) {
            Intent i = new Intent(Calls.this,DonateBld.class);
            startActivity(i);
        } else if (id == R.id.nav_message) {
            Intent i = new Intent(Calls.this,Msg.class);
            startActivity(i);
        } else if (id == R.id.nav_call) {
            Intent i = new Intent(Calls.this,Calls.class);
            startActivity(i);
        } else if (id == R.id.nav_vitamins) {
            Intent i = new Intent(Calls.this,Vitamin.class);
            startActivity(i);
        } else if (id == R.id.nav_totalhealth) {
            Intent i = new Intent(Calls.this,TotalHlth.class);
            startActivity(i);
        } else if (id == R.id.nav_alarm) {
            Intent i = new Intent(Calls.this,Alrm.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(Calls.this,Settings.class);
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Calls.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
