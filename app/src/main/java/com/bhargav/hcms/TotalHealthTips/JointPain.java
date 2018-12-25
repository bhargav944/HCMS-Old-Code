package com.bhargav.hcms.TotalHealthTips;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.bhargav.hcms.AboutUs;
import com.bhargav.hcms.ContactUs;
import com.bhargav.hcms.Feedback;
import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.PortalPage;
import com.bhargav.hcms.R;
import com.bhargav.hcms.TotalHealthTips.PageAdapter.JointPainPageAdapter;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Joint_Pain.JointPainTab5;
import com.google.firebase.auth.FirebaseAuth;

public class JointPain extends AppCompatActivity implements JointPainTab1.OnFragmentInteractionListener,JointPainTab2.OnFragmentInteractionListener,JointPainTab3.OnFragmentInteractionListener,JointPainTab4.OnFragmentInteractionListener,JointPainTab5.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joint_pain);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy3));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy4));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.remedy5));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final JointPainPageAdapter adapter = new JointPainPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
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
            Intent i = new Intent(JointPain.this,AboutUs.class);
            startActivity(i);
        }
        if (id== R.id.title2){
            Intent i = new Intent(JointPain.this,ContactUs.class);
            startActivity(i);
        }
        if (id== R.id.title3){
            Intent i = new Intent(JointPain.this,Feedback.class);
            startActivity(i);
        }
        if (id== R.id.title4){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(JointPain.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (id== R.id.title15){
            Intent i = new Intent(JointPain.this,PortalPage.class);
            startActivity(i);
        }
        if (id== R.id.title16){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(JointPain.this, LoginActivity.class);
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
