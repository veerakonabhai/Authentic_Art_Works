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
public class MediaFilesFragment extends Fragment {
    MediaFilesAdapter ma;
    MediaFilesAdapter.Media media;
    ListView lv;
    ArrayList<MediaFilesAdapter.Media> values;
    View view;

    public MediaFilesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.from(getActivity()).inflate(R.layout.fragment_media_files, container, false);
        values=new ArrayList<>();
        media=new MediaFilesAdapter.Media("veera",R.drawable.folder1);
        values.add(media);
        media=new MediaFilesAdapter.Media("john cena",R.drawable.folder1);
        values.add(media);
        media=new MediaFilesAdapter.Media("undertaker",R.drawable.folder1);
        values.add(media);
        media=new MediaFilesAdapter.Media("roman reigns",R.drawable.folder1);
        values.add(media);
        media=new MediaFilesAdapter.Media("ganesh",R.drawable.folder1);
        values.add(media);
        media=new MediaFilesAdapter.Media("kaushik",R.drawable.folder1);
        values.add(media);
        media=new MediaFilesAdapter.Media("brock lesnar",R.drawable.folder1);
        values.add(media);

        lv=(ListView)view.findViewById(R.id.lv1);
        ma=new MediaFilesAdapter(this.getActivity(),values);
        lv.setAdapter(ma);
        final SwipeRefreshLayout sr=(SwipeRefreshLayout)view.findViewById(R.id.swiperefresh4);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"Hello refreshed in files in mediafiles",Toast.LENGTH_SHORT).show();
                sr.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public String toString() {
        return "Files";
    }

}
