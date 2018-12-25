package com.bhargav.hcms;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void showChangeLanguageDialog() {

        final String[] listItems = {"English", "తెలుగు", "French" , "हिंदी"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ContactUs.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i == 0) {
                    setLocale("en");
                    recreate();
                }
                else if(i == 1) {
                    setLocale("te");
                    recreate();
                }
                else if(i == 2) {
                    setLocale("fr");
                    recreate();
                }
                else if(i == 3) {
                    setLocale("hi");
                    recreate();
                }

                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }
    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.title1) {
            Intent i = new Intent(ContactUs.this, AboutUs.class);
            startActivity(i);
        }
        if (id == R.id.title2) {
            showChangeLanguageDialog();
        }
        if (id == R.id.title3) {
            Intent i = new Intent(ContactUs.this, Feedback.class);
            startActivity(i);
        }
        if (id == R.id.title4) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(ContactUs.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (id== R.id.title15){
            Intent i = new Intent(ContactUs.this,PortalPage.class);
            startActivity(i);
        }
        if (id== R.id.title16){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(ContactUs.this, LoginActivity.class);
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
