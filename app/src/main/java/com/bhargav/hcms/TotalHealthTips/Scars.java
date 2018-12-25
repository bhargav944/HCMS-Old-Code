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
import com.bhargav.hcms.TotalHealthTips.PageAdapter.ScarsPageAdapter;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab1;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab2;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab3;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab4;
import com.bhargav.hcms.TotalHealthTips.Tabs.Scars.ScarsTab5;
import com.google.firebase.auth.FirebaseAuth;

public class Scars extends AppCompatActivity implements ScarsTab1.OnFragmentInteractionListener,ScarsTab2.OnFragmentInteractionListener,ScarsTab3.OnFragmentInteractionListener,ScarsTab4.OnFragmentInteractionListener,ScarsTab5.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scars);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.lemon_juice));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.ice3));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.aloevera1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.teatree1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.honey1));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final ScarsPageAdapter adapter = new ScarsPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
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
            Intent i = new Intent(Scars.this,AboutUs.class);
            startActivity(i);
        }
        if (id== R.id.title2){
            Intent i = new Intent(Scars.this,ContactUs.class);
            startActivity(i);
        }
        if (id== R.id.title3){
            Intent i = new Intent(Scars.this,Feedback.class);
            startActivity(i);
        }
        if (id== R.id.title4){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Scars.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (id== R.id.title15){
            Intent i = new Intent(Scars.this,PortalPage.class);
            startActivity(i);
        }
        if (id== R.id.title16){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Scars.this, LoginActivity.class);
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
