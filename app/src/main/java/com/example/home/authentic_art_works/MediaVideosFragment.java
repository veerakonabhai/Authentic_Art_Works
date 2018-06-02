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
public class MediaVideosFragment extends Fragment {
    MediaVideosAdapter ma;
    MediaVideosAdapter.Media media;
    ListView gv;
    ArrayList<MediaVideosAdapter.Media> values;
    View view;

    public MediaVideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_media_videos,container,false);
        values=new ArrayList<>();
        media=new MediaVideosAdapter.Media("veera",R.drawable.youtube);
        values.add(media);
        media=new MediaVideosAdapter.Media("john cena",R.drawable.youtube);
        values.add(media);
        media=new MediaVideosAdapter.Media("undertaker",R.drawable.youtube);
        values.add(media);
        media=new MediaVideosAdapter.Media("roman reigns",R.drawable.youtube);
        values.add(media);
        media=new MediaVideosAdapter.Media("ganesh",R.drawable.youtube);
        values.add(media);
        media=new MediaVideosAdapter.Media("kaushik",R.drawable.youtube);
        values.add(media);
        media=new MediaVideosAdapter.Media("brock lesnar",R.drawable.youtube );
        values.add(media);

        gv=(ListView) view.findViewById(R.id.gv1);
        ma=new MediaVideosAdapter(this.getActivity(),values);
        gv.setAdapter(ma);
        final SwipeRefreshLayout sr=(SwipeRefreshLayout)view.findViewById(R.id.swiperefresh3);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"Hello refreshed in videos in media",Toast.LENGTH_SHORT).show();
                sr.setRefreshing(false);
            }
        });
        return view;
    }

    @Override
    public String toString() {
        return "Videos";
    }

}
