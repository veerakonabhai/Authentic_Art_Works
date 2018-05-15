package com.example.home.authentic_art_works;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdatesFragment extends Fragment {

    ArrayList<Updates> cardlist;
    Updates updates;
    ListView lv;
    UpdatesAdapter uadapter;
 //   LinearLayoutManager lm;
    View view;
    public UpdatesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_updates, container, false);
        cardlist=new ArrayList<>();
        int[] images = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3
        };
        SimpleDateFormat s=new SimpleDateFormat("dd/M/yyyy");
        updates=new Updates("ganesh",images[0],4,s.format(new Date()));
        cardlist.add(updates);
        updates=new Updates("ganesh",images[0],8,s.format(new Date()));
        cardlist.add(updates);
        updates=new Updates("victor",images[0],4,s.format(new Date()));
        cardlist.add(updates);
        updates=new Updates("veerraaa",images[2],89,s.format(new Date()));
        cardlist.add(updates);
        updates=new Updates("ganeshaaaa",images[1],4,s.format(new Date()));
        cardlist.add(updates);
   lv=(ListView)view.findViewById(R.id.listview);
     //   lm=new LinearLayoutManager(getActivity());
        uadapter=new UpdatesAdapter(this.getActivity(),cardlist);
        lv.setAdapter(uadapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public String toString() {
        return "Updates";
    }
}
