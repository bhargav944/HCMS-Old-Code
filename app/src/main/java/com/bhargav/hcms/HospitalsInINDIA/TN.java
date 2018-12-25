package com.bhargav.hcms.HospitalsInINDIA;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Chennai;
import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Coimbatore;
import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Hosur;
import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Madurai;
import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Ooty;
import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Salem;
import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Thanjavur;
import com.bhargav.hcms.HospitalsInINDIA.Tamil_Nadu.Vellore;
import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.R;
import com.bhargav.hcms.Settings;
import com.google.firebase.auth.FirebaseAuth;

public class TN extends AppCompatActivity {

    ListView listview;
    ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.tn);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        listview = (ListView) findViewById(R.id.list_item);

        mAdapter = new ArrayAdapter(TN.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Tamil_Nadu));
        listview.setAdapter(mAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TN.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent myIntent = new Intent(view.getContext(), Chennai.class);
                    startActivityForResult(myIntent,0);
                }
                if(position==1) {
                    Intent myIntent = new Intent(view.getContext(), Madurai.class);
                    startActivityForResult(myIntent, 1);
                }
                if(position==2) {
                    Intent myIntent = new Intent(view.getContext(), Coimbatore.class);
                    startActivityForResult(myIntent, 2);
                }
                if(position==3) {
                    Intent myIntent = new Intent(view.getContext(), Salem.class);
                    startActivityForResult(myIntent, 3);
                }
                if(position==4) {
                    Intent myIntent = new Intent(view.getContext(), Thanjavur.class);
                    startActivityForResult(myIntent, 4);
                }
                if(position==5) {
                    Intent myIntent = new Intent(view.getContext(), Vellore.class);
                    startActivityForResult(myIntent, 5);
                }
                if(position==6) {
                    Intent myIntent = new Intent(view.getContext(), Ooty.class);
                    startActivityForResult(myIntent, 6);
                }
                if(position==7) {
                    Intent myIntent = new Intent(view.getContext(), Hosur.class);
                    startActivityForResult(myIntent, 7);
                }
            }
        });
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
            Intent i = new Intent(TN.this, Settings.class);
            startActivity(i);
        }
        if (id == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(TN.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
