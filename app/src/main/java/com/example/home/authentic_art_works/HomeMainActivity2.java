package com.example.home.authentic_art_works;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class HomeMainActivity2 extends HomeMainActivity {

    GridView gridView1;
    cardsAdapter adapter;
    ArrayList<card> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
     //   getLayoutInflater().inflate(R.layout.activity_home_main2,frame);

        cardList = new ArrayList<>();

        card c =new card(4,3,"veera","bad boy",R.drawable.img3);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",R.drawable.img1);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",R.drawable.img2);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",R.drawable.img3);
        cardList.add(c);

        c =new card(4,3,"veera","bad boy",R.drawable.img2);
        cardList.add(c);
        gridView1=(GridView)findViewById(R.id.gridView);
        adapter=new cardsAdapter(HomeMainActivity2.this,cardList);

        // RecyclerView.LayoutManager mLayoutmanager = new GridLayoutManager(this,2);
        // recyclerView.setLayoutManager(mLayoutmanager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
        gridView1.setAdapter(adapter);
    }

    public void prepareCards(){
        int[] images = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3
        };

        //adapter.notifyDataSetChanged();

    }
}
