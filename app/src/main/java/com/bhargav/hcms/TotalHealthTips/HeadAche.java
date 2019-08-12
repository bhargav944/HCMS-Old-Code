package com.bhargav.hcms.TotalHealthTips;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bhargav.hcms.AboutUs;
import com.bhargav.hcms.ContactUs;
import com.bhargav.hcms.Feedback;
import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.PortalPage;
import com.bhargav.hcms.R;
import com.bhargav.hcms.TotalHealthTips.PageAdapter.HeadAchePageAdapter;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Head_Ache.HeadAcheTab5;
import com.google.firebase.auth.FirebaseAuth;

public class HeadAche extends AppCompatActivity implements HeadAcheTab1.OnFragmentInteractionListener,HeadAcheTab2.OnFragmentInteractionListener,HeadAcheTab3.OnFragmentInteractionListener,HeadAcheTab4.OnFragmentInteractionListener,HeadAcheTab5.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_ache);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Head Ache");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ba1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ip1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.cl1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.cof1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.yog1));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final HeadAchePageAdapter adapter = new HeadAchePageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuindividual, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id== R.id.title1){
            Intent i = new Intent(HeadAche.this,AboutUs.class);
            startActivity(i);
        }
        if (id== R.id.title2){
            Intent i = new Intent(HeadAche.this,ContactUs.class);
            startActivity(i);
        }
        if (id== R.id.title3){
            Intent i = new Intent(HeadAche.this,Feedback.class);
            startActivity(i);
        }
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
