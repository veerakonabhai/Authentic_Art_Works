package com.example.home.authentic_art_works;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

public class IndividualActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager vp;
    TabLayout tb;
    int gridposition;
    //LinearLayoutManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tb = (TabLayout)findViewById(R.id.tabs);
        vp = (ViewPager)findViewById(R.id.viewpager);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            gridposition = extras.getInt("grid position");
            //The key argument here must match that used in the other activity
        }

        this.addPages();
    //    vp.setAdapter(new IndividualPageAdapter(getSupportFragmentManager()));
        tb.setupWithViewPager(vp);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    public void addPages(){
        IndividualPageAdapter pagerAdapter=new IndividualPageAdapter(this.getSupportFragmentManager());
        if(gridposition==3){
            pagerAdapter.addFragment(new UpdatesFragment());
            pagerAdapter.addFragment(new MediaFragment());
            pagerAdapter.addFragment(new PollsFragment());
        }
        else{
            pagerAdapter.addFragment(new UpdatesFragment());
            pagerAdapter.addFragment(new MediaFragment());
            pagerAdapter.addFragment(new PollsFragment());
            pagerAdapter.addFragment(new FundRaiseFragment());
            pagerAdapter.addFragment(new LeadershipFragment());

            pagerAdapter.addFragment(new AboutUsFragment());
        }
        //SET ADAPTER TO VP
        vp.setAdapter(pagerAdapter);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.individual, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.updates) {
            // Handle the camera action
            vp.setCurrentItem(0);
         //   IndividualActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contentid,new UpdatesFragment()).commit();
        } else if (id == R.id.media) {
            vp.setCurrentItem(1);
       //     IndividualActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.contentid,new MediaFragment()).commit();
        } else if (id == R.id.polls) {
            vp.setCurrentItem(2);

        } else if (id == R.id.aboutus) {
            vp.setCurrentItem(3);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
