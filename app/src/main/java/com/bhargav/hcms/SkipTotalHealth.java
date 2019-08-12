package com.bhargav.hcms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bhargav.hcms.TotalHealthTips.BackPain;
import com.bhargav.hcms.TotalHealthTips.Cough;
import com.bhargav.hcms.TotalHealthTips.Dandruff;
import com.bhargav.hcms.TotalHealthTips.DietPlan;
import com.bhargav.hcms.TotalHealthTips.Exercise;
import com.bhargav.hcms.TotalHealthTips.FaceCare;
import com.bhargav.hcms.TotalHealthTips.HairGrowth;
import com.bhargav.hcms.TotalHealthTips.HairLoss;
import com.bhargav.hcms.TotalHealthTips.HeadAche;
import com.bhargav.hcms.TotalHealthTips.JointPain;
import com.bhargav.hcms.TotalHealthTips.Pimples;
import com.bhargav.hcms.TotalHealthTips.RoutineMaker;
import com.bhargav.hcms.TotalHealthTips.Scars;
import com.bhargav.hcms.TotalHealthTips.StomachAche;
import com.bhargav.hcms.TotalHealthTips.SunBurn;
import com.bhargav.hcms.TotalHealthTips.WorkoutManagement;

public class SkipTotalHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_total_health);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Total Health Tips");
        getSupportActionBar().setIcon(getDrawable(R.drawable.totalhealth));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void dietplan(View view) {
        Intent i = new Intent(SkipTotalHealth.this, DietPlan.class);
        startActivity(i);
    }
    public void exercise(View view) {
        Intent i = new Intent(SkipTotalHealth.this, Exercise.class);
        startActivity(i);
    }
    public void routinemaker(View view) {
        Intent i = new Intent(SkipTotalHealth.this, RoutineMaker.class);
        startActivity(i);
    }
    public void workoutmanagement(View view){
        Intent i = new Intent(SkipTotalHealth.this, WorkoutManagement.class);
        startActivity(i);
    }
    public void pimples(View view) {
        Intent i = new Intent(SkipTotalHealth.this, Pimples.class);
        startActivity(i);
    }
    public void scars(View view) {
        Intent i = new Intent(SkipTotalHealth.this, Scars.class);
        startActivity(i);
    }
    public void facecare(View view) {
        Intent i = new Intent(SkipTotalHealth.this, FaceCare.class);
        startActivity(i);
    }
    public void hairloss(View view) {
        Intent i = new Intent(SkipTotalHealth.this, HairLoss.class);
        startActivity(i);
    }
    public void dandruff(View view) {
        Intent i = new Intent(SkipTotalHealth.this, Dandruff.class);
        startActivity(i);
    }
    public void hairgrowth(View view) {
        Intent i = new Intent(SkipTotalHealth.this, HairGrowth.class);
        startActivity(i);
    }
    public void cough(View view) {
        Intent i = new Intent(SkipTotalHealth.this, Cough.class);
        startActivity(i);
    }
    public void stomachache(View view) {
        Intent i = new Intent(SkipTotalHealth.this, StomachAche.class);
        startActivity(i);
    }
    public void headache(View view) {
        Intent i = new Intent(SkipTotalHealth.this, HeadAche.class);
        startActivity(i);
    }
    public void backpain(View view) {
        Intent i = new Intent(SkipTotalHealth.this, BackPain.class);
        startActivity(i);
    }
    public void jointpain(View view) {
        Intent i = new Intent(SkipTotalHealth.this, JointPain.class);
        startActivity(i);
    }
    public void sunburn(View view) {
        Intent i = new Intent(SkipTotalHealth.this, SunBurn.class);
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
            Intent i = new Intent(SkipTotalHealth.this,LoginActivity.class);
            startActivity(i);
        }
        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
