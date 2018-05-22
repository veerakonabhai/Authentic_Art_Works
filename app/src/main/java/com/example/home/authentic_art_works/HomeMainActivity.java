package com.example.home.authentic_art_works;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
    cardsAdapter adapter;
    ArrayList<card> cardList,cardList2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       // getLayoutInflater().


//        prepareCards();
      /*  FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.gridview,frame);
*/
        //prepareCards();
        //cardList.clear();
        cardList=new ArrayList<>();

        final int[] images = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3
        };
         card c =new card(4,3,"veera","bad boy",images[0]);
        cardList.add(c);

        c =new card(4,3,"veera nlsdnlldnsv  dvnlkdalkv davknlvdaknvla dnlkavnl","bad boy",images[1]);
        cardList.add(c);

        c =new card(4,0,"veera","bad boy",images[2]);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",images[1]);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",images[0]);
        cardList.add(c);
        gridView=(GridView)findViewById(R.id.gridView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                gridView=(GridView)findViewById(R.id.gridView);
                card c=new card(34,4,"undertaker","dead man is back in full flow",images[0]);
                cardList.add(c);
                adapter=new cardsAdapter(HomeMainActivity.this,cardList);
                gridView.setAdapter(adapter);
            }
        });

        adapter=new cardsAdapter(HomeMainActivity.this,cardList);

        // RecyclerView.LayoutManager mLayoutmanager = new GridLayoutManager(this,2);
        // recyclerView.setLayoutManager(mLayoutmanager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
        gridView.setAdapter(adapter);

        final SwipeRefreshLayout mySwipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swiperefresh);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Toast.makeText(HomeMainActivity.this,"Refresh is called",Toast.LENGTH_LONG).show();

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        cardList=new ArrayList<>();
                        int[] images = new int[]{
                                R.drawable.img1,
                                R.drawable.img2,
                                R.drawable.img3
                        };
                        card c =new card(4,3,"ganesh","bad boy",images[0]);
                        cardList.add(c);

                        c =new card(4,4,"veera nlsdnlldnsv  dvnlkdalkv davknlvdaknvla dnlkavnl","bad boy",images[1]);
                        cardList.add(c);

                        c =new card(44,0,"ganesh","bad boy",images[2]);
                        cardList.add(c);

                        c =new card(84,145,"veera","bad boy",images[1]);
                        cardList.add(c);

                        c =new card(4,3,"veera","bad boy",images[0]);
                        cardList.add(c);
                 //       gridView=(GridView)findViewById(R.id.gridView);

                        adapter=new cardsAdapter(HomeMainActivity.this,cardList);

                        // RecyclerView.LayoutManager mLayoutmanager = new GridLayoutManager(this,2);
                        // recyclerView.setLayoutManager(mLayoutmanager);
                        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
                        // recyclerView.setItemAnimator(new DefaultItemAnimator());
                        gridView.setAdapter(adapter);

                        mySwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );


    }
    public void prepareCards(){
        int[] images = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3
        };
        card c =new card(4,3,"veera","bad boy",images[0]);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",images[1]);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",images[2]);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",images[1]);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",images[0]);
        cardList.add(c);
        //adapter.notifyDataSetChanged();

    }




   /* public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }


    //Converting dp to pixel

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    */

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
        getMenuInflater().inflate(R.menu.home_main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
