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

import java.net.MalformedURLException;
import java.util.ArrayList;

import static com.example.home.authentic_art_works.MediaVideosActivity.extractYoutubeId;


/**
 * A simple {@link Fragment} subclass.
 */
public class MediaVideosFragment extends Fragment {
    MediaVideosAdapter ma;
    MediaVideosAdapter.Media media;
    GridView gv;
    ArrayList<MediaVideosAdapter.Media> values;
    View view;
    String videoId,url1,url2,url3,url4;
    public MediaVideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_media_videos,container,false);
        try {
            videoId = extractYoutubeId("https://www.youtube.com/watch?v=YKrQOm3oh1A");
            url1 = "http://img.youtube.com/vi/" + videoId + "/0.jpg";
            videoId = extractYoutubeId("https://www.youtube.com/watch?v=ihbsu0MfFNg");
            url2 = "http://img.youtube.com/vi/" + videoId + "/0.jpg";
            videoId = extractYoutubeId("https://www.youtube.com/watch?v=jD9dr-PrQkY");
            url3 = "http://img.youtube.com/vi/" + videoId + "/0.jpg";
            videoId = extractYoutubeId("https://www.youtube.com/watch?v=jD9dr-PrQkY");
            url4 = "http://img.youtube.com/vi/" + videoId + "/0.jpg";

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        values=new ArrayList<>();
        media=new MediaVideosAdapter.Media("veera",url1);
        values.add(media);
        media=new MediaVideosAdapter.Media("john cena",url2);
        values.add(media);
        media=new MediaVideosAdapter.Media("undertaker",url3);
        values.add(media);
        media=new MediaVideosAdapter.Media("roman reigns",url4);
        values.add(media);
        media=new MediaVideosAdapter.Media("ganesh",url1);
        values.add(media);
        media=new MediaVideosAdapter.Media("kaushik",url2);
        values.add(media);
        media=new MediaVideosAdapter.Media("brock lesnar",url3 );
        values.add(media);

        gv=(GridView) view.findViewById(R.id.gv1);
        ma=new MediaVideosAdapter(this.getActivity(),values);
        gv.setAdapter(ma);
        final SwipeRefreshLayout sr=(SwipeRefreshLayout)view.findViewById(R.id.swiperefresh3);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"Hello refreshed in videos in mediafiles",Toast.LENGTH_SHORT).show();
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
