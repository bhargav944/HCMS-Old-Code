package com.bhargav.hcms;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.telecom.Call;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SkipPortal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab_message,fab_plus;
    Animation FabOpen,FabClose,FabRClockwise,FabRanticlockwise;
    boolean isOpen = false;

    String phone = "949-251-5352";

    Button btnStart;
    EditText varMsg, varPhoneNo;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_portal);

        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_message = (FloatingActionButton) findViewById(R.id.fab_message);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        FloatingActionButton mSmsButton = (FloatingActionButton) findViewById(R.id.fab_message);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isOpen)
                {
                    fab_message.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_message.setClickable(false);
                    isOpen = false;
                }
                else
                {
                    fab_message.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);
                    fab_message.setClickable(true);
                    isOpen = true;
                }
            }


        });

        mSmsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW);
                mIntent.setData(Uri.parse(R.string.sms + phone));
                if(mIntent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(mIntent);
                }else {
                    Toast.makeText(SkipPortal.this, R.string.call_msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Message");
        getSupportActionBar().setIcon(getDrawable(R.drawable.message));

        btnStart = (Button) findViewById(R.id.idbtnStart);
        varMsg = (EditText) findViewById(R.id.idTxtMsg);
        varPhoneNo = (EditText) findViewById(R.id.idTxtPhoneNo);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void sendSms(View v){
        int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED) {
            MyMessage();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
    }

    public void MyMessage(){
        String myNumber = varPhoneNo.getText().toString().trim();
        String myMsg = varMsg.getText().toString().trim();
        if(myNumber==null || myNumber.equals("") || myMsg==null || myMsg.equals("")){
            Toast.makeText(this, R.string.field_cant_be_empty,Toast.LENGTH_SHORT).show();
        } else {
            if(TextUtils.isDigitsOnly(myNumber)){
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(myNumber, null, myMsg, null, null);
                Toast.makeText(this, R.string.msg_sent, Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, R.string.integer_only, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    MyMessage();
                } else {
                    Toast.makeText(this, R.string.msg_action, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.skip_portal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {
            Intent i = new Intent(SkipPortal.this,LoginActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_message) {
            Intent i = new Intent(SkipPortal.this, SkipPortal.class);
            startActivity(i);
        } else if (id == R.id.nav_call) {
            Intent i = new Intent(SkipPortal.this, SkipCalls.class);
            startActivity(i);
        } else if (id == R.id.nav_vitamins) {
            Intent i = new Intent(SkipPortal.this, SkipVitamins.class);
            startActivity(i);
        } else if (id == R.id.nav_totalhealth) {
            Intent i = new Intent(SkipPortal.this, SkipTotalHealth.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(SkipPortal.this, SkipSettings.class);
            startActivity(i);
        } else if (id == R.id.nav_login) {
            Intent i = new Intent(SkipPortal.this, LoginActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
