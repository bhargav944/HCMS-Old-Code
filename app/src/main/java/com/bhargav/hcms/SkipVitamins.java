package com.bhargav.hcms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

public class SkipVitamins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_vitamins);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Vitamins");
        getSupportActionBar().setIcon(getDrawable(R.drawable.vitamins));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void a(View view) {
        Intent i = new Intent(this, VitaminA.class);
        startActivity(i);
    }
    public void b1(View view) {
        Intent i = new Intent(this, VitaminB1.class);
        startActivity(i);
    }
    public void b2(View view) {
        Intent i = new Intent(this, VitaminB2.class);
        startActivity(i);
    }
    public void b3(View view) {
        Intent i = new Intent(this, VitaminB3.class);
        startActivity(i);
    }
    public void b5(View view) {
        Intent i = new Intent(this, VitaminB5.class);
        startActivity(i);
    }
    public void b6(View view) {
        Intent i = new Intent(this, VitaminB6.class);
        startActivity(i);
    }
    public void b7(View view) {
        Intent i = new Intent(this, VitaminB7.class);
        startActivity(i);
    }
    public void b9(View view) {
        Intent i = new Intent(this, VitaminB9.class);
        startActivity(i);
    }
    public void b12(View view) {
        Intent i = new Intent(this, VitaminB12.class);
        startActivity(i);
    }
    public void c(View view) {
        Intent i = new Intent(this, VitaminC.class);
        startActivity(i);
    }
    public void d(View view) {
        Intent i = new Intent(this, VitaminD.class);
        startActivity(i);
    }
    public void e(View view) {
        Intent i = new Intent(this, VitaminE.class);
        startActivity(i);
    }
    public void k(View view) {
        Intent i = new Intent(this, VitaminK.class);
        startActivity(i);
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
            Intent i = new Intent(SkipVitamins.this,LoginActivity.class);
            startActivity(i);
        }
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
