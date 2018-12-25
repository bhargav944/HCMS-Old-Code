package com.bhargav.hcms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Button button = (Button) findViewById(R.id.feedback);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "bhargav.gurramkonda@gmail.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback HCMS");
                Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater hardwaremenu = getMenuInflater();
        hardwaremenu.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.sendEmail:
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "bhargav.gurramkonda@gmail.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback HCMS");
                Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
                return true;
        }
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
