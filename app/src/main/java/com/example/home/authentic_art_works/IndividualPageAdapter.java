package com.example.home.authentic_art_works;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by home on 05-Apr-18.
 */
public class IndividualPageAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = IndividualPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 4;
    ArrayList<Fragment> fragments=new ArrayList<>();
    IndividualPageAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
/*       switch(position){
            case 0:return new UpdatesFragment();//break;
            case 1:return new MediaFragment();//break;
            case 2:return new PollsFragment();
           case 3:return new AboutUsFragment();

        }*/
        return fragments.get(position);
    }
    public void addFragment(Fragment f){
        fragments.add(f);
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position){
      /*  switch(position){
            case 0:return "Updates";
            case 1:return "Media";
            case 2:return "Polls";
            case 3:return "About us";
        }*/
        return fragments.get(position).toString();
    }
}
