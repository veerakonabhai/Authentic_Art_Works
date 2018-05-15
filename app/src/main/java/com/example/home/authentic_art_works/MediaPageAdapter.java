package com.example.home.authentic_art_works;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by home on 15-May-18.
 */

public class MediaPageAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = MediaPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 3;
    ArrayList<Fragment> fragments=new ArrayList<>();

    public MediaPageAdapter(FragmentManager fm){
        super(fm);
    }
    public void addFragment(Fragment f){
        fragments.add(f);
    }

    @Override
    public Fragment getItem(int position) {

    /*           switch(position){
            case 0:return new MediaImagesFragment();//break;
            case 1:return new MediaFragment();//break;
            case 2:return new PollsFragment();
           case 3:return new AboutUsFragment();

        }*/
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).toString();
    }
}
