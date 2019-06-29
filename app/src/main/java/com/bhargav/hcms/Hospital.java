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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bhargav.hcms.HospitalsInINDIA.AP;
import com.bhargav.hcms.HospitalsInINDIA.ARP;
import com.bhargav.hcms.HospitalsInINDIA.Andaman;
import com.bhargav.hcms.HospitalsInINDIA.Assam;
import com.bhargav.hcms.HospitalsInINDIA.Bihar;
import com.bhargav.hcms.HospitalsInINDIA.Chhattisgarh;
import com.bhargav.hcms.HospitalsInINDIA.Dadra;
import com.bhargav.hcms.HospitalsInINDIA.Daman;
import com.bhargav.hcms.HospitalsInINDIA.Delhi;
import com.bhargav.hcms.HospitalsInINDIA.Goa;
import com.bhargav.hcms.HospitalsInINDIA.Gujarat;
import com.bhargav.hcms.HospitalsInINDIA.Haryana;
import com.bhargav.hcms.HospitalsInINDIA.Himachal;
import com.bhargav.hcms.HospitalsInINDIA.Jammu;
import com.bhargav.hcms.HospitalsInINDIA.Jharkhand;
import com.bhargav.hcms.HospitalsInINDIA.Karnataka;
import com.bhargav.hcms.HospitalsInINDIA.Kerala;
import com.bhargav.hcms.HospitalsInINDIA.Lakshadweep;
import com.bhargav.hcms.HospitalsInINDIA.Madhya;
import com.bhargav.hcms.HospitalsInINDIA.Maharashtra;
import com.bhargav.hcms.HospitalsInINDIA.Manipur;
import com.bhargav.hcms.HospitalsInINDIA.Meghalaya;
import com.bhargav.hcms.HospitalsInINDIA.Mizoram;
import com.bhargav.hcms.HospitalsInINDIA.Nagaland;
import com.bhargav.hcms.HospitalsInINDIA.Odisha;
import com.bhargav.hcms.HospitalsInINDIA.Puducherry;
import com.bhargav.hcms.HospitalsInINDIA.Punjab;
import com.bhargav.hcms.HospitalsInINDIA.Rajasthan;
import com.bhargav.hcms.HospitalsInINDIA.Sikkim;
import com.bhargav.hcms.HospitalsInINDIA.TN;
import com.bhargav.hcms.HospitalsInINDIA.Telangana;
import com.bhargav.hcms.HospitalsInINDIA.Tripura;
import com.bhargav.hcms.HospitalsInINDIA.UP;
import com.bhargav.hcms.HospitalsInINDIA.Uttarakhand;
import com.bhargav.hcms.HospitalsInINDIA.WB;
import com.google.firebase.auth.FirebaseAuth;

