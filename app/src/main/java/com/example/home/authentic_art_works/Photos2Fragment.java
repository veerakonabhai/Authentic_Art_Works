package com.example.home.authentic_art_works;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Photos2Fragment extends Fragment {

    ArrayList<Photos2Adapter.Photos2> photos;
    Photos2Adapter adapter;
    Photos2Adapter.Photos2 photo;
    GridView gv;
    View view;
    public Photos2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_photos2, container, false);
        gv=(GridView)view.findViewById(R.id.gvinphotos2);
        photos=new ArrayList<>();
        photo=new Photos2Adapter.Photos2(R.drawable.img1,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos2Adapter.Photos2(R.drawable.img2,"dddddddddd","Cardiologist");
        photos.add(photo);
        photo=new Photos2Adapter.Photos2(R.drawable.img3,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos2Adapter.Photos2(R.drawable.img1,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos2Adapter.Photos2(R.drawable.img2,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos2Adapter.Photos2(R.drawable.img3,"dddddddddd","Ornithologist");
        photos.add(photo);
        adapter=new Photos2Adapter(this.getActivity(),photos);
        gv.setAdapter(adapter);
        return view;
    }

    @Override
    public String toString() {
        return "Photos2";
    }
}
class Photos2Adapter extends BaseAdapter {

    static class Photos2{
        int imageid;
        String title,desig;
        Photos2(int imageid,String title,String desig){
            this.imageid=imageid;
            this.title=title;
            this.desig=desig;
        }

        public int getImageid() {
            return imageid;
        }

        public void setImageid(int imageid) {
            this.imageid = imageid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesig() {
            return desig;
        }

        public void setDesig(String desig) {
            this.desig = desig;
        }
    }
    ArrayList<Photos2> values;
    Photos2 photo;
    Context mcontext;
    LayoutInflater inflater;
    ImageView iv;
    TextView tv1,tv2;
    Photos2Adapter(Context mcontext,ArrayList<Photos2> values){
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
            convertView=inflater.inflate(R.layout.leader,parent,false);
        }
        iv=(ImageView)convertView.findViewById(R.id.img_leader);
        tv1=(TextView)convertView.findViewById(R.id.name_leader);
        tv2=(TextView)convertView.findViewById(R.id.desg_leader);

        photo=values.get(position);

        iv.setImageResource(photo.getImageid());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tv1.setText(photo.getTitle());
        tv2.setText(photo.getDesig());
        return convertView;

    }
}
