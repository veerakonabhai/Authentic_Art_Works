package com.example.home.authentic_art_works;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MediaFragment extends Fragment {

    TabLayout tb;
    ViewPager vp;
    View view;

    FragmentActivity fa;
    public MediaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for t
        // his fragment
        view=inflater.inflate(R.layout.fragment_media, container, false);
        tb = (TabLayout)view.findViewById(R.id.tabs1);
        vp = (ViewPager)view.findViewById(R.id.viewpager1);
        this.addPages();
        //    vp.setAdapter(new IndividualPageAdapter(getSupportFragmentManager()));
        tb.setupWithViewPager(vp);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        fa=(FragmentActivity) context;
        super.onAttach(context);
    }

    public void addPages(){
        MediaPageAdapter pagerAdapter=new MediaPageAdapter(fa.getSupportFragmentManager());
     //   Fragment f=new BlankFragment();
        pagerAdapter.addFragment(new MediaImagesFragment());
        pagerAdapter.addFragment(new MediaVideosFragment());
        pagerAdapter.addFragment(new MediaFilesFragment());
//        pagerAdapter.addFragment(new AboutUsFragment());
        //SET ADAPTER TO VP
        vp.setAdapter(pagerAdapter);
    }
    @Override
    public String toString() {
        return "Media";
    }
}
