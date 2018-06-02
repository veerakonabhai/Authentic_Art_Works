package com.example.home.authentic_art_works;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeadershipFragment extends Fragment {

    TabLayout tb;
    ViewPager vp;
    View view;
    FragmentActivity fa;

    public LeadershipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_leadership, container, false);
        tb = (TabLayout)view.findViewById(R.id.tabs2);
        vp = (ViewPager)view.findViewById(R.id.viewpager2);
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
        LeadershipPageAdapter pagerAdapter=new LeadershipPageAdapter(getChildFragmentManager());
        //   Fragment f=new BlankFragment();
        pagerAdapter.addFragment(new Photos1Fragment());
        pagerAdapter.addFragment(new Photos2Fragment());
        pagerAdapter.addFragment(new Photos3Fragment());
//        pagerAdapter.addFragment(new AboutUsFragment());
        //SET ADAPTER TO VP
        vp.setAdapter(pagerAdapter);
    }
    @Override
    public String toString() {
        return "Leadership";
    }

}
class LeadershipPageAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = LeadershipPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 3;
    ArrayList<Fragment> fragments=new ArrayList<>();

    public LeadershipPageAdapter(FragmentManager fm){
        super(fm);
    }
    public void addFragment(Fragment f){
        fragments.add(f);
    }

    @Override
    public Fragment getItem(int position) {
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