public class Hospital extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listview;
    ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        if(!isConnected(Hospital.this)) buildDialog(Hospital.this).show();
        else {
            Toast.makeText(Hospital.this, R.string.hospitals_in_states_and_cities, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_hospital);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listview = (ListView) findViewById(R.id.list_item);

        mAdapter = new ArrayAdapter(Hospital.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.States_and_Cities));
        listview.setAdapter(mAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Hospital.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent myIntent = new Intent(view.getContext(), Andaman.class);
                    startActivityForResult(myIntent,0);
                }
                if(position==1) {
                    Intent myIntent = new Intent(view.getContext(), AP.class);
                    startActivityForResult(myIntent, 1);
                }
                if(position==2) {
                    Intent myIntent = new Intent(view.getContext(), ARP.class);
                    startActivityForResult(myIntent, 2);
                }
                if(position==3) {
                    Intent myIntent = new Intent(view.getContext(), Assam.class);
                    startActivityForResult(myIntent, 3);
                }
                if(position==4) {
                    Intent myIntent = new Intent(view.getContext(), Bihar.class);
                    startActivityForResult(myIntent, 4);
                }
                if(position==5) {
                    Intent myIntent = new Intent(view.getContext(), Chhattisgarh.class);
                    startActivityForResult(myIntent, 5);
                }
                if(position==6) {
                    Intent myIntent = new Intent(view.getContext(), Dadra.class);
                    startActivityForResult(myIntent, 6);
                }
                if(position==7) {
                    Intent myIntent = new Intent(view.getContext(), Daman.class);
                    startActivityForResult(myIntent, 7);
                }
                if(position==8) {
                    Intent myIntent = new Intent(view.getContext(), Delhi.class);
                    startActivityForResult(myIntent, 8);
                }
                if(position==9) {
                    Intent myIntent = new Intent(view.getContext(), Goa.class);
                    startActivityForResult(myIntent, 9);
                }
                if(position==10) {
                    Intent myIntent = new Intent(view.getContext(), Gujarat.class);
                    startActivityForResult(myIntent, 10);
                }
                if(position==11) {
                    Intent myIntent = new Intent(view.getContext(), Haryana.class);
                    startActivityForResult(myIntent, 11);
                }
                if(position==12) {
                    Intent myIntent = new Intent(view.getContext(), Himachal.class);
                    startActivityForResult(myIntent, 12);
                }
                if(position==13) {
                    Intent myIntent = new Intent(view.getContext(), Jammu.class);
                    startActivityForResult(myIntent, 13);
                }
                if(position==14) {
                    Intent myIntent = new Intent(view.getContext(), Jharkhand.class);
                    startActivityForResult(myIntent, 14);
                }
                if(position==15) {
                    Intent myIntent = new Intent(view.getContext(), Karnataka.class);
                    startActivityForResult(myIntent, 15);
                }
                if(position==16) {
                    Intent myIntent = new Intent(view.getContext(), Kerala.class);
                    startActivityForResult(myIntent, 16);
                }
                if(position==17) {
                    Intent myIntent = new Intent(view.getContext(), Lakshadweep.class);
                    startActivityForResult(myIntent, 17);
                }
                if(position==18) {
                    Intent myIntent = new Intent(view.getContext(), Madhya.class);
                    startActivityForResult(myIntent, 18);
                }
                if(position==19) {
                    Intent myIntent = new Intent(view.getContext(), Maharashtra.class);
                    startActivityForResult(myIntent, 19);
                }
                if(position==20) {
                    Intent myIntent = new Intent(view.getContext(), Manipur.class);
                    startActivityForResult(myIntent, 20);
                }
                if(position==21) {
                    Intent myIntent = new Intent(view.getContext(), Meghalaya.class);
                    startActivityForResult(myIntent, 21);
                }
                if(position==22) {
                    Intent myIntent = new Intent(view.getContext(), Mizoram.class);
                    startActivityForResult(myIntent, 22);
                }
                if(position==23) {
                    Intent myIntent = new Intent(view.getContext(), Nagaland.class);
                    startActivityForResult(myIntent, 23);
                }
                if(position==24) {
                    Intent myIntent = new Intent(view.getContext(), Odisha.class);
                    startActivityForResult(myIntent, 24);
                }
                if(position==25) {
                    Intent myIntent = new Intent(view.getContext(), Puducherry.class);
                    startActivityForResult(myIntent, 25);
                }
                if(position==26) {
                    Intent myIntent = new Intent(view.getContext(), Punjab.class);
                    startActivityForResult(myIntent, 26);
                }
                if(position==27) {
                    Intent myIntent = new Intent(view.getContext(), Rajasthan.class);
                    startActivityForResult(myIntent, 27);
                }
                if(position==28) {
                    Intent myIntent = new Intent(view.getContext(), Sikkim.class);
                    startActivityForResult(myIntent, 28);
                }
                if(position==29) {
                    Intent myIntent = new Intent(view.getContext(), TN.class);
                    startActivityForResult(myIntent, 29);
                }
                if(position==30) {
                    Intent myIntent = new Intent(view.getContext(), Telangana.class);
                    startActivityForResult(myIntent, 30);
                }
                if(position==31) {
                    Intent myIntent = new Intent(view.getContext(), Tripura.class);
                    startActivityForResult(myIntent, 31);
                }
                if(position==32) {
                    Intent myIntent = new Intent(view.getContext(), UP.class);
                    startActivityForResult(myIntent, 32);
                }
                if(position==33) {
                    Intent myIntent = new Intent(view.getContext(), Uttarakhand.class);
                    startActivityForResult(myIntent, 33);
                }
                if(position==34) {
                    Intent myIntent = new Intent(view.getContext(), WB.class);
                    startActivityForResult(myIntent, 34);
                }
            }
        });

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
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem mSearch = menu.findItem(R.id.action_search);

        android.support.v7.widget.SearchView mSearchView = (android.support.v7.widget.SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Intent i = new Intent(Hospital.this,Settings.class);
            startActivity(i);
        }
        if (id == R.id.feedback) {
            Intent i = new Intent(Hospital.this,Feedback.class);
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
            Intent i = new Intent(Hospital.this,PortalPage.class);
            startActivity(i);
        } else if (id == R.id.nav_doctor) {
            Intent i = new Intent(Hospital.this,Doctor.class);
            startActivity(i);
        } else if (id == R.id.nav_googlemap) {
            Intent i = new Intent(Hospital.this,GoogleMap.class);
            startActivity(i);
        } else if (id == R.id.nav_tophospital) {
            Intent i = new Intent(Hospital.this,TopHsp.class);
            startActivity(i);
        } else if (id == R.id.nav_hospital) {
            Intent i = new Intent(Hospital.this,Hospital.class);
            startActivity(i);
        } else if (id == R.id.nav_donateblood) {
            Intent i = new Intent(Hospital.this,DonateBld.class);
            startActivity(i);
        } else if (id == R.id.nav_message) {
            Intent i = new Intent(Hospital.this,Msg.class);
            startActivity(i);
        } else if (id == R.id.nav_call) {
            Intent i = new Intent(Hospital.this,Calls.class);
            startActivity(i);
        } else if (id == R.id.nav_vitamins) {
            Intent i = new Intent(Hospital.this,Vitamin.class);
            startActivity(i);
        } else if (id == R.id.nav_totalhealth) {
            Intent i = new Intent(Hospital.this,TotalHlth.class);
            startActivity(i);
        } else if (id == R.id.nav_alarm) {
            Intent i = new Intent(Hospital.this,Alrm.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(Hospital.this,Settings.class);
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Hospital.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
