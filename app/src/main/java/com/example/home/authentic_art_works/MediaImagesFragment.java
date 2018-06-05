package com.example.home.authentic_art_works;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MediaImagesFragment extends Fragment {
    MediaImagesAdapter ma;
    MediaImagesAdapter.Media media;
    GridView gv;
    ArrayList<MediaImagesAdapter.Media> values;
    View view;

    public MediaImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.from(getActivity()).inflate(R.layout.fragment_media_images, container, false);
        values=new ArrayList<>();
        media=new MediaImagesAdapter.Media("veera",R.drawable.image);
        values.add(media);
        media=new MediaImagesAdapter.Media("john cena",R.drawable.image);
        values.add(media);
        media=new MediaImagesAdapter.Media("undertaker",R.drawable.image);
        values.add(media);
        media=new MediaImagesAdapter.Media("roman reigns",R.drawable.image);
        values.add(media);
        media=new MediaImagesAdapter.Media("ganesh",R.drawable.image);
        values.add(media);
        media=new MediaImagesAdapter.Media("kaushik",R.drawable.image);
        values.add(media);
        media=new MediaImagesAdapter.Media("brock lesnar",R.drawable.image);
        values.add(media);

        gv=(GridView) view.findViewById(R.id.gv);
        ma=new MediaImagesAdapter(this.getActivity(),values);
        gv.setAdapter(ma);
        final SwipeRefreshLayout sr=(SwipeRefreshLayout)view.findViewById(R.id.swiperefresh2);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"Hello refreshed in images in mediafiles",Toast.LENGTH_SHORT).show();
                sr.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public String toString() {
        return "Images";
    }

}
