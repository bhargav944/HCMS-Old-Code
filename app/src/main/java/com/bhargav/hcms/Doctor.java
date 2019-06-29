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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Doctor extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        if(!isConnected(Doctor.this)) buildDialog(Doctor.this).show();
        else {
            Toast.makeText(Doctor.this,R.string.doctordetails, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_doctor);
        }

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Doctor");
        mDatabase.keepSynced(true);

        mBlogList = (RecyclerView) findViewById(R.id.myrecycleview1);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blogs,BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blogs, BlogViewHolder>
                (Blogs.class, R.layout.blogs_row,Doctor.BlogViewHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(Doctor.BlogViewHolder viewHolder, Blogs model, int position) {
                viewHolder.setDoctor(model.getDoctor());
                viewHolder.setHosp(model.getHosp());
                viewHolder.setDesi(model.getDesi());
                viewHolder.setGen(model.getGen());
                viewHolder.setEmail(model.getEmail());
                viewHolder.setImage(getBaseContext(), model.getImage());
            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public BlogViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setDoctor(String doctor)
        {
            TextView doctor_name = (TextView) mView.findViewById(R.id.doctor_name);
            doctor_name.setText(doctor);
        }
        public void setHosp(String hosp)
        {
            TextView hos_name = (TextView) mView.findViewById(R.id.hos_name);
            hos_name.setText(hosp);
        }
        public void setDesi(String desi)
        {
            TextView doctor_desi = (TextView) mView.findViewById(R.id.doctor_desi);
            doctor_desi.setText(desi);
        }
        public void setEmail(String email)
        {
            TextView doctor_email = (TextView) mView.findViewById(R.id.doctor_email);
            doctor_email.setText(email);
        }
        public void setGen(String gen)
        {
            TextView gender = (TextView) mView.findViewById(R.id.gender);
            gender.setText(gen);
        }
        public void setImage(Context ctx, String image){
            ImageView post_image = (ImageView) mView.findViewById(R.id.doctor_image);
            Picasso.with(ctx).load(image).into(post_image);
        }
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
            Intent i = new Intent(Doctor.this,Settings.class);
            startActivity(i);
        }
        if (id == R.id.feedback) {
            Intent i = new Intent(Doctor.this,Feedback.class);
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
            Intent i = new Intent(Doctor.this,PortalPage.class);
            startActivity(i);
        } else if (id == R.id.nav_doctor) {
            Intent i = new Intent(Doctor.this,Doctor.class);
            startActivity(i);
        } else if (id == R.id.nav_googlemap) {
            Intent i = new Intent(Doctor.this,GoogleMap.class);
            startActivity(i);
        } else if (id == R.id.nav_tophospital) {
            Intent i = new Intent(Doctor.this,TopHsp.class);
            startActivity(i);
        } else if (id == R.id.nav_hospital) {
            Intent i = new Intent(Doctor.this,Hospital.class);
            startActivity(i);
        } else if (id == R.id.nav_donateblood) {
            Intent i = new Intent(Doctor.this,DonateBld.class);
            startActivity(i);
        } else if (id == R.id.nav_message) {
            Intent i = new Intent(Doctor.this,Msg.class);
            startActivity(i);
        } else if (id == R.id.nav_call) {
            Intent i = new Intent(Doctor.this,Calls.class);
            startActivity(i);
        } else if (id == R.id.nav_vitamins) {
            Intent i = new Intent(Doctor.this,Vitamin.class);
            startActivity(i);
        } else if (id == R.id.nav_totalhealth) {
            Intent i = new Intent(Doctor.this,TotalHlth.class);
            startActivity(i);
        } else if (id == R.id.nav_alarm) {
            Intent i = new Intent(Doctor.this,Alrm.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(Doctor.this,Settings.class);
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Doctor.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
