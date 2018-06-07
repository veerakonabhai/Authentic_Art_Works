package com.example.home.authentic_art_works;


import android.content.Context;
import android.content.Intent;
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
public class Photos3Fragment extends Fragment {
    ArrayList<Photos3Adapter.Photos3> photos;
    Photos3Adapter adapter;
    Photos3Adapter.Photos3 photo;
    GridView gv;
    View view;
    public Photos3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_photos3, container, false);
        gv=(GridView)view.findViewById(R.id.gvinphotos3);
        photos=new ArrayList<>();
        photo=new Photos3Adapter.Photos3(R.drawable.img1,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos3Adapter.Photos3(R.drawable.img2,"dddddddddd","Cardiologist");
        photos.add(photo);
        photo=new Photos3Adapter.Photos3(R.drawable.img3,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos3Adapter.Photos3(R.drawable.img1,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos3Adapter.Photos3(R.drawable.img2,"dddddddddd","Ornithologist");
        photos.add(photo);
        photo=new Photos3Adapter.Photos3(R.drawable.img3,"dddddddddd","Ornithologist");
        photos.add(photo);
        adapter=new Photos3Adapter(this.getActivity(),photos);
        gv.setAdapter(adapter);
        return view;
    }

    @Override
    public String toString() {
        return "Photos3";
    }
}
class Photos3Adapter extends BaseAdapter {

    static class Photos3{
        int imageid;
        String title,desig;
        Photos3(int imageid,String title,String desig){
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
    ArrayList<Photos3> values;
    Photos3 photo;
    Context mcontext;
    LayoutInflater inflater;
    ImageView iv;
    TextView tv1,tv2;
    Photos3Adapter(Context mcontext,ArrayList<Photos3> values){
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
                Intent i=new Intent(mcontext,ImageFullActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("image",photo.getImageid());
                i.putExtra("title",photo.getTitle());
                i.putExtra("desc",photo.getDesig());
                mcontext.startActivity(i);
            }
        });
        tv1.setText(photo.getTitle());
        tv2.setText(photo.getDesig());
        return convertView;

    }
}
