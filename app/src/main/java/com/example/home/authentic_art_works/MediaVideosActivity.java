package com.example.home.authentic_art_works;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MediaVideosActivity extends AppCompatActivity {


    GridView gv;
    ArrayList<ActivityVideosAdapter.Video> videos;
    ActivityVideosAdapter adapter;
    ActivityVideosAdapter.Video video;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_videos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//setHomeButtonEnabled(true);



        try
        {
            String videoId=extractYoutubeId("https://www.youtube.com/watch?v=2wGSKHW2PvI");
            String img_url="http://img.youtube.com/vi/"+videoId+"/0.jpg";
            gv=(GridView)findViewById(R.id.gv4);
        videos=new ArrayList<>();
        video=new ActivityVideosAdapter.Video(img_url,videoId);
        videos.add(video);
        video=new ActivityVideosAdapter.Video(img_url,videoId);
        videos.add(video);
        video=new ActivityVideosAdapter.Video(img_url,videoId);
        videos.add(video);
        video=new ActivityVideosAdapter.Video(img_url,videoId);
        videos.add(video);
        video=new ActivityVideosAdapter.Video(img_url,videoId);
        videos.add(video);
        adapter=new ActivityVideosAdapter(this,videos);
        gv.setAdapter(adapter);
            Log.e("VideoId is->","" + videoId);

             // this is link which will give u thumnail image of that video

            // picasso jar file download image for u and set image in imagview



        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

     /*   VideoView vv=(VideoView)findViewById(R.id.vv1);

        String path="android.resource://com.example.home.authentic_art_works/"+R.raw.video1;
        Uri uri=Uri.parse(path);
        vv.setVideoURI(uri);
        vv.requestFocus();
        vv.start();*/
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    public static String extractYoutubeId(String url) throws MalformedURLException {
        String query = new URL(url).getQuery();
        String[] param = query.split("&");
        String id = null;
        for (String row : param) {
            String[] param1 = row.split("=");
            if (param1[0].equals("v")) {
                id = param1[1];
            }
        }
        return id;
    }
}
class ActivityVideosAdapter extends BaseAdapter {

    public static class Video{
        String imageurl,videourl;
        Video(String imageurl,String videourl){
            this.imageurl=imageurl;
            this.videourl=videourl;

        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getVideourl() {
            return videourl;
        }

        public void setVideourl(String videourl) {
            this.videourl = videourl;
        }


    }
    ArrayList<Video> values;
    Video video;
    Context mcontext;
    LayoutInflater inflater;
    VideoView vv;
    ActivityVideosAdapter(Context mcontext, ArrayList<Video> values){
        this.mcontext=mcontext;
        this.values=values;
    }
    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.media_videos_layout,parent,false);
        }
        ImageView iv=(ImageView)convertView.findViewById(R.id.iv1);
     //   VideoView vv=(VideoView)convertView.findViewById(R.id.vv);
        video=values.get(position);
        Picasso.get()
                .load(video.getImageurl()).placeholder(R.drawable.img2)
                .into(iv);
       ImageView iv1=(ImageView)convertView.findViewById(R.id.playid);
       iv1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent webIntent = new Intent(Intent.ACTION_VIEW,
                       Uri.parse("http://www.youtube.com/watch?v=2wGSKHW2PvI"));
               Toast.makeText(mcontext,"proceeding to youtube",Toast.LENGTH_LONG).show();
               mcontext.startActivity(webIntent);
        /*       Intent i=new Intent(mcontext,VideoActivity.class);
               i.putExtra("video url",video.getVideourl());
               mcontext.startActivity(i);*/
           }
       });
      //  Uri uri=Uri.parse(video.getUrl());
      //  vv.setVideoURI(uri);
      //  vv.requestFocus();
      //  vv.start();

    //    iv.setImageBitmap(createVideoThumbNail(video.getUrl()));
        return convertView;
    }




}

