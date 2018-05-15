package com.example.home.authentic_art_works;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MediaVideosFragment extends Fragment {
    MediaAdapter ma;
    MediaAdapter.Media media;
    GridView gv;
    ArrayList<MediaAdapter.Media> values;
    View view;

    public MediaVideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.from(getActivity()).inflate(R.layout.fragment_media_videos, container, false);
        values=new ArrayList<>();
        media=new MediaAdapter.Media("veera",R.drawable.video);
        values.add(media);
        media=new MediaAdapter.Media("john cena",R.drawable.video);
        values.add(media);
        media=new MediaAdapter.Media("undertaker",R.drawable.video);
        values.add(media);
        media=new MediaAdapter.Media("roman reigns",R.drawable.picture);
        values.add(media);
        media=new MediaAdapter.Media("ganesh",R.drawable.picture);
        values.add(media);
        media=new MediaAdapter.Media("kaushik",R.drawable.picture);
        values.add(media);
        media=new MediaAdapter.Media("brock lesnar",R.drawable.picture);
        values.add(media);

        gv=(GridView)view.findViewById(R.id.gv1);
        ma=new MediaAdapter(this.getActivity(),values);
        gv.setAdapter(ma);
        return view;
    }

    @Override
    public String toString() {
        return "Videos";
    }

}
