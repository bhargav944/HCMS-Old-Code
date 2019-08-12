package com.bhargav.hcms.Vitamins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.PortalPage;
import com.bhargav.hcms.R;
import com.google.firebase.auth.FirebaseAuth;

public class VitaminB2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_b2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vitamin B2");
        getSupportActionBar().setIcon(getDrawable(R.drawable.b2));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vitamin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.title1){
            Intent i = new Intent(VitaminB2.this,VitaminA.class);
            startActivity(i);
        }
        if (id== R.id.title2){
            Intent i = new Intent(VitaminB2.this,VitaminB1.class);
            startActivity(i);
        }
        if (id== R.id.title3){
            Intent i = new Intent(VitaminB2.this,VitaminB2.class);
            startActivity(i);
        }
        if (id== R.id.title4){
            Intent i = new Intent(VitaminB2.this,VitaminB3.class);
            startActivity(i);
        }
        if (id== R.id.title5){
            Intent i = new Intent(VitaminB2.this,VitaminB5.class);
            startActivity(i);
        }
        if (id== R.id.title6){
            Intent i = new Intent(VitaminB2.this,VitaminB6.class);
            startActivity(i);
        }
        if (id== R.id.title7){
            Intent i = new Intent(VitaminB2.this,VitaminB7.class);
            startActivity(i);
        }
        if (id== R.id.title8){
            Intent i = new Intent(VitaminB2.this,VitaminB9.class);
            startActivity(i);
        }
        if (id== R.id.title9){
            Intent i = new Intent(VitaminB2.this,VitaminB12.class);
            startActivity(i);
        }
        if (id== R.id.title10){
            Intent i = new Intent(VitaminB2.this,VitaminC.class);
            startActivity(i);
        }
        if (id== R.id.title11){
            Intent i = new Intent(VitaminB2.this,VitaminD.class);
            startActivity(i);
        }
        if (id== R.id.title12){
            Intent i = new Intent(VitaminB2.this,VitaminE.class);
            startActivity(i);
        }
        if (id== R.id.title13){
            Intent i = new Intent(VitaminB2.this,VitaminK.class);
            startActivity(i);
        }
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
