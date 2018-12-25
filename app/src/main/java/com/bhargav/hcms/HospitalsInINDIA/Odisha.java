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

import com.bhargav.hcms.HospitalsInINDIA.Od_sha.Bhubaneswar;
import com.bhargav.hcms.HospitalsInINDIA.Od_sha.Puri;
import com.bhargav.hcms.HospitalsInINDIA.Od_sha.Sambalpur;
import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.R;
import com.bhargav.hcms.Settings;
import com.google.firebase.auth.FirebaseAuth;

public class Odisha extends AppCompatActivity {

    ListView listview;
    ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odisha);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.odisha);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        listview = (ListView) findViewById(R.id.list_item);

        mAdapter = new ArrayAdapter(Odisha.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.Odisha));
        listview.setAdapter(mAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Odisha.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent myIntent = new Intent(view.getContext(), Bhubaneswar.class);
                    startActivityForResult(myIntent,0);
                }
                if(position==1) {
                    Intent myIntent = new Intent(view.getContext(), Sambalpur.class);
                    startActivityForResult(myIntent, 1);
                }
                if(position==2) {
                    Intent myIntent = new Intent(view.getContext(), Puri.class);
                    startActivityForResult(myIntent, 2);
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
            Intent i = new Intent(Odisha.this, Settings.class);
            startActivity(i);
        }
        if (id == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Odisha.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
