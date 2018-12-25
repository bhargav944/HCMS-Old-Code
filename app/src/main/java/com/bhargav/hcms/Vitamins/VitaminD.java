package com.bhargav.hcms.Vitamins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.PortalPage;
import com.bhargav.hcms.R;
import com.google.firebase.auth.FirebaseAuth;

public class VitaminD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin_d);

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
        int id=item.getItemId();
        if (id== R.id.title1){
            Intent i = new Intent(VitaminD.this,VitaminA.class);
            startActivity(i);
        }
        if (id== R.id.title2){
            Intent i = new Intent(VitaminD.this,VitaminB1.class);
            startActivity(i);
        }
        if (id== R.id.title3){
            Intent i = new Intent(VitaminD.this,VitaminB2.class);
            startActivity(i);
        }
        if (id== R.id.title4){
            Intent i = new Intent(VitaminD.this,VitaminB3.class);
            startActivity(i);
        }
        if (id== R.id.title5){
            Intent i = new Intent(VitaminD.this,VitaminB5.class);
            startActivity(i);
        }
        if (id== R.id.title6){
            Intent i = new Intent(VitaminD.this,VitaminB6.class);
            startActivity(i);
        }
        if (id== R.id.title7){
            Intent i = new Intent(VitaminD.this,VitaminB7.class);
            startActivity(i);
        }
        if (id== R.id.title8){
            Intent i = new Intent(VitaminD.this,VitaminB9.class);
            startActivity(i);
        }
        if (id== R.id.title9){
            Intent i = new Intent(VitaminD.this,VitaminB12.class);
            startActivity(i);
        }
        if (id== R.id.title10){
            Intent i = new Intent(VitaminD.this,VitaminC.class);
            startActivity(i);
        }
        if (id== R.id.title11){
            Intent i = new Intent(VitaminD.this,VitaminD.class);
            startActivity(i);
        }
        if (id== R.id.title12){
            Intent i = new Intent(VitaminD.this,VitaminE.class);
            startActivity(i);
        }
        if (id== R.id.title13){
            Intent i = new Intent(VitaminD.this,VitaminK.class);
            startActivity(i);
        }
        if (id== R.id.title14){
            Intent i = new Intent(VitaminD.this,PortalPage.class);
            startActivity(i);
        }
        if (id== R.id.title15){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(VitaminD.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
