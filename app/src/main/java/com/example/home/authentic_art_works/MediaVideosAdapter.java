package com.example.home.authentic_art_works;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by home on 16-May-18.
 */

public class MediaVideosAdapter extends BaseAdapter {

    public static class Media{
        String title;
        int image;

        public Media(String title,int img){
            this.title=title;
            this.image=img;
        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    ArrayList<MediaVideosAdapter.Media> media;
    Context mcontext;
    LayoutInflater inflater;
    TextView tv1;
    ImageView img;

    public MediaVideosAdapter(Context mc,ArrayList<MediaVideosAdapter.Media> media){
        this.mcontext=mc;
        this.media=media;

    }
    @Override
    public int getCount() {
        return media.size();
    }

    @Override
    public Object getItem(int i) {
        return media.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.media,parent,false);
        }
        tv1=(TextView)convertView.findViewById(R.id.title);
        img=(ImageView)convertView.findViewById(R.id.folder_icon);
        final MediaVideosAdapter.Media m=media.get(position);
        tv1.setText(m.getTitle());
        img.setImageResource(m.getImage());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mcontext,MediaVideosActivity.class);
                Toast.makeText(mcontext,"HMM",Toast.LENGTH_SHORT).show();
                mcontext.startActivity(i);
            }
        });
        return convertView;
    }
}

