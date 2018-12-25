package com.bhargav.hcms.HospitalsInINDIA.Andhra_Pradesh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bhargav.hcms.AboutUs;
import com.bhargav.hcms.ContactUs;
import com.bhargav.hcms.Feedback;
import com.bhargav.hcms.LoginActivity;
import com.bhargav.hcms.PortalPage;
import com.bhargav.hcms.R;
import com.bhargav.hcms.TopBlog;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Kadapa extends AppCompatActivity {

    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kadapa);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Kadapa");
        mDatabase.keepSynced(true);

        mBlogList = (RecyclerView) findViewById(R.id.myrecycleview);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<TopBlog,BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<TopBlog, BlogViewHolder>
                (TopBlog.class, R.layout.top_blog,Kadapa.BlogViewHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(Kadapa.BlogViewHolder viewHolder, TopBlog model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setPhone(model.getPhone());
                viewHolder.setImage(getApplicationContext(),model.getImage());

            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public BlogViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setTitle(String title)
        {
            TextView post_title = (TextView) mView.findViewById(R.id.post_title);
            post_title.setText(title);
        }
        public void setDesc(String desc)
        {
            TextView post_desc = (TextView) mView.findViewById(R.id.post_desc);
            post_desc.setText(desc);
        }
        public void setPhone(String phone)
        {
            TextView phone_no = (TextView) mView.findViewById(R.id.phone_no);
            phone_no.setText(phone);
        }
        public void setImage(Context ctx, String image)
        {
            ImageView post_image = (ImageView) mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_image);
        }
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
            Intent i = new Intent(Kadapa.this,AboutUs.class);
            startActivity(i);
        }
        if (id== R.id.title2){
            Intent i = new Intent(Kadapa.this,ContactUs.class);
            startActivity(i);
        }
        if (id== R.id.title3){
            Intent i = new Intent(Kadapa.this,Feedback.class);
            startActivity(i);
        }
        if (id== R.id.title4){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Kadapa.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (id== R.id.title15){
            Intent i = new Intent(Kadapa.this,PortalPage.class);
            startActivity(i);
        }
        if (id== R.id.title16){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(Kadapa.this, LoginActivity.class);
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
